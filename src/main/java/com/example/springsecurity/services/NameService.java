package com.example.springsecurity.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NameService {

    private final HashMap<String, List<String>> secretNames = new HashMap<String, List<String>>() {{
        put("natalie", Arrays.asList("Energico", "Perfecto"));
        put("emma", Collections.singletonList("Fantastico"));
    }};

    @PreAuthorize("#name == authentication.principal.username") // Uses #name to represent the value of the method parameters in the authorization expression
    public List<String> getSecretNames(String name) {
        return secretNames.get(name);
    }
}
