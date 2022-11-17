package com.example.springsecurity;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * The simplest implementation of a PasswordEncoder
 */
public class PlainTextPasswordEncoder implements PasswordEncoder {

    // We don’t change the password, just return it as is
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.equals(encodedPassword);
    }
}
