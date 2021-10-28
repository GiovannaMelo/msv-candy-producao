package br.com.candyhouse.msvcandyproducao.entity;

import br.com.candyhouse.msvcandyproducao.dto.EstoqueProdutoDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "Produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer idProduto;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_fabricacao")
    private LocalDate dataFabricacao;

    @Column(name = "quantidade_fabricada")
    private Integer qtdFabricada;

    @Column(name = "quantidade_disponivel")
    private Integer qtdDisponivel;

    @Column(name = "valor_fabricacao")
    private Double valorFabricacao;

    @Column(name = "valor_vendido")
    private Double valorVenda;

    @OneToMany(mappedBy = "produto")
    List<EstoqueProduto> estoque = new ArrayList<>();

}
