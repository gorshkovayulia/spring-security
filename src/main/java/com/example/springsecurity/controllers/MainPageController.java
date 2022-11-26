package com.example.springsecurity.controllers;

import com.example.springsecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainPageController {

    @Autowired
    private ProductService productService;

    @GetMapping("/main")
    public String main(Authentication authentication, Model model) {
        model.addAttribute("username", authentication.getName());
        model.addAttribute("products", productService.findAll());

        return "main.html";
    }

    @GetMapping("/ciao")
    public String ciao() {
        return "Ciao!";
    }

    @GetMapping("/hola")
    public String hola() {
        return "Hola!";
    }
}
