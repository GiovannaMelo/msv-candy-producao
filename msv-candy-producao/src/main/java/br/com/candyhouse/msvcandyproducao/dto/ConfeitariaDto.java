package br.com.candyhouse.msvcandyproducao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ConfeitariaDto {

    private Integer idConfeitaria;

    private String nome;

    private String nomeFantasia;

    private String cnpj;

    private String cep;

    private String rua;

    private String numero;

    private String email;

    private String usuario;

    private String senha;

}
