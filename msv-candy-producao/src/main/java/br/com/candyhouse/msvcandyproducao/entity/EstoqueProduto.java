package br.com.candyhouse.msvcandyproducao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "EstoqueProduto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estoque_produto")
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_estoque")
    private Estoque estoque;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Column(name = "gramas_utilizadas")
    private Double gramasUtilizadas;
}
