package com.example.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService() {

        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();

        User user = (User) User.withUsername("john")
                .password("12345")
                .authorities("read")
                .build();

        // add the user to be managed by UserDetailsService
        userDetailsService.createUser(user);
        return userDetailsService;
    }

    /**
     * Validates the password
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        // NoOpPasswordEncoder is a good option when we don’t want to focus on the hashing algorithm of the password
        return NoOpPasswordEncoder.getInstance();
    }
}
