package br.com.gamestore.loja_api.services;

import br.com.gamestore.loja_api.dto.PedidoViewDTO;
import br.com.gamestore.loja_api.model.*;
import br.com.gamestore.loja_api.repositories.PedidoRepository;
import br.com.gamestore.loja_api.repositories.UsuarioRepository;
import br.com.gamestore.loja_api.repositories.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public PedidoViewDTO buscarPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
        return new PedidoViewDTO(pedido);
    }

    @Transactional
    public Pedido finalizarCompra(String loginUsuario){

        Usuario usuario = (Usuario) usuarioRepository.findByLogin(loginUsuario);
        Carrinho carrinho = usuario.getCarrinho();

        List<ItemDoCarrinho> itensDoCarrinhos = carrinho.getItens();

        if (itensDoCarrinhos.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Seu carrinho esta vazio");
        }

        BigDecimal total = BigDecimal.ZERO;

        Pedido novoPedido = new Pedido(usuario, LocalDate.now(), null);

        Set<ItemPedido> itensDoPedido = new HashSet<>();

        for (ItemDoCarrinho itemDoCarrinho : itensDoCarrinhos){

            Jogo jogo = itemDoCarrinho.getJogo();

            if (jogo.getQuantidadeEstoque() < itemDoCarrinho.getQuantidade()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Estoque esgotado para o item: " + jogo.getNome() +
                                ". Disponível: " + jogo.getQuantidadeEstoque());
            }

            int novoEstoque = jogo.getQuantidadeEstoque() - itemDoCarrinho.getQuantidade();
            jogo.setQuantidadeEstoque(novoEstoque);

            ItemPedido novoItemPedido = new ItemPedido(
                    novoPedido,
                    jogo,
                    itemDoCarrinho.getQuantidade(),
                    jogo.getPreco()
            );
            itensDoPedido.add(novoItemPedido);

            total = total.add(jogo.getPreco().multiply(BigDecimal.valueOf(itemDoCarrinho.getQuantidade())));
        }

        novoPedido.setItens(itensDoPedido);

        novoPedido.setValorTotal(total);

        Pedido pedidoSalvo = pedidoRepository.save(novoPedido);

        carrinho.getItens().clear();
        carrinhoRepository.saveAndFlush(carrinho);

        return pedidoSalvo;
    }
}