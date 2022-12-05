package com.example.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * The configuration class for the authentication server
 */
@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // to hash the passwords stored in the DB
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // so we can call all the endpoints of the app directly
        http.authorizeRequests().anyRequest().permitAll(); // allows all the calls w/o authentication
    }
}
