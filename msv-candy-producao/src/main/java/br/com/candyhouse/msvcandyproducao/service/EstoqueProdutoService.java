package br.com.candyhouse.msvcandyproducao.service;

import br.com.candyhouse.msvcandyproducao.dto.EstoqueProdutoDto;
import br.com.candyhouse.msvcandyproducao.dto.EstoqueProdutoRequestDto;
import br.com.candyhouse.msvcandyproducao.entity.Estoque;
import br.com.candyhouse.msvcandyproducao.entity.EstoqueProduto;
import br.com.candyhouse.msvcandyproducao.mapper.EstoqueProdutoMapper;
import br.com.candyhouse.msvcandyproducao.repository.EstoqueProdutoRepository;
import br.com.candyhouse.msvcandyproducao.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Math.round;

@Service
@SuppressWarnings("unused")
public class EstoqueProdutoService {

    @Autowired
    private EstoqueProdutoRepository estoqueProdutoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private EstoqueProdutoMapper estoqueProdutoMapper;

    public List<EstoqueProdutoDto> listarEstoqueProdutos(){
        return estoqueProdutoMapper.converterListaParaDto(estoqueProdutoRepository.findAll());
    }

    public EstoqueProdutoRequestDto adicionarEstoqueProduto(EstoqueProdutoRequestDto requestDto){
        EstoqueProduto estoqueProduto = estoqueProdutoMapper.converterRequestParaEntidade(requestDto);
        Estoque estoque = estoqueRepository.findById(requestDto).orElse(null);

        if(estoque != null) {
            estoque.setTotalGramas(estoque.getTotalGramas() - estoqueProduto.getGramasUtilizadas());
            estoqueRepository.save(estoque);
            if (estoqueProduto.getGramasUtilizadas() >= estoque.getGramas()) {
                Double aux = estoqueProduto.getGramasUtilizadas() / estoque.getGramas();
                estoque.setQuantidade((int) Math.round(estoque.getQuantidade() - aux));
            }
        }
        return estoqueProdutoMapper.converterEntidadeParaRequestDto(estoqueProdutoRepository.save(estoqueProduto));
    }

    public EstoqueProdutoDto buscarIdEstoqueProduto(Integer id){
        return  estoqueProdutoMapper.converterEntidadeDto(estoqueProdutoRepository.findById(id).get());
    }

    public void deleteEstoqueProduto(Integer id){
       estoqueProdutoRepository.deleteById(id);
    }

    public EstoqueProdutoDto modificarEstoqueProduto(Integer id, EstoqueProdutoDto estoqueProdutoDto){

        EstoqueProduto estoqueProdutoAtual = estoqueProdutoMapper.converterDtoParaEntidade(estoqueProdutoDto);

        estoqueProdutoAtual.setId(id);

        return estoqueProdutoMapper.converterEntidadeDto(estoqueProdutoRepository.save(estoqueProdutoAtual));
    }



}
