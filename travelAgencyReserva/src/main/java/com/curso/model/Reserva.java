package com.curso.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 * Clase que representa una reserva de hotel y vuelo.
 * Esta clase está mapeada a la tabla "reserva" en la base de datos.
 * 
 * @author Alejandro Barbacil Castro
 */
@Entity
@Table(name = "reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reserva")
	private int idReserva;
	@Column(name = "nombre_cliente")
	private String nombreCliente;
	private String dni;
	@Column(name = "id_hotel")
	private int idHotel;
	@Column(name = "id_vuelo")
	private int idVuelo;
	@Column(name = "num_personas")
	private int numPersonas;
	
	/**
     * Constructor por defecto de la clase Reserva.
     */
	public Reserva() {
		super();
	}

	/**
     * Constructor de la clase Reserva con parámetros.
     * 
     * @param idReserva el ID de la reserva
     * @param nombreCliente el nombre del cliente
     * @param dni el DNI del cliente
     * @param idHotel el ID del hotel
     * @param idVuelo el ID del vuelo
     * @param numPersonas el número de personas en la reserva
     */
	public Reserva(int idReserva, String nombreCliente, String dni, int idHotel, int idVuelo, int numPersonas) {
		super();
		this.idReserva = idReserva;
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.idHotel = idHotel;
		this.idVuelo = idVuelo;
		this.numPersonas = numPersonas;
	}


	public int getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}


	public String getNombreCliente() {
		return nombreCliente;
	}


	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public int getIdHotel() {
		return idHotel;
	}


	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}


	public int getIdVuelo() {
		return idVuelo;
	}


	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}


	public int getNumPersonas() {
		return numPersonas;
	}


	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idReserva);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return idReserva == other.idReserva;
	}
	
	
	
	
	
}
