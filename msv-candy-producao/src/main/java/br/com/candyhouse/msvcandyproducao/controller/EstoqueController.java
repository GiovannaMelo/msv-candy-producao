package br.com.candyhouse.msvcandyproducao.controller;

import br.com.candyhouse.msvcandyproducao.dto.EstoqueDto;
import br.com.candyhouse.msvcandyproducao.entity.Estoque;
import br.com.candyhouse.msvcandyproducao.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public ResponseEntity<List<EstoqueDto>> listarEstoque(){
        return ResponseEntity.ok(estoqueService.listarEstoque());
    }

    @PostMapping
    public ResponseEntity<EstoqueDto> criarEstoque(@RequestBody Estoque estoque){
        return ResponseEntity.ok(estoqueService.criarEstoque(estoque));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueDto> buscarIdEstoque(@PathVariable Integer id){
        return ResponseEntity.ok(estoqueService.buscarIdEstoque(id));
    }

    @GetMapping("/{idConfeitaria}")
    public ResponseEntity<List<EstoqueDto>> listarEstoqueConfeitaria (@PathVariable Integer id){
        return ResponseEntity.ok(estoqueService.listarEstoqueConfeitaria(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEstoque(@PathVariable Integer id){
        estoqueService.deletarEstoque(id);
        return  ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EstoqueDto> atualizarEstoque(@PathVariable Integer id, @RequestBody EstoqueDto estoqueDto){
       return ResponseEntity.ok(estoqueService.atualizarEstoque(id, estoqueDto));
    }

}
