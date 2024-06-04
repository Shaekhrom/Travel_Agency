package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.curso.model.Vuelo;
/**
 * Interfaz para acceder a los datos de los vuelos en la base de datos.
 * Proporciona métodos para realizar consultas y operaciones de actualización en la tabla de vuelos.
 * Extiende JpaRepository para obtener funcionalidades CRUD básicas.
 * 
 * @author Alejandro Barbacil Castro
 */
public interface VueloDAO extends JpaRepository<Vuelo, Integer> {
	 /**
     * Busca vuelos que tengan un número igual o menor de plazas disponibles que el valor proporcionado.
     * 
     * @param plazas el número máximo de plazas disponibles
     * @return una lista de vuelos que cumplen con el criterio de plazas disponibles
     */
	@Query("SELECT v FROM Vuelo v WHERE v.plazasDisponibles >= :plazas")
    List<Vuelo> findByPlazasDisponiblesLessThanOrEqual(@Param("plazas") int plazas);
	
	/**
     * Comprueba si se pueden restar las plazas especificadas de un vuelo determinado.
     * 
     * @param plazas el número de plazas a restar
     * @param id el ID del vuelo
     * @return true si se pueden restar las plazas, false de lo contrario
     */
	@Query("SELECT CASE WHEN (v.plazasDisponibles - :plazas) < 0 THEN false ELSE true END FROM Vuelo v WHERE v.idVuelo = :id")
    boolean canSubtractPlazas(@Param("plazas") int plazas, @Param("id") int id);
    
	/**
     * Resta el número especificado de plazas disponibles de un vuelo determinado.
     * 
     * @param plazas el número de plazas a restar
     * @param id el ID del vuelo
     */
	@Modifying
    @Query("UPDATE Vuelo v SET v.plazasDisponibles = v.plazasDisponibles - :plazas WHERE v.idVuelo = :id")
    void subtractPlazas(@Param("plazas") int plazas, @Param("id") int id);
}
