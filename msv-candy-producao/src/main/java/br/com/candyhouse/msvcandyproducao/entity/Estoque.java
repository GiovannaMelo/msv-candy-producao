package br.com.candyhouse.msvcandyproducao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Estoque")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estoque")
    private Integer idEstoque;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_validade")
    private LocalDate dataValidade;

    @Column(name = "gramas")
    private Double gramas;

    @Column(name = "total_gramas")
    private Double totalGramas;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "valor_compra")
    private Double valorCompra;

    @ManyToOne
    @JoinColumn(name = "fk_confeitaria")
    private Confeitaria confeitaria;

    @JsonIgnore
    @OneToMany(mappedBy = "estoque")
    Set<EstoqueProduto> produto = new HashSet<>();

    public Estoque(Integer idEstoque) {
        this.idEstoque = idEstoque;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "idEstoque=" + idEstoque +
                ", nome='" + nome + '\'' +
                ", dataValidade=" + dataValidade +
                ", gramas=" + gramas +
                ", totalGramas=" + totalGramas +
                ", quantidade=" + quantidade +
                ", valorCompra=" + valorCompra +
                ", confeitaria=" + confeitaria +
                ", produto=" + produto +
                '}';
    }
}
