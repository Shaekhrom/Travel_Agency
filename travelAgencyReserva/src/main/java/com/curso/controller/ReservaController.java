package com.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Reserva;
import com.curso.service.ReservaService;

@RestController
public class ReservaController {

	@Autowired
	private ReservaService service;

	@Autowired
	private RestTemplate restTemplate;

	private static final String VUELO_SERVICE_URL = "http://localhost:7000/actualizarVuelo";

	/*
	 * Inserta una reserva en la BBDD, llama a actualizarVuelo del microservicio
	 * vuelo
	 * Ejemplo de uso en POST --> http://localhost:8080/insertarReserva
	 * 
	 * JSON
	 * {
	 *	  "nombreCliente": "Juan Perez",
	 *	  "dni": "12345678A",
	 *	  "idHotel": 2,
	 *	  "idVuelo": 5,
	 *	  "numPersonas": 2
	 *	}
	 */
	@PostMapping("/insertarReserva")
	public ResponseEntity<String> insertarReserva(@RequestBody Reserva reserva) {
		try {
			service.insertarReserva(reserva);
			actualizarPlazas(reserva.getIdVuelo(), reserva.getNumPersonas());
			return ResponseEntity.status(HttpStatus.CREATED).body("Reserva creada correctamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al crear la reserva: " + e.getMessage());

		}

	}
	
	/**
	 * 
	 * Intenta actualizar las plazas de un vuelo por id, si no lo consigue muestra mensaje de error
	 * @param idVuelo
	 * @param plazasReservadas
	 */
	private void actualizarPlazas(int idVuelo, int plazasReservadas) {
		String url = VUELO_SERVICE_URL + "/" + idVuelo + "/" + plazasReservadas;
		
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Void> response = restTemplate.exchange(
            url,
            HttpMethod.PUT,
            requestEntity,
            Void.class
        );

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Error al actualizar las plazas del vuelo con ID: " + idVuelo);
        }
	}
	
}
