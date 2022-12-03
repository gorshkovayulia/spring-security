package com.example.springsecurity.repositories;

import com.example.springsecurity.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaTokenRepository extends JpaRepository<Token, Integer> {

    Optional<Token> findTokenByIdentifier(String identifier); // gets the CSRF token from the database for a specific client
}
