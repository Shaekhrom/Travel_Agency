package com.curso.inicio;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Clase principal que inicia la aplicación de la agencia de viajes para la gestión de vuelos.
 * Esta clase contiene la configuración principal de Spring Boot para escanear y configurar los componentes de la aplicación.
 * Escanea y configura los controladores, servicios, entidades y repositorios necesarios para la aplicación.
 * 
 * @author Alejandro Barbacil Castro
 */

@EntityScan(basePackages="com.curso.model")
@EnableJpaRepositories(basePackages="com.curso.dao")
@SpringBootApplication(scanBasePackages = {"com.curso.controller", "com.curso.service"})
public class TravelAgencyVueloApplication {

	/**
     * Método principal que inicia la aplicación Spring Boot.
     * 
     * @param args los argumentos de línea de comandos
     */
	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyVueloApplication.class, args);
	}

}
