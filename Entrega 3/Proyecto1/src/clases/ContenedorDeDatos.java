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
	private ArrayList<Sede> sedes;
	private Map<String, Vehiculo> vehiculos;
	private Map<String, Reserva> reservas;
	private Map<String, Empleado> empleados;
	private Map<String, Usuario> usuarios;
	private Admin adminGeneral;

	public ContenedorDeDatos() {
		this. usuario = null;
		this. adminGeneral = new Admin("AdministradorGen", "SenecaDPOO");
		this.  inventario = new Inventario();
		this.  clientes = new HashMap<String, Cliente>();
		this.  admins = new HashMap<String, Admin>();
		this. seguros = new ArrayList<Seguro>();
		this. sedes = new ArrayList<Sede>();
		this.  vehiculos = new HashMap<String, Vehiculo>();
		this.  reservas = new HashMap<String, Reserva>();
		this.  empleados = new HashMap<String, Empleado>();
		this. usuarios = new HashMap<String, Usuario>();
		setUsuarios(empleados, admins, clientes);
		this.usuarios.put(adminGeneral.getNombreUsuario(), adminGeneral);
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
	public Usuario getUsuario(String usuario, String clave)
	{	
		Usuario usuarioInteres = this.usuarios.get(usuario);
		if (clave.equals(usuarioInteres.getContraseña())) 
		{
			return usuarioInteres;
		}
		else
		{
			return null;
		}
	}
	
	public Map<String, Usuario> getUsuarios() {
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

	public ArrayList<Sede> getSedes() {
		return sedes;
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

	public void setSedes(ArrayList<Sede> sedes) {
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
	
	public void setUsuarios(Map<String, Empleado> empleados, Map<String, Admin> admins, Map<String, Cliente> clientes) {
		this.usuarios.putAll(empleados);
		this.usuarios.putAll(admins);
		this.usuarios.putAll(clientes);
	}
	
	//actualiza el mapa de usuarios. 
	public void actUsuarios() {
		setUsuarios(this.empleados, this.admins, this.clientes);
	}
	
	
}
