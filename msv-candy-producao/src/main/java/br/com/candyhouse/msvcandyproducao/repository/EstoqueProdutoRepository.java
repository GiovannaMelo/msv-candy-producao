package br.com.candyhouse.msvcandyproducao.repository;

import br.com.candyhouse.msvcandyproducao.entity.EstoqueProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueProdutoRepository extends JpaRepository<EstoqueProduto, Integer> {
}
