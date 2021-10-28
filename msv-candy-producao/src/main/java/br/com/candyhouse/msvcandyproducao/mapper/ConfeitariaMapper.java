package br.com.candyhouse.msvcandyproducao.mapper;

import br.com.candyhouse.msvcandyproducao.dto.ConfeitariaDto;
import br.com.candyhouse.msvcandyproducao.dto.ProdutosDisponiveisDto;
import br.com.candyhouse.msvcandyproducao.entity.Confeitaria;
import br.com.candyhouse.msvcandyproducao.entity.Produto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<ConfeitariaDto> converterListaConfeitariaEntidadeParaDto(List<Confeitaria> listaConfeitarias){

        List<ConfeitariaDto> listaConfeitariaDto = new ArrayList<>();

        for (Confeitaria valor: listaConfeitarias) {
            ConfeitariaDto confeitariaDto = new ConfeitariaDto();
            confeitariaDto.setIdConfeitaria(valor.getIdConfeitaria());
            confeitariaDto.setNome(valor.getNome());
            confeitariaDto.setNomeFantasia(valor.getNomeFantasia());
            confeitariaDto.setCep(valor.getCep());
            confeitariaDto.setCnpj(valor.getCnpj());
            confeitariaDto.setEmail(valor.getEmail());
            confeitariaDto.setRua(valor.getRua());
            confeitariaDto.setSenha(valor.getSenha());
            confeitariaDto.setUsuario(valor.getUsuario());
        }

        return listaConfeitariaDto;
    }

}
