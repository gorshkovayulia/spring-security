package com.example.springsecurity.config;

import com.example.springsecurity.repositories.CustomCsrfTokenRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public CsrfTokenRepository customTokenRepository() {
        return new CustomCsrfTokenRepository();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // where 'c' is a CsrfConfigurer
        http.csrf(c -> {
            // plug the new CsrfTokenRepository implementation into the CSRF protection mechanism
            c.csrfTokenRepository(customTokenRepository());
            // exclude this path from the CSRF protection mechanism
            c.ignoringAntMatchers("/ciao");
            c.ignoringAntMatchers("/h2-console/**");
        });

        http.authorizeRequests()
                .anyRequest().permitAll();
    }
}
