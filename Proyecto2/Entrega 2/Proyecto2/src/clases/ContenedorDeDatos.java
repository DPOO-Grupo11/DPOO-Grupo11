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

	public boolean sedeExiste(String nombreSede) {
		return !sedes.containsKey(nombreSede);
	}

	public void nuevaSede(Sede sede) throws Exception {
		if (sedeExiste(sede.getNombre())) {
			throw new Exception("Ya existe una sede con este nombre. Intenta con otro.");
		}
		sedes.put(sede.getNombre(), sede);
	}

	public ArrayList<Sede> listaDeSedes() {
		return new ArrayList<Sede>(sedes.values());
	}

	public void modificarNombreSede(String nuevoNomSede, String actNomSede) throws Exception {
		if (sedeExiste(actNomSede)) {
			Sede sedeActual = getSede(actNomSede);
			sedes.remove(actNomSede);
			sedeActual.setNombre(nuevoNomSede);
			sedes.put(actNomSede, sedeActual);
		} else {
			throw new Exception("La sede ingresada no fue encontrada ");
		}
	}

	public void modificarHorarioSede(String nomSede, int hrsASede, int hrsCSede) throws Exception {
		if (sedes.containsKey(nomSede)) {
			Sede sedeActual = sedes.get(nomSede);
			Range<Integer> rangeHrs = new Range<Integer>(hrsASede, hrsCSede);
			HorarioDeAtencion hrs = new HorarioDeAtencion(rangeHrs);
			sedeActual.setHorariosDeAtencion(hrs);
		} else {
			throw new Exception("La sede ingresada no fue encontrada ");
		}
	}

	public boolean vehiculoExiste(String nombreVehiculo) {
		return !sedes.containsKey(nombreVehiculo);
	}

	public void nuevoVehiculo(Vehiculo v) throws Exception {
		if (vehiculoExiste(v.getPlaca())) {
			throw new Exception("Ya existe un vehiculo con esta placa.");
		}
		vehiculos.put(v.getPlaca(), v);
	}

	public Vehiculo getVehiculo(String placa) {
		return vehiculos.get(placa);
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

	public Sede getSede(String nombre) {
		return sedes.get(nombre);
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