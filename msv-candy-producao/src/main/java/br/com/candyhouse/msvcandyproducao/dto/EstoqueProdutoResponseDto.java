package br.com.candyhouse.msvcandyproducao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstoqueProdutoResponseDto {

    private Integer id;

    private EstoqueDto estoque;

    private Double gramasUtilizadas;

}
