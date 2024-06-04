package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.dao.ReservaDAO;
import com.curso.model.Reserva;
/**
 * Implementación de la interfaz ReservaService que proporciona métodos para manipular reservas.
 * Esta clase utiliza ReservaDAO para acceder a la capa de persistencia.
 * 
 * @author Alejandro Barbacil Castro
 */
@Service
public class ReservaServiceImpl implements ReservaService {
	
	@Autowired
	ReservaDAO dao;
	 /**
     * Inserta una reserva en la base de datos.
     * 
     * @param reserva la reserva a insertar
     * @return un mensaje indicando el resultado de la operación
     */
	@Override
	public String insertarReserva(Reserva reserva) {
		dao.save(reserva);
		return "Reserva creada con exito";
	}
	 /**
     * Lista las reservas asociadas a un hotel específico.
     * 
     * @param idHotel el ID del hotel
     * @return una lista de reservas asociadas al hotel especificado
     */
	@Override
	public List<Reserva> listarReservasPorHotel(int idHotel) {
		return dao.findByidHotel(idHotel);
	}

}
