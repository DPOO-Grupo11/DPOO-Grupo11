package clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * esta clase facilita encapsula todos los datos que se van a almacenar
 */
public class ContenedorDeDatos implements Serializable {
	private static final long serialVersionUID = -6520764575541372960L;
	/**
	 * 
	 */
	private Usuario usuario;
	private Inventario inventario;
	private Map<String, Cliente> clientes;
	private Map<String, Admin> admins;
	private ArrayList<Seguro> seguros;
	private Map<String, Sede> sedes;
	// llave es placa
	private Map<String, Vehiculo> vehiculos;
	// llave es id reserva
	private Map<String, Reserva> reservas;
	// llave es usuario
	private Map<String, Empleado> empleados;
	private Admin adminGeneral;
	/*
	 * 
	 */
	// se utiliza como id para las reservas
	private int contadorReservas = 0;

	public ContenedorDeDatos() {
		this.usuario = null;
		this.adminGeneral = new Admin("AdministradorGen", "SenecaDPOO");
		this.inventario = new Inventario();
		this.clientes = new HashMap<String, Cliente>();
		this.admins = new HashMap<String, Admin>();
		this.seguros = new ArrayList<Seguro>();
		this.sedes = new HashMap<String, Sede>();
		this.vehiculos = new HashMap<String, Vehiculo>();
		this.reservas = new HashMap<String, Reserva>();
		this.empleados = new HashMap<String, Empleado>();
		this.admins.put(adminGeneral.getNombreUsuario(), adminGeneral);
	}

	public String nuevoIdReservas() {
		String nuevoId = String.valueOf(this.contadorReservas);
		this.contadorReservas += 1;
		return nuevoId;
	}

	/*
	 * getters
	 */

	public Usuario getUsuarioActual() {
		return usuario;
	}

	public Admin getAdminGen() {
		return adminGeneral;
	}

	public Usuario getUsuario(String usuario, String clave) {
		Usuario usuarioInteres = getUsuarios().get(usuario);
		if (clave.equals(usuarioInteres.getContraseña())) {
			return usuarioInteres;
		} else {
			return null;
		}
	}

	public Map<String, Usuario> getUsuarios() {
		Map<String, Usuario> usuarios = new HashMap<String, Usuario>();
		usuarios.putAll(admins);
		usuarios.putAll(empleados);
		usuarios.putAll(clientes);
		return usuarios;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public Map<String, Cliente> getClientes() {
		return clientes;
	}

	public Map<String, Admin> getAdmins() {
		return admins;
	}

	public ArrayList<Seguro> getSeguros() {
		return seguros;
	}

	public Map<String, Sede> getSedes() {
		return sedes;
	}

	public Sede getSede(String nombre) {
		return sedes.get(nombre);
	}

	public Map<String, Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public Map<String, Reserva> getReservas() {
		return reservas;
	}

	public Map<String, Empleado> getEmpleados() {
		return empleados;
	}

	/*
	 * setters
	 */

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public void setClientes(Map<String, Cliente> clientes) {
		this.clientes = clientes;
	}

	public void setAdmins(Map<String, Admin> admins) {
		this.admins = admins;
	}

	public void setSeguros(ArrayList<Seguro> seguros) {
		this.seguros = seguros;
	}

	public void setSedes(Map<String, Sede> sedes) {
		this.sedes = sedes;
	}

	public void setVehiculos(Map<String, Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public void setReservas(Map<String, Reserva> reservas) {
		this.reservas = reservas;
	}

	public void setEmpleados(Map<String, Empleado> empleados) {
		this.empleados = empleados;
	}

}
