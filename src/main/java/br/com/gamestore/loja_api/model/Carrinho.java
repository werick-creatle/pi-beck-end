package br.com.gamestore.loja_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_carrinho")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"usuario", "itens"})
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_total")
    private BigDecimal valorTotal = BigDecimal.ZERO;

    @OneToOne(mappedBy = "carrinho")
    private Usuario usuario;

    // AQUI ESTAVA O ERRO: Mudei de LAZY para EAGER
    // Isso obriga o banco a trazer os itens junto com o carrinho
    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<ItemDoCarrinho> itens = new ArrayList<>();

    public Carrinho(Usuario usuario) {
        this.usuario = usuario;
    }

    public void atualizarTotal(){
        if (itens == null || itens.isEmpty()){
            this.valorTotal = BigDecimal.ZERO;
            return;
        }

        // Agora isso vai funcionar porque a lista 'itens' já foi carregada na memória
        this.valorTotal = itens.stream()
                .map(item -> {
                    // Garante que não dê erro de NullPointer se o jogo sumiu
                    if (item.getJogo() == null) return BigDecimal.ZERO;

                    BigDecimal preco = item.getJogo().getPreco();
                    BigDecimal quantidade = BigDecimal.valueOf(item.getQuantidade());

                    return preco.multiply(quantidade);
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}