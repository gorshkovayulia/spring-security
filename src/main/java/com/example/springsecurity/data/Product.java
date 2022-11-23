package com.example.springsecurity.data;

import javax.persistence.*;
import java.util.Currency;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private double price;

    @Enumerated(EnumType.STRING)
    private Currency currency;

}
