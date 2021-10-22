package br.com.candyhouse.msvcandyproducao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Confeitaria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Confeitaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_confeitaria")
    private Integer idConfeitaria;

    @Column(name = "nome")
    private String nome;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "cep")
    private String cep;

    @Column(name = "rua")
    private String rua;

    @Column(name = "numero")
    private String numero;

    @Column(name = "email")
    private String email;

    @Column(name = "usuario", unique = true)
    private String usuario;

    @Column(name = "senha")
    private String senha;
}
