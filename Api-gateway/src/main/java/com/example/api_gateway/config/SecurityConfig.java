package com.example.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)  // Disable CSRF
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/**").permitAll()  // Allow all requests
                )
                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)  // Disable login prompt
                .formLogin(ServerHttpSecurity.FormLoginSpec::disable); // Disable form login

        return http.build();
    }
}
