package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.VueloDAO;
import com.curso.model.Vuelo;

import jakarta.transaction.Transactional;

/**
 * Implementación de la interfaz VueloService que proporciona la lógica de negocio para gestionar vuelos.
 * Esta clase realiza operaciones de consulta y actualización de vuelos utilizando el DAO de Vuelo.
 * 
 * @author Alejandro Barbacil Castro
 */

@Service
public class VueloServiceImpl implements VueloService {
	@Autowired
	VueloDAO dao;

	 /**
     * Obtiene una lista de vuelos que tengan un número igual o menor de plazas disponibles que el valor proporcionado.
     * 
     * @param plazasDisponibles el número máximo de plazas disponibles
     * @return una lista de vuelos que cumplen con el criterio de plazas disponibles
     */
	@Override
	public List<Vuelo> obtenerVuelosSegunPlazas(int plazasDisponibles) {
		return dao.findByPlazasDisponiblesLessThanOrEqual(plazasDisponibles);
	}

	/**
     * Actualiza el número de plazas disponibles de un vuelo especificado por su ID, restando las plazas reservadas.
     * 
     * @param idVuelo el ID del vuelo a actualizar
     * @param plazasReservadas el número de plazas a restar
     * @return un mensaje indicando el resultado de la operación
     */
	@Override
	@Transactional
    public String actualizarVuelo(int idVuelo, int plazasReservadas) {
        if (dao.canSubtractPlazas(plazasReservadas, idVuelo)) {
            dao.subtractPlazas(plazasReservadas, idVuelo);
            return"Actualizado con exito";
        } else {
        	return"Error al actualizar";
        }
    }

}
