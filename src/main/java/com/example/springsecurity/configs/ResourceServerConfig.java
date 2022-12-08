package com.example.springsecurity.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableResourceServer // instruct Spring Boot to enable the configuration specific to the OAuth 2 resource server
public class ResourceServerConfig {
}
