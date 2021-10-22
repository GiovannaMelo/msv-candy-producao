package br.com.candyhouse.msvcandyproducao.controller;

import br.com.candyhouse.msvcandyproducao.dto.ConfeitariaDto;
import br.com.candyhouse.msvcandyproducao.dto.ConfeitariaLoginDto;
import br.com.candyhouse.msvcandyproducao.entity.Confeitaria;
import br.com.candyhouse.msvcandyproducao.service.ConfeitariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/confeitaria")
public class ConfeitariaController {

    @Autowired
    ConfeitariaService confeitariaService;

    @PostMapping("/save")
    public ConfeitariaDto cadastrarConfeitaria(@RequestBody ConfeitariaDto confeitariaDto){
        return confeitariaService.cadastrarConfeitaria(confeitariaDto);
    }

    @PostMapping("/login")
    public Integer loginConfeitaria(@RequestBody ConfeitariaLoginDto confeitariaLoginDto){
        return confeitariaService.loginConfeitaria(confeitariaLoginDto);
    }
}
