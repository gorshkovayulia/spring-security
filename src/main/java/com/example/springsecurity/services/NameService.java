package com.example.springsecurity.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class NameService {

    @PreAuthorize("hasAuthority('write')") // Defines the authorization rule.
    public String getName() {
        return "Fantastico";
    }
}
