package com.example.springsecurity.entities;

import com.example.springsecurity.entities.enums.EncryptionAlgorithm;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private EncryptionAlgorithm algorithm;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Authority> authorities;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public EncryptionAlgorithm getAlgorithm() {
        return algorithm;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }
}
