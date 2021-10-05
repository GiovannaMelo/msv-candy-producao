package br.com.candyhouse.msvcandyproducao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstoqueProdutoListDto {

    private Integer id;

    private EstoqueDto estoque;

    private ProdutoListDto produto;

    private Double gramasUtilizadas;

}
