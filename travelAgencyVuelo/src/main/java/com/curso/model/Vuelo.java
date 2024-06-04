package com.curso.model;


import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Clase que representa un vuelo en la agencia de viajes.
 * Esta clase define los atributos y métodos relacionados con un vuelo.
 * 
 * @author Alejandro Barbacil Castro
 */

@Entity
public class Vuelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vuelo")
	private int idVuelo;
	private String compania;
	@Column(name = "fecha_vuelo")
	private Date fechaVuelo;
	private double precio;
	@Column(name = "plazas_disponibles")
	private int plazasDisponibles;
	/**
     * Constructor por defecto de la clase Vuelo.
     */
	public Vuelo() {
		super();
	}

	 /**
     * Constructor de la clase Vuelo con parámetros.
     * 
     * @param idVuelo el ID del vuelo
     * @param compania la compañía del vuelo
     * @param fechaVuelo la fecha del vuelo
     * @param precio el precio del vuelo
     * @param plazasDisponibles el número de plazas disponibles del vuelo
     */
	public Vuelo(int idVuelo, String compania, Date fechaVuelo, double precio, int plazasDisponibles) {
		super();
		this.idVuelo = idVuelo;
		this.compania = compania;
		this.fechaVuelo = fechaVuelo;
		this.precio = precio;
		this.plazasDisponibles = plazasDisponibles;
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public Date getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(Date fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getPlazasDisponibles() {
		return plazasDisponibles;
	}

	public void setPlazasDisponibles(int plazasDisponibles) {
		this.plazasDisponibles = plazasDisponibles;
	}


	@Override
	public int hashCode() {
		return Objects.hash(compania);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		return Objects.equals(compania, other.compania);
	}
	
	
	
	
}
