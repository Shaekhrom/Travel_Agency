package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Reserva;

public interface ReservaDAO extends JpaRepository<Reserva, Integer> {

}
