package clases;

import java.io.Serializable;

public abstract class Admin implements Serializable {
	private static final long serialVersionUID = 2699912451110887949L;
	/**
	 * 
	 */
	protected String usuario;
	protected String contraseña;
	protected String Sede;

	/*
	 * getters
	 */
	public String getNombreUsuario() {
		return this.usuario;
	}

	public String getContraseña() {
		return this.contraseña;
	}

	public String getSede() {
		return this.Sede;
	}

	/*
	 * setters
	 */

	public void setUsuario(String nombreUsuario) {
		this.usuario = nombreUsuario;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public void setSede(String sede) {
		this.Sede = sede;
	}
}
