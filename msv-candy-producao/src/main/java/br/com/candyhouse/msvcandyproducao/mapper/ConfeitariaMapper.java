package br.com.candyhouse.msvcandyproducao.mapper;

import br.com.candyhouse.msvcandyproducao.dto.ConfeitariaDto;
import br.com.candyhouse.msvcandyproducao.entity.Confeitaria;
import org.springframework.stereotype.Component;

@Component
public class ConfeitariaMapper {

    public Confeitaria converterDtoParaEntidade(ConfeitariaDto confeitariaDto) {
        return new Confeitaria(
                confeitariaDto.getIdConfeitaria(),
                confeitariaDto.getNome(),
                confeitariaDto.getNomeFantasia(),
                confeitariaDto.getCnpj(),
                confeitariaDto.getCep(),
                confeitariaDto.getRua(),
                confeitariaDto.getNumero(),
                confeitariaDto.getEmail(),
                confeitariaDto.getUsuario(),
                confeitariaDto.getSenha()
        );
    }

    public ConfeitariaDto converterEntidadeParaDto(Confeitaria confeitaria) {
        return new ConfeitariaDto(
                confeitaria.getIdConfeitaria(),
                confeitaria.getNome(),
                confeitaria.getNomeFantasia(),
                confeitaria.getCnpj(),
                confeitaria.getCep(),
                confeitaria.getRua(),
                confeitaria.getNumero(),
                confeitaria.getEmail(),
                confeitaria.getUsuario(),
                confeitaria.getSenha()
        );
    }

}
