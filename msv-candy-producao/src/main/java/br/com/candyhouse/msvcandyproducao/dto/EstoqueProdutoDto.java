package br.com.candyhouse.msvcandyproducao.dto;

import br.com.candyhouse.msvcandyproducao.entity.Estoque;
import br.com.candyhouse.msvcandyproducao.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstoqueProdutoDto {

    private Integer id;

    private Estoque estoque;

    private Produto produto;

    private Double gramasUtilizadas;

}
