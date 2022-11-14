package com.example.springsecurity.configs;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Collections;
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    // Represents all the logic for authentication
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        // The getName() method is inherited by Authentication from the Principal interface
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());

        // This condition generally calls UserDetailsService and PasswordEncoder to test the username and password
        if ("john".equals(username) && "12345".equals(password)) {
            return new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList());
        } else {
            throw new AuthenticationCredentialsNotFoundException("Error in authentication!");
        }
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authenticationType);
    }
}