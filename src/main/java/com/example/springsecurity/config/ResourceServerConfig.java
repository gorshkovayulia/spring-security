package com.example.springsecurity.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

<<<<<<< HEAD
    @Value("${jwt.key}") // Injects the key value from the application.yml file
    private String jwtKey;

    // Configures the TokenStore
=======
    @Value("${jwt.key}")
    private String jwtKey;

>>>>>>> 2baf6535dd7b77671f619aec004fe048d46de43a
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.tokenStore(tokenStore());
    }

<<<<<<< HEAD
    // Declares the TokenStore and adds it to the Spring context
=======
>>>>>>> 2baf6535dd7b77671f619aec004fe048d46de43a
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

<<<<<<< HEAD
    // Creates an access token converter and sets the symmetric key used to validate token signatures
=======
>>>>>>> 2baf6535dd7b77671f619aec004fe048d46de43a
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(jwtKey);
        return converter;
    }
}
