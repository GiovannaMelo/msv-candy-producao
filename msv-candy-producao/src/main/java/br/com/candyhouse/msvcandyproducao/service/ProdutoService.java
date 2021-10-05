package br.com.candyhouse.msvcandyproducao.service;

import br.com.candyhouse.msvcandyproducao.dto.*;
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

    public List<ProdutoResponseEstoqueDto> listarProdutos(){
        return produtoMapper.converterListaEntidadeParaDto( produtoRepository.findAll());
    }

    public List<ProdutosDisponiveisDto> listarProdutosDisponiveis(){
        return produtoMapper.converterListaProdutoEntidadeParaDto(produtoRepository.findAll());
    }

    public ProdutoResponseDto criarProduto(Produto produto){
        return produtoMapper.converterEntidadeParaResponseDto(produtoRepository.save(produto));
    }

    public ProdutoResponseListDto buscarIdProduto(Integer id){
        return produtoMapper.converterEntidadeparaResponseDto(produtoRepository.findById(id).get());
    }

    public void deletarProduto(Integer id){
        produtoRepository.deleteById(id);
    }

    public ProdutoDto atualizarProduto(Integer id, ProdutoDto produtoDto){
        Produto byId = produtoRepository.findById(id).get();
        byId.setNome(produtoDto.getNome());
        byId.setDataFabricacao(produtoDto.getDataFabricacao());
        byId.setValorVenda(produtoDto.getValorVenda());
        byId.setValorFabricacao(produtoDto.getValorFabricacao());
        byId.setQtdFabricada(produtoDto.getQtdFabricada());
        byId.setQtdDisponivel(produtoDto.getQtdDisponivel());
        return produtoMapper.converterEntidadeParaDto(produtoRepository.save(byId));
    }

    public String atualizarQtdProduto (Integer id, Integer qtdAtual) throws Exception {
        Produto byId = produtoRepository.findById(id).get();
        if (qtdAtual == null){
            throw new Exception("Quantidade atual não pode ser nula");
        }
        byId.setQtdDisponivel(qtdAtual);
        produtoRepository.save(byId);
        return ("Quantidade de produtos disponives atualizada");
    }
}
