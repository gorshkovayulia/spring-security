package com.example.springsecurity.controllers;

import com.example.springsecurity.entities.Otp;
import com.example.springsecurity.entities.Person;
import com.example.springsecurity.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController {

    @Autowired
    private PersonService personService;

    @PostMapping("/user/add")
    public void addUser(@RequestBody Person person) {
        personService.addPerson(person);
    }
    @PostMapping("/user/auth")
    public void auth(@RequestBody Person person) {
        personService.auth(person);
    }

    @PostMapping("/otp/check")
    public void check(@RequestBody Otp otp, HttpServletResponse response) {
        if (personService.check(otp)) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
