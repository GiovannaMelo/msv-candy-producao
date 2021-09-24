package br.com.candyhouse.msvcandyproducao.dto;

import br.com.candyhouse.msvcandyproducao.entity.Estoque;
import br.com.candyhouse.msvcandyproducao.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstoqueProdutoRequestDto {

    private Integer id;

    private Integer idEstoque;

    private Integer idProduto;

    private Double gramasUtilizadas;

   // List<IngredientesDto> ingredientesDtoList;

}
