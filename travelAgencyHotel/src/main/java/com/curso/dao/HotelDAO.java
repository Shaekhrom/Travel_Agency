package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Hotel;
/**
 * Interfaz que proporciona métodos para acceder a la capa de persistencia de la entidad Hotel.
 * Extiende JpaRepository para heredar funcionalidades de acceso a datos.
 * 
 * @author Alejandro Barbacil Castro
 */
public interface HotelDAO extends JpaRepository<Hotel, Integer> {
	/**
     * Busca un hotel por su nombre.
     * 
     * @param nombre el nombre del hotel a buscar
     * @return el hotel con el nombre especificado
     */
	Hotel findByNombre(String nombre);
}
