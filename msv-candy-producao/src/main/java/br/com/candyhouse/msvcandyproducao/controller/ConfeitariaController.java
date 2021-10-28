package br.com.candyhouse.msvcandyproducao.controller;

import br.com.candyhouse.msvcandyproducao.dto.ConfeitariaDto;
import br.com.candyhouse.msvcandyproducao.dto.ConfeitariaLoginDto;
import br.com.candyhouse.msvcandyproducao.dto.EstoqueDto;
import br.com.candyhouse.msvcandyproducao.entity.Confeitaria;
import br.com.candyhouse.msvcandyproducao.service.ConfeitariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/confeitaria")
public class ConfeitariaController {

    @Autowired
    ConfeitariaService confeitariaService;

    @GetMapping
    public ResponseEntity<List<ConfeitariaDto>> listarConfeitaria(){
        return ResponseEntity.ok(confeitariaService.listarConfeitaria());
    }

    @PostMapping("/save")
    public ConfeitariaDto cadastrarConfeitaria(@RequestBody ConfeitariaDto confeitariaDto){
        return confeitariaService.cadastrarConfeitaria(confeitariaDto);
    }

    @PostMapping("/login")
    public Integer loginConfeitaria(@RequestBody ConfeitariaLoginDto confeitariaLoginDto){
        return confeitariaService.loginConfeitaria(confeitariaLoginDto);
    }
}
