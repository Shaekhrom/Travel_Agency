package com.curso.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Vuelo;
import com.curso.service.VueloService;
/**
 * Controlador para manejar las operaciones relacionadas con los vuelos.
 * Permite obtener vuelos según el número de plazas solicitadas y actualizar el número de plazas de un vuelo por su ID.
 * 
 * @author Alejandro Barbacil Castro
 */
@RestController
public class VueloController {

	@Autowired
	VueloService service;
	
	 /**
     * Devuelve una lista de vuelos que tengan el número igual o mayor de plazas solicitadas.
     * 
     * @param plazasSolicitadas el número mínimo de plazas solicitadas
     * @return una lista de vuelos que cumplen con el criterio de plazas solicitadas
     */
	//uso en GET -->http://localhost:7000/vuelos/50
	@GetMapping(value="vuelos/{plazasSolicitadas}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> vuelos(@PathVariable("plazasSolicitadas") int plazasSolicitadas){
		return service.obtenerVuelosSegunPlazas(plazasSolicitadas);
	}
	
	/**
     * Actualiza (restando) las plazas de un vuelo por su ID.
     * 
     * @param idVuelo el ID del vuelo a actualizar
     * @param plazasReservadas el número de plazas a restar
     * @return un mapa con un mensaje indicando el resultado de la operación
     */
	//uso en PUT --> http://localhost:7000/actualizarVuelo/1/10
	@PutMapping(value = "actualizarVuelo/{idVuelo}/{plazasReservadas}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> actualizarVuelo(@PathVariable("idVuelo") int idVuelo, @PathVariable("plazasReservadas") int plazasReservadas) {
        Map<String, Object> response = new HashMap<>();
        String mensaje = service.actualizarVuelo(idVuelo, plazasReservadas);
        response.put("mensaje", mensaje);
        return response;
    }
}
