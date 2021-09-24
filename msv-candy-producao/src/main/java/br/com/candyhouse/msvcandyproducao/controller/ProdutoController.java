package br.com.candyhouse.msvcandyproducao.controller;

import br.com.candyhouse.msvcandyproducao.dto.ProdutoDto;
import br.com.candyhouse.msvcandyproducao.dto.ProdutoResponseDto;
import br.com.candyhouse.msvcandyproducao.dto.ProdutosDisponiveisDto;
import br.com.candyhouse.msvcandyproducao.entity.Produto;
import br.com.candyhouse.msvcandyproducao.repository.ProdutoRepository;
import br.com.candyhouse.msvcandyproducao.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> listarProdutos(){
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<ProdutosDisponiveisDto>> listarProdutosDisponiveis(){
        return ResponseEntity.ok(produtoService.listarProdutosDisponiveis());
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDto> criarProduto(@RequestBody Produto produto){
        return ResponseEntity.ok(produtoService.criarProduto(produto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> buscarIdProduto(@PathVariable Integer id){
        return ResponseEntity.ok(produtoService.buscarIdProduto(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Integer id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<ProdutoDto> atualizarProduto(@PathVariable Integer id, @RequestBody ProdutoDto produtoDto){
        return ResponseEntity.ok(produtoService.atualizarProduto(id, produtoDto));
    }
}
