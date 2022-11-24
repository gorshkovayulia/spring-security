package com.example.springsecurity.entities;

import javax.persistence.*;
import java.util.Currency;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private double price;

    private Currency currency;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
