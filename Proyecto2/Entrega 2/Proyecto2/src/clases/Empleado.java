package clases;

import java.io.Serializable;

public class Empleado extends Usuario implements Serializable {
	private static final long serialVersionUID = 4103466959519619035L;
	/**
	 * 
	 */
	private String rol;
	private Sede sede;
	
	public Empleado(String usuario, String contraseña, String rol, Sede sede) {
		super(usuario, contraseña, "Empleado");
		this.rol = rol;
		this.sede = sede;	}
	
}
