package br.com.candyhouse.msvcandyproducao.mapper;

import br.com.candyhouse.msvcandyproducao.dto.EstoqueProdutoDto;
import br.com.candyhouse.msvcandyproducao.dto.EstoqueProdutoRequestDto;
import br.com.candyhouse.msvcandyproducao.dto.IngredientesDto;
import br.com.candyhouse.msvcandyproducao.entity.Estoque;
import br.com.candyhouse.msvcandyproducao.entity.EstoqueProduto;
import br.com.candyhouse.msvcandyproducao.entity.Produto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EstoqueProdutoMapper {

    public EstoqueProdutoDto converterEntidadeDto(EstoqueProduto estoqueProduto){
     return new EstoqueProdutoDto(estoqueProduto.getId(), estoqueProduto.getEstoque(), estoqueProduto.getProduto(), estoqueProduto.getGramasUtilizadas());
    }

    public EstoqueProdutoRequestDto converterEntidadeParaRequestDto(EstoqueProduto estoqueProduto){
        return new EstoqueProdutoRequestDto(estoqueProduto.getId(), estoqueProduto.getEstoque().getIdEstoque(), estoqueProduto.getProduto().getIdProduto(), estoqueProduto.getGramasUtilizadas());
    }

    public EstoqueProduto converterDtoParaEntidade(EstoqueProdutoDto estoqueProdutoDto){
      return new EstoqueProduto(estoqueProdutoDto.getId(), estoqueProdutoDto.getEstoque(), estoqueProdutoDto.getProduto(), estoqueProdutoDto.getGramasUtilizadas());
    }

    public EstoqueProduto converterRequestParaEntidade(EstoqueProdutoRequestDto requestDto){
        EstoqueProduto estoqueProduto = new EstoqueProduto();
        Produto produto = new Produto();
        Estoque estoque = new Estoque();
        estoqueProduto.setId(requestDto.getId());
        estoqueProduto.setGramasUtilizadas(requestDto.getGramasUtilizadas());
        produto.setIdProduto(requestDto.getIdProduto());
        estoque.setIdEstoque(requestDto.getIdEstoque());
        estoqueProduto.setEstoque(estoque);
        estoqueProduto.setProduto(produto);
        return estoqueProduto;
    }

    public List<EstoqueProdutoDto> converterListaParaDto(List<EstoqueProduto> listaEstoqueProduto){

        List<EstoqueProdutoDto> listaEstoqueProdutosDto = new ArrayList<>();

        for (EstoqueProduto valor: listaEstoqueProduto){
            EstoqueProdutoDto estoqueProdutoDto = new EstoqueProdutoDto();
            estoqueProdutoDto.setId(valor.getId());
            estoqueProdutoDto.setEstoque(valor.getEstoque());
            estoqueProdutoDto.setProduto(valor.getProduto());
            estoqueProdutoDto.setGramasUtilizadas(valor.getGramasUtilizadas());
            listaEstoqueProdutosDto.add(estoqueProdutoDto);
        }
        return listaEstoqueProdutosDto;
    }
}
