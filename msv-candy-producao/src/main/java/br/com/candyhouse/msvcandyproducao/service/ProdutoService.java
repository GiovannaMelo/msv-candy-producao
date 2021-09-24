package br.com.candyhouse.msvcandyproducao.service;

import br.com.candyhouse.msvcandyproducao.dto.ProdutoDto;
import br.com.candyhouse.msvcandyproducao.dto.ProdutoResponseDto;
import br.com.candyhouse.msvcandyproducao.dto.ProdutosDisponiveisDto;
import br.com.candyhouse.msvcandyproducao.entity.Produto;
import br.com.candyhouse.msvcandyproducao.mapper.ProdutoMapper;
import br.com.candyhouse.msvcandyproducao.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoMapper produtoMapper;

    public List<ProdutoDto> listarProdutos(){
        return produtoMapper.converterListaEntidadeParaDto( produtoRepository.findAll());
    }

    public List<ProdutosDisponiveisDto> listarProdutosDisponiveis(){
        return produtoMapper.converterListaProdutoEntidadeParaDto(produtoRepository.findAll());
    }

    public ProdutoResponseDto criarProduto(Produto produto){
        return produtoMapper.converterEntidadeParaResponseDto(produtoRepository.save(produto));
    }

    public ProdutoDto buscarIdProduto(Integer id){
        return produtoMapper.converterEntidadeParaDto(produtoRepository.findById(id).get());
    }

    public void deletarProduto(Integer id){
        produtoRepository.deleteById(id);
    }

    public ProdutoDto atualizarProduto(Integer id, ProdutoDto produtoDto){
        Produto produtoAtual = produtoMapper.converterDtoParaEntidade(produtoDto);
        produtoAtual.setIdProduto(id);

        return produtoMapper.converterEntidadeParaDto(produtoRepository.save(produtoAtual));
    }
}
