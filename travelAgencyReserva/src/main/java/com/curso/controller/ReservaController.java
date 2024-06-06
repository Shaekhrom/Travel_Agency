package com.curso.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Reserva;
import com.curso.service.ReservaService;

/**
 * Controlador para manejar las operaciones relacionadas con las reservas.
 * Permite insertar reservas y listar reservas por nombre de hotel.
 * 
 * @author Alejandro Barbacil Castro
 */

@RestController
public class ReservaController {

	@Autowired
	private ReservaService service;

	@Autowired
	private RestTemplate restTemplate;

	private static final String VUELO_SERVICE_URL = "http://localhost:7000/actualizarVuelo";
	private static final String HOTEL_SERVICE_URL = "http://localhost:8000/hotel/{nombreHotel}";


	/**
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
	@CrossOrigin(origins = "http://localhost:3000")
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
     * Intenta actualizar las plazas de un vuelo por ID, mostrando un mensaje de error si no lo consigue.
     * 
     * @param idVuelo el ID del vuelo a actualizar
     * @param plazasReservadas el número de plazas reservadas
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
	
	
	/**
     * Llama al microservicio de hotel usando el nombre del hotel para obtener información del hotel.
     * Luego llama al método listarReservasPorHotel para mostrar las reservas por ID de hotel.
     * Ejemplo de uso en GET --> http://localhost:8080/reserva/Sunset Resort
     *
     * @param nombreHotel el nombre del hotel a buscar
     * @return ResponseEntity con la lista de reservas o mensaje de error
     */
	
	@GetMapping("/reserva/{nombreHotel}")
    public ResponseEntity<?> listarReservasPorNombreHotel(@PathVariable String nombreHotel) {
        try {
            // Llamar al microservicio del hotel para obtener la información del hotel
            ResponseEntity<Map> responseEntity = restTemplate.exchange(
                HOTEL_SERVICE_URL,
                HttpMethod.GET,
                null,
                Map.class,
                nombreHotel
            );

            if (!responseEntity.getStatusCode().is2xxSuccessful()) {
                throw new RuntimeException("Error al obtener datos del hotel: " + nombreHotel);
            }

            Map<String, Object> hotelData = responseEntity.getBody();
            if (hotelData == null || !hotelData.containsKey("idHotel")) {
                throw new RuntimeException("El hotel no ha sido encontrado: " + nombreHotel);
            }

            int idHotel = (int) hotelData.get("idHotel");

            // Llamar al servicio para obtener la lista de reservas por ID de hotel
            List<Reserva> reservas = service.listarReservasPorHotel(idHotel);

            if (reservas.isEmpty()) {
                return ResponseEntity.ok("No hay reservas disponibles para el hotel: " + nombreHotel);
            }

            return ResponseEntity.ok(reservas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener las reservas: " + e.getMessage());
        }
    }
}
