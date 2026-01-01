package br.com.gamestore.loja_api.dto;

import br.com.gamestore.loja_api.model.Carrinho;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public record CarrinhoViewDTO(
        Long id,
        BigDecimal valorTotal,
        List<ItemCarrinhoViewDTO> itens
) {
    public CarrinhoViewDTO(Carrinho carrinho) {
        this(
                carrinho.getId(),
                carrinho.getValorTotal(),
                carrinho.getItens().stream()
                        .map(ItemCarrinhoViewDTO::new)
                        .collect(Collectors.toList())
        );
    }
}