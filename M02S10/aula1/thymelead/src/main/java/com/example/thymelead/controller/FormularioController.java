package com.example.thymelead.controller;

import com.example.thymelead.Pessoa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/formulario")
public class FormularioController {

    @PostMapping
    public String postFormulario(@Validated Pessoa pessoa, Model model){
        model.addAttribute("nome", pessoa.getNome());
        return "hello";
    }

    @GetMapping
    public String helloWorld(Pessoa pessoa, Model model){
        return "formulario";
    }
}
