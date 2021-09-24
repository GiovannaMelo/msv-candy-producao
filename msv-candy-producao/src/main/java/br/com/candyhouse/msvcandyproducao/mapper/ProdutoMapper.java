package br.com.candyhouse.msvcandyproducao.mapper;

import br.com.candyhouse.msvcandyproducao.dto.ProdutoDto;
import br.com.candyhouse.msvcandyproducao.dto.ProdutoResponseDto;
import br.com.candyhouse.msvcandyproducao.dto.ProdutosDisponiveisDto;
import br.com.candyhouse.msvcandyproducao.entity.Produto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoMapper {

    public ProdutoDto converterEntidadeParaDto(Produto produto){
        return new ProdutoDto(produto.getIdProduto(), produto.getNome(), produto.getDataFabricacao(), produto.getQtdFabricada(), produto.getQtdDisponivel(), produto.getValorFabricacao(), produto.getValorVendido(),produto.getEstoque());
    }

    public ProdutoResponseDto converterEntidadeParaResponseDto(Produto produto){
        return new ProdutoResponseDto(produto.getIdProduto(), produto.getNome(), produto.getDataFabricacao(), produto.getQtdFabricada(), produto.getQtdDisponivel(), produto.getValorFabricacao(), produto.getValorVendido());
    }

    public Produto converterDtoParaEntidade(ProdutoDto produtoDto){
        return new Produto(produtoDto.getIdProduto(), produtoDto.getNome(), produtoDto.getDataFabricacao(), produtoDto.getQtdFabricada(), produtoDto.getQtdDisponivel(), produtoDto.getValorFabricacao(), produtoDto.getValorVendido(), produtoDto.getEstoque());
    }

    public List<ProdutoDto> converterListaEntidadeParaDto(List<Produto> listaProdutos){

        List<ProdutoDto> listaProdutoDto = new ArrayList<>();

        for (Produto valor: listaProdutos) {
            ProdutoDto produtoDto = new ProdutoDto();
            produtoDto.setIdProduto(valor.getIdProduto());
            produtoDto.setNome(valor.getNome());
            produtoDto.setDataFabricacao(valor.getDataFabricacao());
            produtoDto.setQtdFabricada(valor.getQtdFabricada());
            produtoDto.setQtdDisponivel(valor.getQtdDisponivel());
            produtoDto.setValorFabricacao(valor.getValorFabricacao());
            produtoDto.setValorVendido(valor.getValorVendido());
            produtoDto.setEstoque(valor.getEstoque());
            listaProdutoDto.add(produtoDto);
        }

        return listaProdutoDto;
    }

    public List<ProdutosDisponiveisDto> converterListaProdutoEntidadeParaDto(List<Produto> listaProdutos){

        List<ProdutosDisponiveisDto> listaProdutoDto = new ArrayList<>();

        for (Produto valor: listaProdutos) {
            ProdutosDisponiveisDto produtoDto = new ProdutosDisponiveisDto();
            produtoDto.setNome(valor.getNome());
            produtoDto.setDataFabricacao(valor.getDataFabricacao());
            produtoDto.setQtdDisponivel(valor.getQtdDisponivel());
            produtoDto.setValorVendido(valor.getValorVendido());
            listaProdutoDto.add(produtoDto);
        }

        return listaProdutoDto;
    }

}
