package com.example.securituversao5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    // /
    // localhost:8080/login
    @GetMapping("/login")
    public String login(){return "login";}
}
