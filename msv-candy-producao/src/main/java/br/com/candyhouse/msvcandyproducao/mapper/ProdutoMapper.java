package br.com.candyhouse.msvcandyproducao.mapper;
import br.com.candyhouse.msvcandyproducao.dto.*;
import br.com.candyhouse.msvcandyproducao.entity.EstoqueProduto;
import br.com.candyhouse.msvcandyproducao.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoMapper {

    @Autowired
    private EstoqueMapper estoqueMapper;

    public ProdutoResponseListDto converterEntidadeparaResponseDto (Produto produto){

        List<IngredientesDto> listaEstoqueProdutos = new ArrayList<>();

        for(EstoqueProduto valor: produto.getEstoque()){

            IngredientesDto dto = new IngredientesDto();
            EstoqueDto estoqueDto = new EstoqueDto();
            ProdutoDto produtoDto = new ProdutoDto();
            dto.setIdEstoque(valor.getId());
            dto.setGramasUtilizadas(valor.getGramasUtilizadas());
            listaEstoqueProdutos.add(dto);
        }

        ProdutoResponseListDto produtoDto = new ProdutoResponseListDto(
                produto.getIdProduto(),
                produto.getNome(),
                produto.getDataFabricacao(),
                produto.getQtdFabricada(),
                produto.getQtdDisponivel(),
                produto.getValorFabricacao(),
                produto.getValorVenda(),
                listaEstoqueProdutos);

        return produtoDto;
    }
    public ProdutoDto converterEntidadeParaDto(Produto produto){

        List<EstoqueProdutoDto> listaEstoqueProdutos = new ArrayList<>();

        for(EstoqueProduto valor: produto.getEstoque()){

            EstoqueProdutoDto dto = new EstoqueProdutoDto();
            EstoqueDto estoqueDto = new EstoqueDto();
            dto.setId(valor.getId());
            dto.setGramasUtilizadas(valor.getGramasUtilizadas());
            dto.setEstoque(estoqueDto);
            listaEstoqueProdutos.add(dto);
        }

        ProdutoDto produtoDto = new ProdutoDto(
                produto.getIdProduto(),
                produto.getNome(),
                produto.getDataFabricacao(),
                produto.getQtdFabricada(),
                produto.getQtdDisponivel(),
                produto.getValorFabricacao(),
                produto.getValorVenda(),
                listaEstoqueProdutos);

        return produtoDto;
    }

    public ProdutoResponseDto converterEntidadeParaResponseDto(Produto produto){
        return new ProdutoResponseDto(produto.getIdProduto(), produto.getNome(), produto.getDataFabricacao(), produto.getQtdFabricada(), produto.getQtdDisponivel(), produto.getValorFabricacao(), produto.getValorVenda());
    }

    public Produto converterDtoParaEntidade(ProdutoDto produtoDto){

        List<EstoqueProduto> listaEstoqueProdutosDto = new ArrayList<>();

        for(EstoqueProdutoDto valor: produtoDto.getEstoqueProdutos()){

            EstoqueProduto estoqueProduto = new EstoqueProduto();
            estoqueProduto.setId(valor.getId());
            estoqueProduto.setEstoque(estoqueMapper.converterDtoParaEntidade(valor.getEstoque()));
            estoqueProduto.setGramasUtilizadas(valor.getGramasUtilizadas());
            listaEstoqueProdutosDto.add(estoqueProduto);
        }
        return new Produto(produtoDto.getIdProduto(), produtoDto.getNome(), produtoDto.getDataFabricacao(), produtoDto.getQtdFabricada(), produtoDto.getQtdDisponivel(), produtoDto.getValorFabricacao(), produtoDto.getValorVenda(), listaEstoqueProdutosDto);
    }

    public List<ProdutoResponseEstoqueDto> converterListaEntidadeParaDto(List<Produto> listaProdutos){

        List<EstoqueProdutoResponseDto> listaEstoqueProdutos = new ArrayList<>();

        List<ProdutoResponseEstoqueDto> listaProdutoDto = new ArrayList<>();

        for (Produto valor: listaProdutos) {

            ProdutoResponseEstoqueDto produtoDto = new ProdutoResponseEstoqueDto();

            produtoDto.setIdProduto(valor.getIdProduto());
            produtoDto.setNome(valor.getNome());
            produtoDto.setDataFabricacao(valor.getDataFabricacao());
            produtoDto.setQtdFabricada(valor.getQtdFabricada());
            produtoDto.setQtdDisponivel(valor.getQtdDisponivel());
            produtoDto.setValorFabricacao(valor.getValorFabricacao());
            produtoDto.setValorVenda(valor.getValorVenda());
            for(EstoqueProduto x: valor.getEstoque()){
                EstoqueProdutoResponseDto estoqueProdutoResponseDto = new EstoqueProdutoResponseDto();
                estoqueProdutoResponseDto.setId(x.getId());
                estoqueProdutoResponseDto.setEstoque(estoqueMapper.converterEntidadeParaDto(x.getEstoque()));
                estoqueProdutoResponseDto.setGramasUtilizadas(x.getGramasUtilizadas());
                listaEstoqueProdutos.add(estoqueProdutoResponseDto);
                produtoDto.setEstoqueProdutos(listaEstoqueProdutos);
            }
            listaProdutoDto.add(produtoDto);
        }

        return listaProdutoDto;
    }

    public List<ProdutosDisponiveisDto> converterListaProdutoEntidadeParaDto(List<Produto> listaProdutos){

        List<ProdutosDisponiveisDto> listaProdutoDto = new ArrayList<>();

        for (Produto valor: listaProdutos) {
            ProdutosDisponiveisDto produtoDto = new ProdutosDisponiveisDto();
            produtoDto.setIdProduto(valor.getIdProduto());
            produtoDto.setNome(valor.getNome());
            produtoDto.setDataFabricacao(valor.getDataFabricacao());
            produtoDto.setQtdDisponivel(valor.getQtdDisponivel());
            produtoDto.setValorVenda(valor.getValorVenda());
            listaProdutoDto.add(produtoDto);
        }

        return listaProdutoDto;
    }

}
