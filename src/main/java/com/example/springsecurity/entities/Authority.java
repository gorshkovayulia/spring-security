package com.example.springsecurity.entities;

import javax.persistence.*;

@Entity
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @JoinColumn(name = "user")
    @ManyToOne
    private User user;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
