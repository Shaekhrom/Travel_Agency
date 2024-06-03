package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.VueloDAO;
import com.curso.model.Vuelo;

import jakarta.transaction.Transactional;

@Service
public class VueloServiceImpl implements VueloService {
	@Autowired
	VueloDAO dao;

	//devuelve una lista de vuelos que sus plazas sean iguales o superior a las pasadas por parametro
	@Override
	public List<Vuelo> obtenerVuelosSegunPlazas(int plazasDisponibles) {
		return dao.findByPlazasDisponiblesLessThanOrEqual(plazasDisponibles);
	}

	//primero comprueba si es posible restar las plazas, si lo es las resta y devuelve un string segun si las ha podido restar o no
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
