package clases;

import java.io.Serializable;

public class Empleado extends Usuario implements Serializable {
	private static final long serialVersionUID = 4103466959519619035L;
	/**
	 * 
	 */
	String rol;
	
	public Empleado(String usuario, String contraseña, String rol) {
		super.usuario = usuario;
		super.contraseña  = contraseña;
		this.rol = rol;
	}
	
}
