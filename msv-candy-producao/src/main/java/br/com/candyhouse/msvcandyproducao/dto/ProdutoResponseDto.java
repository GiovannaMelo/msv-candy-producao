package br.com.candyhouse.msvcandyproducao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoResponseDto {

    private Integer idProduto;

    private String nome;

    private LocalDate dataFabricacao;

    private Integer qtdFabricada;

    private Integer qtdDisponivel;

    private Double valorFabricacao;

    private Double valorVenda;

}
