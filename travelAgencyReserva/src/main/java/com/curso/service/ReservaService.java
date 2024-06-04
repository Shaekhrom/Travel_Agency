package com.curso.service;

import java.util.List;

import com.curso.model.Reserva;
/**
 * Interfaz que define los servicios relacionados con las reservas.
 * Define métodos para insertar una reserva y para listar reservas por hotel.
 * 
 * @author Alejandro Barbacil Castro
 */
public interface ReservaService {
	/**
     * Inserta una reserva en la base de datos.
     * 
     * @param reserva la reserva a insertar
     * @return un mensaje indicando el resultado de la operación
     */
	String insertarReserva(Reserva reserva);
	/**
     * Lista las reservas asociadas a un hotel específico.
     * 
     * @param idHotel el ID del hotel
     * @return una lista de reservas asociadas al hotel especificado
     */
	List<Reserva> listarReservasPorHotel(int idHotel);
}
