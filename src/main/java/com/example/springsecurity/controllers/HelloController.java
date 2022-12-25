package com.example.springsecurity.controllers;

import com.example.springsecurity.services.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private NameService nameService;

    @GetMapping("/secret/names/{name}") // Defines an endpoint that takes a value from a path variable
    public List<String> names(@PathVariable String name) {

        // Calls the protected method to obtain the secret names of the users
        return nameService.getSecretNames(name);
    }
}
