package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.HotelDAO;
import com.curso.model.Hotel;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelDAO dao;
	
	@Override
	public List<Hotel> listarHoteles() {
		/*
		List<Hotel> hoteles = dao.findAll();
		return hoteles;
		*/
		return dao.findAll();
	}

	@Override
	public Hotel obtenerHotelPorNombre(String nombreHotel) {
		return dao.findByNombre(nombreHotel);
	}

}
