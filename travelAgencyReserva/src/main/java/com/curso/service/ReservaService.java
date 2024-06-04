package com.curso.service;

import java.util.List;

import com.curso.model.Reserva;

public interface ReservaService {
	String insertarReserva(Reserva reserva);
	
	List<Reserva> listarReservasPorHotel(int idHotel);
}
