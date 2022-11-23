package com.example.springsecurity.service;

import com.example.springsecurity.CustomUserDetails;
import com.example.springsecurity.data.User;
import com.example.springsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) {
        Supplier<UsernameNotFoundException> s = () -> new UsernameNotFoundException("Problem during authentication!");

        User user = userRepository
                .findUserByUsername(username)
                .orElseThrow(s);

        return new CustomUserDetails(user); // wrap the User instance with the CustomUserDetails decorator and return it
    }
}
