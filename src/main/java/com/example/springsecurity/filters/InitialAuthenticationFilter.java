package com.example.springsecurity.filters;

import com.example.springsecurity.OtpAuthentication;
import com.example.springsecurity.UsernamePasswordAuthentication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

@Component
public class InitialAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private AuthenticationManager manager;

    @Value("${jwt.signing.key}")
    private String signingKey; // Takes the value of the key used to sign the JWT token from the properties file

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        String code = request.getHeader("code");

        // If the HTTP request doesn’t contain an OTP, we assume we have to authenticate based on username and password
        if (code == null) {
            Authentication a = new UsernamePasswordAuthentication(username, password);
            // Calls the AuthenticationManager with an instance of UsernamePasswordAuthentication
            manager.authenticate(a);
        } else {
            // We consider, in this case, that the client sent an OTP for the second authentication step
            // For the second authentication step, creates an instance of type OtpAuthentication and sends it to
            // the AuthenticationManager, which finds a proper provider for it
            Authentication a = new OtpAuthentication(username, code);
            a = manager.authenticate(a);

            SecretKey key = Keys.hmacShaKeyFor(signingKey.getBytes(StandardCharsets.UTF_8));

            // Builds a JWT and stores the username of the authenticated user as one of its claims.
            // We use the Adds the token to the key to sign the token
            String jwt = Jwts.builder()
                    .setClaims(Collections.singletonMap("username", username))
                    .signWith(key)
                    .compact();
            // Adds the token to the Authorization header of the HTTP response
            response.setHeader("Authorization", jwt);
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getServletPath()
                .equals("/login");
    }
}
