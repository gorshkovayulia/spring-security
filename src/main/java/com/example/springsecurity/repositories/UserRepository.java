package com.example.springsecurity.repositories;

import com.example.springsecurity.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findUserByUsername(String username);

}
