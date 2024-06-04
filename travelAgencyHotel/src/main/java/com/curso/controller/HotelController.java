package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Hotel;
import com.curso.service.HotelService;
/**
 * Controlador para manejar las operaciones relacionadas con los hoteles.
 * Permite listar todos los hoteles y obtener información de un hotel por su nombre.
 * 
 * @author Alejandro Barbacil Castro
 */
@RestController
public class HotelController {

	@Autowired
	HotelService service;
	
	/**
     * Lista todos los hoteles.
     * 
     * @return una lista de todos los hoteles
     */
	//uso en GET --> http://localhost:8000/hoteles
	@GetMapping(value="hoteles", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> hoteles(){
		return service.listarHoteles();
	}
	
	
	/**
     * Obtiene datos de un hotel por su nombre.
     * 
     * @param nombreHotel el nombre del hotel
     * @return los datos del hotel con el nombre especificado
     */
	//uso en GET --> http://localhost:8000/hotel/Grand Hotel
	@GetMapping(value="hotel/{nombreHotel}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Hotel obtenerHotelPorNombre(@PathVariable("nombreHotel") String nombreHotel){
		return service.obtenerHotelPorNombre(nombreHotel);
	}
}
