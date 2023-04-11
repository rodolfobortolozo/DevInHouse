package com.example.securityjwt.controller;

import com.example.securityjwt.model.Produto;
import com.example.securityjwt.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping("/todos")
    public Collection<Produto> listaTodosProdutos(){
        return service.listarProdutos();
    }

    @PostMapping("/novo")
    public Produto salvaProduto(@RequestBody Produto produto){
        return service.salvarProduto(produto);
    }
}
