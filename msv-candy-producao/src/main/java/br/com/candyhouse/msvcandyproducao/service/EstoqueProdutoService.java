package br.com.candyhouse.msvcandyproducao.service;

import br.com.candyhouse.msvcandyproducao.dto.*;
import br.com.candyhouse.msvcandyproducao.entity.Estoque;
import br.com.candyhouse.msvcandyproducao.entity.EstoqueProduto;
import br.com.candyhouse.msvcandyproducao.mapper.EstoqueProdutoMapper;
import br.com.candyhouse.msvcandyproducao.repository.EstoqueProdutoRepository;
import br.com.candyhouse.msvcandyproducao.repository.EstoqueRepository;
import br.com.candyhouse.msvcandyproducao.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<EstoqueProdutoListDto> listarEstoqueProdutos() {
        return estoqueProdutoMapper.converterListaParaDto(estoqueProdutoRepository.findAll());
    }

    public String adicionarEstoqueProduto(EstoqueProdutoRequestDto requestDto) throws Exception {
        try {
            for (IngredientesDto dto : requestDto.getIngredientes()) {
                EstoqueProdutoDto estoqueProdutoDto = new EstoqueProdutoDto(
                        requestDto.getId(),
                        new EstoqueDto(dto.getIdEstoque(), null, null, null, null, null, null, null),
                        new ProdutoDto(requestDto.getIdProduto(), null, null, null, null, null, null, null, new ArrayList<>()),
                        dto.getGramasUtilizadas());
                EstoqueProduto estoqueProduto = estoqueProdutoMapper.converterRequestParaEntidade(estoqueProdutoDto);
                Estoque estoque = estoqueRepository.findById(estoqueProduto.getEstoque().getIdEstoque()).orElse(null);
                if (estoque != null) {
                    estoque.setTotalGramas(estoque.getTotalGramas() - estoqueProduto.getGramasUtilizadas());
                    estoqueRepository.save(estoque);
                    if (estoqueProduto.getGramasUtilizadas() >= estoque.getGramas()) {
                        Double aux = estoqueProduto.getGramasUtilizadas() / estoque.getGramas();
                        estoque.setQuantidade((int) Math.round(estoque.getQuantidade() - aux));
                    }
                    estoqueProdutoRepository.save(estoqueProduto);
                }
            }
            return "Estoque Produto Salvo com sucesso";
        } catch (Exception e) {
            throw new Exception("Erro ao adicionar Estoque Produto", e);
        }
    }

    public EstoqueProdutoListDto buscarIdEstoqueProduto(Integer id) {
        return estoqueProdutoMapper.converterListEntidadeDto(estoqueProdutoRepository.findById(id).get());
    }

    public void deleteEstoqueProduto(Integer id) {
        estoqueProdutoRepository.deleteById(id);
    }

    public EstoqueProdutoDto modificarEstoqueProduto(Integer id, EstoqueProdutoDto estoqueProdutoDto) {

        EstoqueProduto estoqueProdutoAtual = estoqueProdutoMapper.converterDtoParaEntidade(estoqueProdutoDto);

        estoqueProdutoAtual.setId(id);

        return estoqueProdutoMapper.converterEntidadeDto(estoqueProdutoRepository.save(estoqueProdutoAtual));
    }


}
