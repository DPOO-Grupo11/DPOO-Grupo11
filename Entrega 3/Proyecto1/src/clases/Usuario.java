package clases;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
	private static final long serialVersionUID = 2531807322318657943L;
	/**
	 * 
	 */
	private String usuario;
	private String contraseña;
	private String tipo;

	/*
	 * getters
	 */
	public String getUsuario() {
		return usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public String getTipo() {
		return tipo;
	}
	
	/*
	 * setters
	 */

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
