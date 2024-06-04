package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.dao.ReservaDAO;
import com.curso.model.Reserva;

@Service
public class ReservaServiceImpl implements ReservaService {
	
	@Autowired
	ReservaDAO dao;
	
	@Override
	public String insertarReserva(Reserva reserva) {
		dao.save(reserva);
		return "Reserva creada con exito";
	}

	@Override
	public List<Reserva> listarReservasPorHotel(int idHotel) {
		return dao.findByidHotel(idHotel);
	}

}
