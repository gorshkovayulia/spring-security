package com.example.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {

    @GetMapping("/main")
    public String main() {
        return "main.html";
    }
}
