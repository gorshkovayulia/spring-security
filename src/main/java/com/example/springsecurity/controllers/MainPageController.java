package com.example.springsecurity.controllers;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class MainPageController {

    private Logger logger = Logger.getLogger(MainPageController.class.getName());

    // Spring Boot automatically injects the Authentication object representing the user in the method’s parameter
    @GetMapping("/")
    public String main(OAuth2AuthenticationToken token) {
        logger.info(String.valueOf(token.getPrincipal()));
        return "templates/main.html";
    }
}
