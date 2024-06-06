package com.curso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // (Opcional) Deshabilitar protección CSRF (considera las implicaciones de seguridad)
            .authorizeHttpRequests(authz -> authz
                .anyRequest().permitAll()); // Permitir acceso a todas las rutas
        
        return http.build();
    }
}
