package br.com.candyhouse.msvcandyproducao.service;

import br.com.candyhouse.msvcandyproducao.dto.ConfeitariaDto;
import br.com.candyhouse.msvcandyproducao.dto.ConfeitariaLoginDto;
import br.com.candyhouse.msvcandyproducao.entity.Confeitaria;
import br.com.candyhouse.msvcandyproducao.mapper.ConfeitariaMapper;
import br.com.candyhouse.msvcandyproducao.repository.ConfeitariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfeitariaService {

    @Autowired
    ConfeitariaRepository confeitariaRepository;
    
    @Autowired
    ConfeitariaMapper confeitariaMapper;

    public List<ConfeitariaDto> listarConfeitaria() {
        return confeitariaMapper.converterListaConfeitariaEntidadeParaDto(confeitariaRepository.findAll());
    }

    public ConfeitariaDto cadastrarConfeitaria(ConfeitariaDto confeitariaDto) {
        return confeitariaMapper.converterEntidadeParaDto(confeitariaRepository.save(confeitariaMapper.converterDtoParaEntidade(confeitariaDto)));
    }

    public Integer loginConfeitaria(ConfeitariaLoginDto confeitariaLoginDto){
        Confeitaria confeitaria = confeitariaRepository.loginConfeitaria(confeitariaLoginDto.getUsuario(), confeitariaLoginDto.getSenha()).orElse(null);
        return confeitariaMapper.converterEntidadeParaDto(confeitaria).getIdConfeitaria();
    }
}
