package com.example.springsecurity.entities;

import javax.persistence.*;

@Entity
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @JoinColumn(name = "person")
    @ManyToOne
    private Person user;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
