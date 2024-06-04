package com.curso.service;

import java.util.List;

import com.curso.model.Hotel;
/**
 * Interfaz que define los métodos para gestionar los hoteles.
 * Utilizada para definir el contrato de servicio para la gestión de hoteles.
 * 
 * @author Alejandro Barbacil Castro
 */
public interface HotelService {
	/**
     * Obtiene una lista de todos los hoteles.
     * 
     * @return una lista de hoteles
     */
	List<Hotel> listarHoteles();
	/**
     * Obtiene un hotel por su nombre.
     * 
     * @param nombreHotel el nombre del hotel a buscar
     * @return el hotel encontrado, o null si no se encuentra ningún hotel con el nombre dado
     */
	Hotel obtenerHotelPorNombre(String nombreHotel);
}
