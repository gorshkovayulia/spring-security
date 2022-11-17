package com.example.springsecurity.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class InMemoryUserDetailsService implements UserDetailsService {
    private final List<UserDetails> users; //UserDetailsService manages the list of users in-memory

    public InMemoryUserDetailsService(List<UserDetails> users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.stream()
                // From the list of users, filters the one that has the requested username
                .filter(u -> u.getUsername().equals(username))
                // If there is such a user, returns it
                .findFirst()
                // If a user with this username does not exist, throws an exception
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
