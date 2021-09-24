package br.com.candyhouse.msvcandyproducao.dto;

import br.com.candyhouse.msvcandyproducao.entity.EstoqueProduto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstoqueDto {

    private Integer idEstoque;

    private String nome;

    private LocalDate dataValidade;

    private Double gramas;

    private Double totalGramas;

    private Integer quantidade;

    private Double valorCompra;

}
