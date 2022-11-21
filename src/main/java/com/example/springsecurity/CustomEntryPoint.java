package com.example.springsecurity;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomEntryPoint implements AuthenticationEntryPoint {

    // adds a header to the response and sets the HTTP status to 401 Unauthorized
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        response.addHeader("message", "Luke, I am your father!");
        response.sendError(HttpStatus.UNAUTHORIZED.value());
    }
}
