package com.example.demo.controller;

import com.example.demo.controller.dto.NovoProdutoDto;
import com.example.demo.model.Produto;
import com.example.demo.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public String listaProdutos(Model model){
        model.addAttribute("produtos",service.listarProdutos());
        return "lista";
    }

    @PostMapping("/novo")
    public String novoProduto(@Valid NovoProdutoDto novoProdutoDto, BindingResult result){
        if (result.hasErrors())
                return "formulario";
        service.salvarProdutos(novoProdutoDto.toProduto());
        return "redirect:/produto";
    }

    @GetMapping("/form")
    public String formularioPedido(NovoProdutoDto novoProdutoDto){
        return "formulario";
    }

}
