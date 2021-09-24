package br.com.candyhouse.msvcandyproducao.dto;

import br.com.candyhouse.msvcandyproducao.entity.EstoqueProduto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;
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

    private Double valorVendido;

    Set<EstoqueProduto> estoque;

}
