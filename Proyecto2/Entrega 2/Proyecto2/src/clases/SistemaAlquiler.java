package clases;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

public class SistemaAlquiler {
	private ContenedorDeDatos datos;

	// toca pedir archivo de persistencia cada vez que se inicie programa
	private static final String dirDatos = System.getProperty("user.dir");;

	public SistemaAlquiler() throws FileNotFoundException, IOException, ClassNotFoundException {
		cargarDatos();
	}

	/*
	 * funciones
	 */
	/**
	 * si se lanza error, significa que no se pudieron cargar los datos los datos se
	 * cargan automaticamente, si no existe un archivo de
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void cargarDatos() throws IOException, ClassNotFoundException {
		// cargar bytes de archivo
		File archivoDatos = new File("Datos/persistencia");
		if (archivoDatos.exists()) {
			byte[] bytes = Files.readAllBytes(archivoDatos.toPath());
			// convertir bytes a objeto
			ByteArrayInputStream bs = new ByteArrayInputStream(bytes); // bytes es el byte[]
			ObjectInputStream is = new ObjectInputStream(bs);
			datos = (ContenedorDeDatos) is.readObject();
			is.close();
		} else {
			datos = new ContenedorDeDatos();
		}
	}

	/**
	 * si lanza un error, significa que no se pudieron guardar datos
	 * 
	 * @throws IOException
	 */
	public void guardarDatos() throws IOException {
		// convertir objeto de datos a bytes
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(bs);
		os.writeObject(datos);
		os.close();
		byte[] bytes = bs.toByteArray();
		// guardar bytes en archivo
		File archivoDatos = new File("Data/persistencia");
		if (!archivoDatos.exists()) {
			if (!archivoDatos.createNewFile())
				throw new FileNotFoundException("no se pudo crear el archivo");
		}
		try (FileOutputStream outputStream = new FileOutputStream(archivoDatos)) {
			outputStream.write(bytes);
		}
	}

	public Usuario getUsuario(String usuario, String clave) {
		Usuario usuarioInteres = datos.getUsuario(usuario, clave);
		return usuarioInteres;
	}

	public ArrayList<Sede> getSedes() {
		Map<String, Sede> mapaSedes = datos.getSedes();
		ArrayList<Sede> listaSedes = new ArrayList<Sede>(mapaSedes.values());
		return listaSedes;
	}

	public Sede getSede(String nombre) {
		return datos.getSede(nombre);
	}

	public void registroAdmin(String usuario, String clave, String sede) {
		Map<String, Admin> mapaAdmins = datos.getAdmins();
		if (!mapaAdmins.containsKey(usuario)) {
			// El admin no existe, agregarlo
			Admin nuevoAdmin = new Admin(usuario, clave, sede);
			mapaAdmins.put(usuario, nuevoAdmin);
			System.out.println("Admin registrado");
		} else {
			// El admin ya existe
			System.out.println("El nombre de usuario ya esta en uso. Intenta con otro");
		}

	}

	public void registroEmpleado(String usuario, String clave, String rol, Sede sede) {
		Empleado empleado = new Empleado(usuario, clave, rol, sede);
		if (datos.getEmpleados().containsKey(usuario)) {
			System.out.println("ya existe un usuario con este nombre, intente con otro");
			return;
		}
		datos.getEmpleados().put(usuario, empleado);
		System.out.println("Empleado registrado");
	}

	public void eliminarEmpleado(String usuario) {
		if (!datos.getEmpleados().containsKey(usuario)) {
			System.out.println("el usuario seleccionado no existe");
			return;
		}
		datos.getEmpleados().remove(usuario);
		System.out.println("Empleado eliminado");
	}

