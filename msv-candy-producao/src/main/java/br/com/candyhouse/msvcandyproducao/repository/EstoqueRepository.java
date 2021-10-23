package br.com.candyhouse.msvcandyproducao.repository;

import br.com.candyhouse.msvcandyproducao.entity.Estoque;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {

    @Query(value = "select * from estoque e where fk_confeitaria = : idConfeitaria", nativeQuery = true)
    List<Estoque> findAllByConfeitaria(@Param(value = "idConfeitaria") Integer idConfeitaria);

}
