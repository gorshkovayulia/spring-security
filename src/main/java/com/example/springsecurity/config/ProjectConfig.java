package com.example.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // where 'c' is a CsrfConfigurer
        http.csrf(c -> {
            c.ignoringAntMatchers("/ciao"); // exclude this path from the CSRF protection mechanism
        });

        http.authorizeRequests()
                .anyRequest().permitAll();
    }
}
