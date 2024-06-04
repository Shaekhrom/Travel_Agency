package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.HotelDAO;
import com.curso.model.Hotel;
/**
 * Implementación de la interfaz HotelService que proporciona los métodos para gestionar los hoteles.
 * 
 * @author Alejandro Barbacil Castro
 */
@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelDAO dao;
	/**
     * Obtiene una lista de todos los hoteles.
     * 
     * @return una lista de hoteles
     */
	@Override
	public List<Hotel> listarHoteles() {
		/*
		List<Hotel> hoteles = dao.findAll();
		return hoteles;
		*/
		return dao.findAll();
	}
	/**
     * Obtiene un hotel por su nombre.
     * 
     * @param nombreHotel el nombre del hotel a buscar
     * @return el hotel encontrado, o null si no se encuentra ningún hotel con el nombre dado
     */
	@Override
	public Hotel obtenerHotelPorNombre(String nombreHotel) {
		return dao.findByNombre(nombreHotel);
	}

}
