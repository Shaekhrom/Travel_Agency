package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.client.RestTemplate;

/**
 * Clase principal que inicia la aplicación de la agencia de viajes para gestionar reservas.
 * Esta clase configura la aplicación Spring Boot y define la configuración necesaria.
 * 
 * @author Alejandro Barbacil Castro
 */
@EntityScan(basePackages="com.curso.model")
@EnableJpaRepositories(basePackages="com.curso.dao")
@SpringBootApplication(scanBasePackages = {"com.curso.controller", "com.curso.service", "com.curso.config"})
@EnableWebSecurity
public class TravelAgencyReservaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyReservaApplication.class, args);
	}
	 /**
     * Bean que proporciona un objeto RestTemplate para realizar solicitudes HTTP.
     * 
     * @return un objeto RestTemplate configurado
     */
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	

}
