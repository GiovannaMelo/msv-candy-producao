package br.com.candyhouse.msvcandyproducao.mapper;

import br.com.candyhouse.msvcandyproducao.dto.EstoqueDto;
import br.com.candyhouse.msvcandyproducao.entity.Confeitaria;
import br.com.candyhouse.msvcandyproducao.entity.Estoque;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EstoqueMapper {

    public EstoqueDto converterEntidadeParaDto(Estoque estoque){
        System.out.println(estoque);
        return new EstoqueDto(
                estoque.getIdEstoque(),
                estoque.getNome(),
                estoque.getDataValidade(),
                estoque.getGramas(),
                estoque.getTotalGramas(),
                estoque.getQuantidade(),
                estoque.getValorCompra(),
                1
        );
    }
    public Estoque converterDtoParaEntidade (EstoqueDto estoqueDto){
        Estoque estoque = new Estoque();
        Confeitaria confeitaria = new Confeitaria();
        confeitaria.setIdConfeitaria(estoqueDto.getIdConfeitaria());
        estoque.setIdEstoque(estoqueDto.getIdEstoque());
        estoque.setNome(estoqueDto.getNome());
        estoque.setDataValidade(estoqueDto.getDataValidade());
        estoque.setGramas(estoqueDto.getGramas());
        estoque.setTotalGramas(estoqueDto.getTotalGramas());
        estoque.setQuantidade(estoqueDto.getQuantidade());
        estoque.setValorCompra(estoqueDto.getValorCompra());
        estoque.setConfeitaria(confeitaria);
        return estoque;
    }

    public List<EstoqueDto> converterListaEntidadeParaDto (List<Estoque> listaEstoques){

        List<EstoqueDto> listaEstoqueDto = new ArrayList<>();

        for (Estoque list: listaEstoques) {
            EstoqueDto estoqueDto = new EstoqueDto();
            estoqueDto.setIdEstoque(list.getIdEstoque());
            estoqueDto.setNome(list.getNome());
            estoqueDto.setDataValidade(list.getDataValidade());
            estoqueDto.setGramas(list.getGramas());
            estoqueDto.setTotalGramas(list.getTotalGramas());
            estoqueDto.setQuantidade(list.getQuantidade());
            estoqueDto.setValorCompra(list.getValorCompra());
            listaEstoqueDto.add(estoqueDto);
        }
        return listaEstoqueDto;
    }

}
