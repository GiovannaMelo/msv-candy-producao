package br.com.candyhouse.msvcandyproducao.repository;

import br.com.candyhouse.msvcandyproducao.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
