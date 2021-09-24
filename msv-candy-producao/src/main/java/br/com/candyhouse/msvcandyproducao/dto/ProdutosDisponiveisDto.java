package br.com.candyhouse.msvcandyproducao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutosDisponiveisDto {

    private String nome;

    private LocalDate dataFabricacao;

    private Integer qtdDisponivel;

    private Double valorVendido;

}
