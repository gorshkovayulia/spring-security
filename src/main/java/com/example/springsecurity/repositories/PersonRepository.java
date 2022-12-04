package com.example.springsecurity.repositories;

import com.example.springsecurity.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, String> {

    Optional<Person> findUserByUsername(String username);

}
