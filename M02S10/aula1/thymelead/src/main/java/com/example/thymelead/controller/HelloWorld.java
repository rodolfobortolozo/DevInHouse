package com.example.thymelead.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorld {

    @GetMapping
    public String helloWorld(Model model, @RequestParam String nome){
        model.addAttribute("nome", nome);
        return "hello";
    }


}
