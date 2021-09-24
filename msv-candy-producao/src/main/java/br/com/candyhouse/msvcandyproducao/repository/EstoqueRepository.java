package br.com.candyhouse.msvcandyproducao.repository;

import br.com.candyhouse.msvcandyproducao.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {

}
