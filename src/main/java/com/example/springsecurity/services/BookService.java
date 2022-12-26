package com.example.springsecurity.services;

import com.example.springsecurity.Employee;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

@Service
public class BookService {

    private final HashMap<String, Employee> records = new HashMap<String, Employee>() {{
        put("emma", new Employee(
                "Emma Thompson",
                Collections.singletonList("Karamazov Brothers"),
                Arrays.asList("accountant", "reader")));
        put("natalie", new Employee(
                "Natalie Parker",
                Collections.singletonList("Beautiful Paris"),
                Collections.singletonList("researcher")));
    }};

    @PostAuthorize("returnObject.roles.contains('reader')")
    public Employee getBookDetails(String name) {
        return records.get(name);
    }
}
