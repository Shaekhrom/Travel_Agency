package com.curso.service;

import java.util.List;

import com.curso.model.Vuelo;

/**
 * Interfaz que define los métodos para gestionar los vuelos.
 * Define métodos para obtener vuelos según el número de plazas disponibles y para actualizar el número de plazas de un vuelo.
 * 
 * @author Alejandro Barbacil Castro
 */
public interface VueloService {
	/**
     * Obtiene una lista de vuelos que tengan un número igual o menor de plazas disponibles que el valor proporcionado.
     * 
     * @param plazasDisponibles el número máximo de plazas disponibles
     * @return una lista de vuelos que cumplen con el criterio de plazas disponibles
     */
	List<Vuelo> obtenerVuelosSegunPlazas(int plazasDisponibles);
	/**
     * Actualiza el número de plazas disponibles de un vuelo especificado por su ID, restando las plazas reservadas.
     * 
     * @param idVuelo el ID del vuelo a actualizar
     * @param plazasReservadas el número de plazas a restar
     * @return un mensaje indicando el resultado de la operación
     */
	String actualizarVuelo (int idVuelo, int plazasReservadas);
}