	public void registroCliente(String usuario, String clave, String nombres, String numeroTelefono, String direccion,
			String fechaNacimiento, String nacionalidad, String imagenDocumentoIdentidad, String numeroLicencia,
			String paisExpedicion, String fechaVencimientoLicencia, String imagen, String numeroTarjeta,
			String fechaVencimientoTarjeta, String cvv) {
		Map<String, Cliente> mapaClientes = datos.getClientes();
		if (!mapaClientes.containsKey(usuario)) {
			// El cliente no existe, agregarlo
			LicenciaDeConduccion licencia = new LicenciaDeConduccion(numeroLicencia, paisExpedicion,
					fechaVencimientoLicencia, imagen);
			TarjetaDeCredito tarjetaDeCredito = new TarjetaDeCredito(numeroTarjeta, fechaVencimientoTarjeta, cvv);
			Cliente nuevoCliente = new Cliente(usuario, clave, nombres, numeroTelefono, direccion, fechaNacimiento,
					nacionalidad, imagenDocumentoIdentidad, licencia, tarjetaDeCredito);
			mapaClientes.put(usuario, nuevoCliente);
			System.out.println("Cliente registrado");
		} else {
			// El cliente ya existe
			System.out.println("El nombre de usuario ya esta en uso. Intenta con otro");
		}

	}

	public void crearSede(String nomSede, String ubiSede, int hrsASede, int hrsCSede) {
		try {
			Range<Integer> rangeHrs = new Range<Integer>(hrsASede, hrsCSede);

			HorarioDeAtencion hrs = new HorarioDeAtencion(rangeHrs);

			ArrayList<Empleado> empleados = new ArrayList<Empleado>();

			Map<String, Sede> mapaSedes = datos.getSedes();
			if (!mapaSedes.containsKey(nomSede)) {
				// La sede no existe, agregarla
				Sede nuevaSede = new Sede(nomSede, ubiSede, hrs, empleados);
				mapaSedes.put(nomSede, nuevaSede);
				System.out.println("Nueva sede creada");
			} else {
				// La sede ya existe
				System.out.println("El nombre de usuario ya esta en uso. Intenta con otro");
			}

		} catch (IllegalArgumentException e) {
			System.out.println("Rango no válido: " + e.getMessage());
		}

	}

	public void modificarNombreSede(String nuevoNomSede, String actNomSede) {
		Map<String, Sede> mapaSedes = datos.getSedes();
		if (mapaSedes.containsKey(actNomSede)) {
			Sede sedeActual = mapaSedes.get(actNomSede);

			mapaSedes.remove(actNomSede);
			sedeActual.setNombre(nuevoNomSede);
			mapaSedes.put(actNomSede, sedeActual);
			System.out.println("Nombre sede modificado");
		} else {
			System.out.println("La sede ingresada no fue encontrada ");
		}

	}

	public void modificarHorarioSede(String nomSede, int hrsASede, int hrsCSede) {
		Map<String, Sede> mapaSedes = datos.getSedes();
		if (mapaSedes.containsKey(nomSede)) {
			Sede sedeActual = mapaSedes.get(nomSede);
			Range<Integer> rangeHrs = new Range<Integer>(hrsASede, hrsCSede);
			HorarioDeAtencion hrs = new HorarioDeAtencion(rangeHrs);
			sedeActual.setHorariosDeAtencion(hrs);
			System.out.println("Horarios de atencion establecidos");
		} else {
			System.out.println("La sede ingresada no fue encontrada ");
		}
	}

	public void consultarUbicacionVehiculo(String placa) {
		if (!datos.getVehiculos().containsKey(placa)) {
			System.out.println("El vehiculo seleccionado no existe");
			return;
		}
		Vehiculo v = datos.getVehiculos().get(placa);
		if (v.getUbicacion() == null) {
			System.out.println("El vehiculo esta actualmente alquilado");
			return;
		}
		System.out.println("Ubicacion vehiculo: " + v.getUbicacion());
	}

	public void consultarHistorialVehiculo(String placa) {
		if (!datos.getVehiculos().containsKey(placa)) {
			System.out.println("El vehiculo seleccionado no existe");
			return;
		}
		Vehiculo v = datos.getVehiculos().get(placa);
		ArrayList<Reserva> historial = v.getHistorial();
		if (historial.isEmpty()) {
			System.out.println("El vehiculo seleccionado no tiene historial");
			return;
		}
		System.out.println("Historial vehiculo:");
		for (Reserva r : historial) {
			System.out.println(String.format("ID reserva: %d, fecha inicio: %s, fecha final: %s", r.getId(),
					r.getRangoEntrega().getLow().toLocalDate().toString(),
					r.getFechaRecogida().toLocalDate().toString()));
		}

	}

