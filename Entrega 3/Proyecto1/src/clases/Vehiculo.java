package clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

class Vehiculo implements Serializable {
	private String placa;
	private String marca;
	private String color;
	private String transmision;
	private String categoria;
	private ArrayList<LicenciaDeConduccion> conductores;
	private String sede;
	//
	private String ubicacion;
	private LocalDateTime fechaDisponible;
	private String comentarios;
	//
	private String estado;

	public Vehiculo(String placa, String marca, String color, String transmision, String categoria,
			ArrayList<LicenciaDeConduccion> conductores, String sede, String ubicacion, LocalDateTime fechaDisponible,
			String comentarios, String estado) {
		this.placa = placa;
		this.marca = marca;
		this.color = color;
		this.transmision = transmision;
		this.categoria = categoria;
		this.conductores = conductores;
		this.sede = sede;
		this.ubicacion = ubicacion;
		this.fechaDisponible = fechaDisponible;
		this.comentarios = comentarios;
		this.estado = estado;
	}

	/*
	 * getters
	 */

	public String getPlaca() {
		return placa;
	}

	public String getMarca() {
		return marca;
	}

	public String getColor() {
		return color;
	}

	public String getTransmision() {
		return transmision;
	}

	public String getCategoria() {
		return categoria;
	}

	public ArrayList<LicenciaDeConduccion> getConductores() {
		return conductores;
	}

	public String getSede() {
		return sede;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public LocalDateTime getFechaDisponible() {
		return fechaDisponible;
	}

	public String getComentarios() {
		return comentarios;
	}

	public String getEstado() {
		return estado;
	}

	/*
	 * setters
	 */

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setConductores(ArrayList<LicenciaDeConduccion> conductores) {
		this.conductores = conductores;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void setFechaDisponible(LocalDateTime fechaDisponible) {
		this.fechaDisponible = fechaDisponible;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}