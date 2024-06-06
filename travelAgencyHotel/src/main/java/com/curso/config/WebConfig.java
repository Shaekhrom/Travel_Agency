package com.curso.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	registry.addMapping("/**") // Se aplica a todas las rutas de la aplicación
        .allowedOrigins("*") // Permitir todas las solicitudes de cualquier origen
        .allowedMethods("*") // Permitir todos los métodos HTTP (GET, POST, PUT, DELETE, etc.)
        .allowedHeaders("*") // Permitir todas las cabeceras de solicitud
                .maxAge(3600); // Tiempo máximo de almacenamiento en caché de la respuesta preflight (en segundos)
    }
}

