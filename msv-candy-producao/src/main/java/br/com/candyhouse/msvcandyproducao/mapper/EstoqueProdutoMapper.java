package br.com.candyhouse.msvcandyproducao.mapper;

import br.com.candyhouse.msvcandyproducao.dto.*;
import br.com.candyhouse.msvcandyproducao.entity.Estoque;
import br.com.candyhouse.msvcandyproducao.entity.EstoqueProduto;
import br.com.candyhouse.msvcandyproducao.entity.Produto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EstoqueProdutoMapper {

    private EstoqueMapper estoqueMapper;
    private ProdutoMapper produtoMapper;

    public EstoqueProdutoDto converterEntidadeDto(EstoqueProduto estoqueProduto){
        ProdutoDto produtoDto = new ProdutoDto();
        EstoqueDto estoqueDto = new EstoqueDto();
        estoqueDto.setIdEstoque(estoqueProduto.getEstoque().getIdEstoque());
        estoqueDto.setNome(estoqueProduto.getEstoque().getNome());
        estoqueDto.setQuantidade(estoqueProduto.getEstoque().getQuantidade());
        estoqueDto.setGramas(estoqueProduto.getEstoque().getGramas());
        estoqueDto.setDataValidade(estoqueProduto.getEstoque().getDataValidade());
        estoqueDto.setValorCompra(estoqueProduto.getEstoque().getValorCompra());
        estoqueDto.setTotalGramas(estoqueProduto.getEstoque().getTotalGramas());

        produtoDto.setIdProduto(estoqueProduto.getProduto().getIdProduto());
        produtoDto.setNome(estoqueProduto.getProduto().getNome());
        produtoDto.setValorVenda(estoqueProduto.getProduto().getValorVenda());
        produtoDto.setValorFabricacao(estoqueProduto.getProduto().getValorFabricacao());
        produtoDto.setDataFabricacao(estoqueProduto.getProduto().getDataFabricacao());
        produtoDto.setQtdDisponivel(estoqueProduto.getProduto().getQtdDisponivel());
        produtoDto.setQtdFabricada(estoqueProduto.getProduto().getQtdFabricada());

        return new EstoqueProdutoDto(estoqueProduto.getId(),estoqueDto, produtoDto, estoqueProduto.getGramasUtilizadas());
    }

    public EstoqueProdutoListDto converterListEntidadeDto(EstoqueProduto estoqueProduto){
        ProdutoListDto produtoDto = new ProdutoListDto();
        EstoqueDto estoqueDto = new EstoqueDto();
        estoqueDto.setIdEstoque(estoqueProduto.getEstoque().getIdEstoque());
        estoqueDto.setNome(estoqueProduto.getEstoque().getNome());
        estoqueDto.setQuantidade(estoqueProduto.getEstoque().getQuantidade());
        estoqueDto.setGramas(estoqueProduto.getEstoque().getGramas());
        estoqueDto.setDataValidade(estoqueProduto.getEstoque().getDataValidade());
        estoqueDto.setValorCompra(estoqueProduto.getEstoque().getValorCompra());
        estoqueDto.setTotalGramas(estoqueProduto.getEstoque().getTotalGramas());

        produtoDto.setIdProduto(estoqueProduto.getProduto().getIdProduto());
        produtoDto.setNome(estoqueProduto.getProduto().getNome());
        produtoDto.setValorVenda(estoqueProduto.getProduto().getValorVenda());
        produtoDto.setValorFabricacao(estoqueProduto.getProduto().getValorFabricacao());
        produtoDto.setDataFabricacao(estoqueProduto.getProduto().getDataFabricacao());
        produtoDto.setQtdDisponivel(estoqueProduto.getProduto().getQtdDisponivel());
        produtoDto.setQtdFabricada(estoqueProduto.getProduto().getQtdFabricada());

        return new EstoqueProdutoListDto(estoqueProduto.getId(),estoqueDto, produtoDto, estoqueProduto.getGramasUtilizadas());
    }

    public EstoqueProduto converterDtoParaEntidade(EstoqueProdutoDto estoqueProdutoDto){
        return new EstoqueProduto(estoqueProdutoDto.getId(), new Estoque(), new Produto(), estoqueProdutoDto.getGramasUtilizadas());
    }

    public EstoqueProduto converterRequestParaEntidade(EstoqueProdutoDto estoqueProdutoDto){
        Produto produto = new Produto();
        Estoque estoque = new Estoque();
        EstoqueProduto estoqueProduto = new EstoqueProduto();
        estoqueProduto.setId(estoqueProdutoDto.getId());
        estoqueProduto.setGramasUtilizadas(estoqueProdutoDto.getGramasUtilizadas());
        produto.setIdProduto(estoqueProdutoDto.getProduto().getIdProduto());
        estoque.setIdEstoque(estoqueProdutoDto.getEstoque().getIdEstoque());
        estoqueProduto.setEstoque(estoque);
        estoqueProduto.setProduto(produto);
        return estoqueProduto;
    }

    public List<EstoqueProdutoListDto> converterListaParaDto(List<EstoqueProduto> listaEstoqueProduto){

        List<EstoqueProdutoListDto> listaEstoqueProdutosDto = new ArrayList<>();
        List<EstoqueProdutoListDto> listaEstoque = new ArrayList<>();
        List<EstoqueProdutoListDto> listaProduto = new ArrayList<>();
        for (EstoqueProduto valor: listaEstoqueProduto){
            EstoqueProdutoListDto estoqueProdutoDto = new EstoqueProdutoListDto();
            estoqueProdutoDto.setId(valor.getId());
            for(EstoqueProduto x: valor.getEstoque().getProduto()){
                EstoqueDto estoqueDto = new EstoqueDto();
                estoqueDto.setIdEstoque(x.getEstoque().getIdEstoque());
                estoqueDto.setNome(x.getEstoque().getNome());
                estoqueDto.setQuantidade(x.getEstoque().getQuantidade());
                estoqueDto.setGramas(x.getEstoque().getGramas());
                estoqueDto.setDataValidade(x.getEstoque().getDataValidade());
                estoqueDto.setTotalGramas(x.getEstoque().getTotalGramas());
                estoqueDto.setValorCompra(x.getEstoque().getValorCompra());
                estoqueProdutoDto.setEstoque(estoqueDto);
                listaEstoque.add(estoqueProdutoDto);
            }
            for(EstoqueProduto x: valor.getProduto().getEstoque()){
                ProdutoListDto produtoListDto = new ProdutoListDto();
                produtoListDto.setIdProduto(x.getProduto().getIdProduto());
                produtoListDto.setNome(x.getProduto().getNome());
                produtoListDto.setQtdDisponivel(x.getProduto().getQtdDisponivel());
                produtoListDto.setQtdFabricada(x.getProduto().getQtdFabricada());
                produtoListDto.setDataFabricacao(x.getProduto().getDataFabricacao());
                produtoListDto.setValorFabricacao(x.getProduto().getValorFabricacao());
                produtoListDto.setValorVenda(x.getProduto().getValorVenda());
                estoqueProdutoDto.setProduto(produtoListDto);
                listaProduto.add(estoqueProdutoDto);
            }
            estoqueProdutoDto.setGramasUtilizadas(valor.getGramasUtilizadas());
            listaEstoqueProdutosDto.add(estoqueProdutoDto);
        }
        return listaEstoqueProdutosDto;
    }
}
