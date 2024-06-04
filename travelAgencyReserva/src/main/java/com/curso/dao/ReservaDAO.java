package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Reserva;
/**
 * Interfaz que define métodos de acceso a datos para la entidad Reserva.
 * Extiende JpaRepository para obtener funcionalidades CRUD básicas.
 * 
 * @author Alejandro Barbacil Castro
 */
public interface ReservaDAO extends JpaRepository<Reserva, Integer> {
	 /**
     * Busca y devuelve una lista de reservas por el ID del hotel.
     * 
     * @param idHotel el ID del hotel
     * @return una lista de reservas asociadas al hotel especificado
     */
	List<Reserva> findByidHotel(int idHotel);
}
