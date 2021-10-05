package br.com.candyhouse.msvcandyproducao.controller;

import br.com.candyhouse.msvcandyproducao.dto.EstoqueProdutoDto;
import br.com.candyhouse.msvcandyproducao.dto.EstoqueProdutoListDto;
import br.com.candyhouse.msvcandyproducao.dto.EstoqueProdutoRequestDto;
import br.com.candyhouse.msvcandyproducao.repository.EstoqueProdutoRepository;
import br.com.candyhouse.msvcandyproducao.service.EstoqueProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque-produto")
@SuppressWarnings("unused")
public class EstoqueProdutoController {

    @Autowired
    private EstoqueProdutoService estoqueProdutoService;

    @Autowired
    private EstoqueProdutoRepository estoqueProdutoRepository;

    @GetMapping
    public ResponseEntity<List<EstoqueProdutoListDto>> listarEstoqueProdutos(){
        return ResponseEntity.ok(estoqueProdutoService.listarEstoqueProdutos());
    }

    @PostMapping
    public ResponseEntity<String> adicionarEstoqueProduto (@RequestBody EstoqueProdutoRequestDto requestDto) throws Exception {
        return ResponseEntity.ok(estoqueProdutoService.adicionarEstoqueProduto(requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueProdutoListDto> buscarIdEstoqueProduto(@PathVariable Integer id){
        return ResponseEntity.ok(estoqueProdutoService.buscarIdEstoqueProduto(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEstoqueProduto(@PathVariable Integer id){
        estoqueProdutoService.deleteEstoqueProduto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EstoqueProdutoDto> modificarEstoqueProduto (@PathVariable Integer id, @RequestBody EstoqueProdutoDto estoqueProdutoDto){
        return ResponseEntity.ok(estoqueProdutoService.modificarEstoqueProduto(id, estoqueProdutoDto));
    }

}
