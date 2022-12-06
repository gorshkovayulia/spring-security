package com.example.springsecurity.config;

import com.example.springsecurity.filters.InitialAuthenticationFilter;
import com.example.springsecurity.filters.JwtAuthenticationFilter;
import com.example.springsecurity.providers.OtpAuthenticationProvider;
import com.example.springsecurity.providers.UsernamePasswordAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private InitialAuthenticationFilter initialAuthenticationFilter;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private OtpAuthenticationProvider otpAuthenticationProvider;

    @Autowired
    private UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        // Configures both authentication providers to the authentication manager
        auth.
                authenticationProvider(otpAuthenticationProvider).
                authenticationProvider(usernamePasswordAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // disables CSRF
        http.csrf().disable();

        // adds both custom filters into the filter chain
        http.
                addFilterAt(initialAuthenticationFilter, BasicAuthenticationFilter.class).
                addFilterAfter(jwtAuthenticationFilter, BasicAuthenticationFilter.class);

        // ensures that all requests are authenticated
        http.authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    // adds the AuthenticationManager to the Spring context so that we can autowire it from the filter class
    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
