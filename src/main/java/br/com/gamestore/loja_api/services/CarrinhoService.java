package br.com.gamestore.loja_api.services;

import br.com.gamestore.loja_api.dto.CarrinhoViewDTO;
import br.com.gamestore.loja_api.dto.ItemAtualizarDTO;
import br.com.gamestore.loja_api.dto.ItemCarrinhoViewDTO;
import br.com.gamestore.loja_api.repositories.CarrinhoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;
import br.com.gamestore.loja_api.repositories.UsuarioRepository;
import br.com.gamestore.loja_api.dto.ItemAdicionarDTO;
import br.com.gamestore.loja_api.model.Carrinho;
import br.com.gamestore.loja_api.model.ItemDoCarrinho;
import br.com.gamestore.loja_api.model.Jogo;
import br.com.gamestore.loja_api.model.Usuario;
import br.com.gamestore.loja_api.repositories.ItemDoCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarrinhoService {

    @Autowired
    private ItemDoCarrinhoRepository itemDoCarrinhoRepository;

    @Autowired
    private JogoService jogoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public void removerDoCarrinho(Long itemId, Usuario usuario) {
        Carrinho carrinho = usuario.getCarrinho();
        Optional<ItemDoCarrinho> optionalItem = itemDoCarrinhoRepository.findById(itemId);

        ItemDoCarrinho itemParaExcluir;
        if (optionalItem.isPresent()) {
            itemParaExcluir = optionalItem.get();
        } else {
            // Se o Optional estiver vazio, significa que o item não existe, então lança exceção 404 (não encontrado)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado");
        }
        if (!itemParaExcluir.getCarrinho().getId().equals(carrinho.getId())) {

            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Você não tem permição para remover esse item do carrinho");
        }
        itemDoCarrinhoRepository.delete(itemParaExcluir);

    }
    public CarrinhoViewDTO adicionarAoCarrinho(ItemAdicionarDTO dados, Usuario usuario) {
        Carrinho carrinho = usuario.getCarrinho();

        Jogo jogo = jogoService.buscarPorId(dados.jogoId());

        if (jogo.getQuantidadeEstoque() < dados.quantidade()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Estoque insuficiente. Quantidade disponível: " + jogo.getQuantidadeEstoque());
        }
        Optional<ItemDoCarrinho> optionalItem = itemDoCarrinhoRepository.findByCarrinhoIdAndJogoId(carrinho.getId(), jogo.getId());

        if (optionalItem.isPresent()) {

            ItemDoCarrinho itemExistente = optionalItem.get();

            int novaQuantidade = itemExistente.getQuantidade() + dados.quantidade();
            if (jogo.getQuantidadeEstoque() < novaQuantidade) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Estoque insuficiente. Você já tem: " + itemExistente.getQuantidade() +
                                "no carrinho. Quantidade disponível: " + jogo.getQuantidadeEstoque());
            }

            itemExistente.setQuantidade(itemExistente.getQuantidade() + dados.quantidade());

            itemDoCarrinhoRepository.save(itemExistente);
        } else {
            ItemDoCarrinho novoitem = new ItemDoCarrinho(carrinho, jogo, dados.quantidade());
            itemDoCarrinhoRepository.save(novoitem);

            carrinho.getItens().add(novoitem);
        }
        carrinho.atualizarTotal();
        carrinhoRepository.saveAndFlush(carrinho);
        return  new CarrinhoViewDTO(carrinho);
    }

    @Transactional(readOnly = true)
    public CarrinhoViewDTO verCarrinho(String loginUsuario) {

        Usuario usuario = (Usuario) usuarioRepository.findByLogin(loginUsuario);

        Carrinho carrinho = usuario.getCarrinho();

        return new CarrinhoViewDTO(carrinho);
    }


    public ItemCarrinhoViewDTO atualizarQuantidadeItem(Long itemId, ItemAtualizarDTO dados, Usuario usuario) {
        Carrinho carrinho = usuario.getCarrinho();

        ItemDoCarrinho itemParaAtualizar = itemDoCarrinhoRepository.findById(itemId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado"));

        if (!itemParaAtualizar.getCarrinho().getId().equals(carrinho.getId())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Você não tem permissão para alterar esse item");
        }

        Jogo jogo = itemParaAtualizar.getJogo();
        if (jogo.getQuantidadeEstoque() < dados.quantidade()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Estoque insuficiente. Quantidade disponível: " + jogo.getQuantidadeEstoque());
        }

        itemParaAtualizar.setQuantidade(dados.quantidade());
        ItemDoCarrinho itemSalvo = itemDoCarrinhoRepository.save(itemParaAtualizar);
        return new ItemCarrinhoViewDTO(itemSalvo);
    }
}