	public void crearReserva(String categoriaSolicitada, LocalDateTime fechaRecogida, String ubicacionRecogida,
			String ubicacionEntrega, Range<LocalDateTime> rangoEntrega, Cliente cliente,
			ArrayList<LicenciaDeConduccion> conductoresExtra) {
		Tarifa tarifa = Inventario.tarifas.get(categoriaSolicitada);
		Reserva r = new Reserva(datos.nuevoIdReservas(), categoriaSolicitada, fechaRecogida, ubicacionRecogida,
				ubicacionEntrega, rangoEntrega, cliente, null, conductoresExtra, tarifa);
		datos.getReservas().put(r.getId(), r);
		System.out.println("Reserva creada");
	}

	public void modificarReserva(String idReserva, LocalDateTime fechaRecogida, Range<LocalDateTime> rangoEntrega) {
		if (!datos.getReservas().containsKey(idReserva)) {
			System.out.println("La reserva seleccionada no existe");
			return;
		}
		Reserva r = datos.getReservas().get(idReserva);
		if (r.getVehiculo() != null) {
			System.out.println("Esta reserva ya es un alquiler en curso, no se puede modificar");
			return;
		}
		r.setFechaRecogida(fechaRecogida);
		r.setRangoEntrega(rangoEntrega);
		System.out.println("Los cambios fueron realizados");
	}

	public void crearAlquiler(String categoriaSolicitada, LocalDateTime fechaRecogida, String ubicacionRecogida,
			String ubicacionEntrega, Range<LocalDateTime> rangoEntrega, Cliente cliente,
			ArrayList<LicenciaDeConduccion> conductoresExtra) {

		Tarifa tarifa = Inventario.tarifas.get(categoriaSolicitada);
		Reserva r = new Reserva(datos.nuevoIdReservas(), categoriaSolicitada, fechaRecogida, ubicacionRecogida,
				ubicacionEntrega, rangoEntrega, cliente, null, conductoresExtra, tarifa);
		datos.getReservas().put(r.getId(), r);
		formalizarAlquiler(r.getId());
		System.out.println("Alquiler creado");
	}

	public void formalizarAlquiler(String idReserva) {
		if (!datos.getReservas().containsKey(idReserva)) {
			System.out.println("La reserva seleccionada no existe");
			return;
		}
		Reserva r = datos.getReservas().get(idReserva);
		// encontrar vehiculo disponible
		String categoria = r.getCategoriaSolicitada();
		Vehiculo vehiculoEncontrado = null;
		while (vehiculoEncontrado == null) {
			for (Vehiculo v : datos.getVehiculos().values()) {
				if (v.getCategoria() == categoria
						&& (v.getFechaDisponible().compareTo(r.getRangoEntrega().getLow()) <= 0)) {
					// actualizar vehiculo
					v.setSede(null);
					v.setEstado("alquilado");
					v.setFechaDisponible(r.getFechaRecogida());
					r.setVehiculo(v);
					System.out.println("Alquiler formalizado, se asigno un vehiculo");
					return;
				}
			}
			int i = Inventario.prioridadCategoria.indexOf(categoria);
			i += 1;
			if (i >= Inventario.prioridadCategoria.size()) {
				System.out.println("No existen vehiculos disponibles en este momento");
				return;
			}
			categoria = Inventario.prioridadCategoria.get(i);
		}
	}

	public void AgregarVehiculo(String placa, String marca, String color, String transmision, String categoria,
			String sede, String estado) {
		Map<String, Vehiculo> mapaVehiculos = datos.getVehiculos();
		if (!mapaVehiculos.containsKey(placa)) {
			// La sede no existe, agregarla
			LocalDateTime fechaDisponible = null;
			String comentarios = "vehiculo nuevo";
			ArrayList<Reserva> historial = null;
			Vehiculo nuevoVehiculo = new Vehiculo(placa, marca, color, transmision, categoria, sede, fechaDisponible,
					comentarios, estado, historial);
			mapaVehiculos.put(placa, nuevoVehiculo);
			System.out.println("Nuevo vehiculo creada");
		} else {
			// La sede ya existe
			System.out.println("Ya hay un vehiculo registrado con esa placa. Intenta con otro");
		}

	}
}
