package com.example.springsecurity.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @PostMapping("/hello") // path remains under CSRF protection
    public String postHello() {
        return "Post Hello!";
    }

    @PostMapping("/ciao") // can be called without a CSRF token
    public String postCiao() {
        return "Post Ciao";
    }
}
