package org.jt.ApiGateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity)throws Exception {

        return httpSecurity
                .authorizeExchange(exchange -> exchange
                        .anyExchange().authenticated()
                )
                .oauth2Login() // Configures OAuth2 login support
                .and()
                .oauth2ResourceServer() // Configures OAuth2 resource server
                .jwt() // Uses JWT token
                .and()
                .build();
    }


}