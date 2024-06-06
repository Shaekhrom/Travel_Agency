package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
/**
 * Clase de inicio de la aplicación Travel Agency Hotel.
 * Configura la aplicación Spring Boot para escanear los paquetes necesarios y configurar los beans necesarios.
 * 
 * @author Alejandro Barbacil Castro
 */
@EntityScan(basePackages="com.curso.model")
@EnableJpaRepositories(basePackages="com.curso.dao")
@SpringBootApplication(scanBasePackages = {"com.curso.controller", "com.curso.service", "com.curso.config"})
public class TravelAgencyHotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyHotelApplication.class, args);
	}
	/**
     * Bean para configurar RestTemplate.
     * 
     * @return una instancia de RestTemplate
     */
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
