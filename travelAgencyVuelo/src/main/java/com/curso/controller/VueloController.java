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

@RestController
public class VueloController {

	@Autowired
	VueloService service;
	
	//devuelve una lista de vuelos que tengan el numero igual o mayor de plazas solicitadas en parametro
	//uso en GET -->http://localhost:7000/vuelos/50
	@GetMapping(value="vuelos/{plazasSolicitadas}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> vuelos(@PathVariable("plazasSolicitadas") int plazasSolicitadas){
		return service.obtenerVuelosSegunPlazas(plazasSolicitadas);
	}
	
	//actualiza (Restando) las plazas de un vuelo por id
	//uso en PUT --> http://localhost:7000/actualizarVuelo/1/10
	@PutMapping(value = "actualizarVuelo/{idVuelo}/{plazasReservadas}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> actualizarVuelo(@PathVariable("idVuelo") int idVuelo, @PathVariable("plazasReservadas") int plazasReservadas) {
        Map<String, Object> response = new HashMap<>();
        String mensaje = service.actualizarVuelo(idVuelo, plazasReservadas);
        response.put("mensaje", mensaje);
        return response;
    }
}
