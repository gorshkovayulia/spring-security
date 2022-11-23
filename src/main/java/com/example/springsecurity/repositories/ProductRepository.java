package com.example.springsecurity.repositories;

import com.example.springsecurity.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
