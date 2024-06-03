package com.curso.service;

import java.util.List;

import com.curso.model.Vuelo;

public interface VueloService {
	List<Vuelo> obtenerVuelosSegunPlazas(int plazasDisponibles);
	
	String actualizarVuelo (int idVuelo, int plazasReservadas);
}
