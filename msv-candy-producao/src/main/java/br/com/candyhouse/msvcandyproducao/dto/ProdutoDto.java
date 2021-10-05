package br.com.candyhouse.msvcandyproducao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoDto {

    private Integer idProduto;

    private String nome;

    private LocalDate dataFabricacao;

    private Integer qtdFabricada;

    private Integer qtdDisponivel;

    private Double valorFabricacao;

    private Double valorVenda;

    List<EstoqueProdutoDto> estoqueProdutos;


}
