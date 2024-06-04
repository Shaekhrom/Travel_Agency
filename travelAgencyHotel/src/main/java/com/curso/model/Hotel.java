package com.curso.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; 
/**
 * Clase que representa un hotel.
 * Utilizada para mapear la entidad Hotel en la base de datos.
 * 
 * @author Alejandro Barbacil Castro
 */
@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_hotel")
	private int idHotel;
	private String nombre;
	private int categoria;
	private double precio;
	private String disponible;
	/**
     * Constructor sin argumentos de la clase Hotel.
     */
	public Hotel() {
		super();
	}
	/**
     * Constructor con argumentos de la clase Hotel.
     * 
     * @param idHotel el ID del hotel
     * @param nombre el nombre del hotel
     * @param categoria la categoría del hotel
     * @param precio el precio del hotel
     * @param disponible la disponibilidad del hotel
     */
	public Hotel(int idHotel, String nombre, int categoria, double precio, String disponible) {
		super();
		this.idHotel = idHotel;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.disponible = disponible;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idHotel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return idHotel == other.idHotel;
	}
	
	
	
}
