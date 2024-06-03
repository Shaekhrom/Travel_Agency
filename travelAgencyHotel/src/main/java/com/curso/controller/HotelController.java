package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Hotel;
import com.curso.service.HotelService;

@RestController
public class HotelController {

	@Autowired
	HotelService service;
	
	//lista todos los hoteles
	//uso en GET --> http://localhost:8000/hoteles
	@GetMapping(value="hoteles", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> hoteles(){
		return service.listarHoteles();
	}
	
	
	//obtiene datos de un hotel por nombre del hotel
	//uso en GET --> http://localhost:8000/hotel/Grand Hotel
	@GetMapping(value="hotel/{nombreHotel}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Hotel obtenerHotelPorNombre(@PathVariable("nombreHotel") String nombreHotel){
		return service.obtenerHotelPorNombre(nombreHotel);
	}
}
