package br.com.candyhouse.msvcandyproducao.dto;

import br.com.candyhouse.msvcandyproducao.entity.Estoque;
import br.com.candyhouse.msvcandyproducao.entity.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstoqueProdutoDto {

    private Integer id;

    private EstoqueDto estoque;

    private ProdutoDto produto;

    private Double gramasUtilizadas;

}
