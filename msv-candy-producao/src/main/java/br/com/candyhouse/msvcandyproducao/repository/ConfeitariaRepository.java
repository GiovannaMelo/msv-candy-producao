package br.com.candyhouse.msvcandyproducao.repository;

import br.com.candyhouse.msvcandyproducao.dto.ConfeitariaLoginDto;
import br.com.candyhouse.msvcandyproducao.entity.Confeitaria;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfeitariaRepository extends JpaRepository<Confeitaria, Integer> {

    @Query(value = "select * from confeitaria c where c.usuario = :usuario and c.senha = :senha", nativeQuery = true)
    Optional<Confeitaria> loginConfeitaria(@Param("usuario") String usuario, @Param("senha") String senha);

}
