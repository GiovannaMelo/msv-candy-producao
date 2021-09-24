package br.com.candyhouse.msvcandyproducao.service;

import br.com.candyhouse.msvcandyproducao.dto.EstoqueDto;
import br.com.candyhouse.msvcandyproducao.entity.Estoque;
import br.com.candyhouse.msvcandyproducao.mapper.EstoqueMapper;
import br.com.candyhouse.msvcandyproducao.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private EstoqueMapper estoqueMapper;

    public List<EstoqueDto> listarEstoque(){
        return estoqueMapper.converterListaEntidadeParaDto(estoqueRepository.findAll());
    }

    public EstoqueDto criarEstoque(Estoque estoque){
        estoque.setTotalGramas(estoque.getGramas() * estoque.getQuantidade());
        estoqueRepository.save(estoque);
        return estoqueMapper.converterEntidadeParaDto(estoqueRepository.save(estoque));
    }

    public EstoqueDto buscarIdEstoque(Integer id){
        return estoqueMapper.converterEntidadeParaDto(estoqueRepository.findById(id).get());
    }

    public void deletarEstoque(Integer id){
         estoqueRepository.deleteById(id);
    }

    public EstoqueDto atualizarEstoque(Integer id, EstoqueDto estoqueDto){
        Estoque estoqueAtual = estoqueMapper.converterDtoParaEntidade(estoqueDto);
        estoqueAtual.setIdEstoque(id);

        return estoqueMapper.converterEntidadeParaDto(estoqueRepository.save(estoqueAtual));
    }
}
