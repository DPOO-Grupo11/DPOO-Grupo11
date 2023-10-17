package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

import clases.Admin;
import clases.Empleado;
import clases.Sede;
import clases.SistemaAlquiler;

public class MenuAdmin {

	private SistemaAlquiler sistemaAlquiler;
	private Admin adminActual;
	private String sedeAdmin;

	public MenuAdmin(SistemaAlquiler SA, Admin AA) {
		this.sistemaAlquiler = SA;
		this.adminActual = AA;
		this.sedeAdmin = adminActual.getSede();

	}

	public void mostrarMenu() throws FileNotFoundException, IOException, ClassNotFoundException {

		if (sedeAdmin == null) {
			// Cuando la sede es null se tiene un administrador general
			mostrarMenuGeneral();

		} else {
			// cuando sede != null, es un administrador local
			mostrarMenuLocal();
		}
		System.out.println("5. Consultar ubicacion vehiculo");
		System.out.println("6. Consultar historial vehiculo");
		System.out.println("7. Cerrar sesión");

		int opcionSeleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
		ejecutarOpcion(opcionSeleccionada);
	}

	private void mostrarMenuGeneral() {
		System.out.println("Menú administrador general \n");

		System.out.println("1. Agregar Carro");
		System.out.println("2. Eliminar Carro");
		System.out.println("3. Crear Sede");
		System.out.println("4. Modificar Sede");

	}

	private void mostrarMenuLocal() {
		System.out.println("Menú administrador local \n");

		System.out.println("1. Registrar empleado");
		System.out.println("2. Eliminar empleado");
	}

	public void ejecutarOpcion(int opcionSeleccionada)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean continuar = true;
		while (continuar) {
			try {
				if (opcionSeleccionada == 1 && sedeAdmin == null) {
					System.out.println("Para agregar un vehiculo nuevo ingrese la siguiente informacion: ");

					// ejecutarAgregarVehiculo();
					opcionSeleccionada = 0;
				} else if (opcionSeleccionada == 2 && sedeAdmin == null) {
					System.out.println("Para dar de baja un vehiculo nuevo ingrese la siguiente informacion: ");
					// ToDo call eliminar carro
					opcionSeleccionada = 0;
				} else if (opcionSeleccionada == 3 && sedeAdmin == null) {
					System.out.println("Para crear una sede nueva ingrese la siguiente informacion: ");
					String nomSede = input("Nombre de la sede");
					String ubiSede = input("Ubicación de la sede");
					int hrsASede = Integer.parseInt(input("Horario de apertura de la sede"));
					int hrsCSede = Integer.parseInt(input("Horario de cierre de la sede"));

					sistemaAlquiler.crearSede(nomSede, ubiSede, hrsASede, hrsCSede);
					opcionSeleccionada = 0;
				} else if (opcionSeleccionada == 4 && sedeAdmin == null) {
					System.out.println("Para modificar una sede ingrese la siguiente informacion: ");

					// Mostrar Sedes existentes y pedir una
					ArrayList<Sede> listaSedes = sistemaAlquiler.getSedes();
					for (int i = 0; i < listaSedes.size(); i++) {
						String elemento = listaSedes.get(i).getNombre();
						System.out.println(i + " " + elemento + "\n");
					}
					int sedeInt = Integer.parseInt(input("Ingrese el numero de la sede a la cual se modificará"));
					Sede SedeOb = listaSedes.get(sedeInt); // Se omitió el manejo del error en el cual el usuario elige
															// un numero fuera del rango permitido.
					String nomSede = SedeOb.getNombre();

					//
					System.out.println("Parametro que desea modificar: ");
					System.out.println("1) Nombre");
					System.out.println("2) Horario de Atención");
					int parametro = Integer.parseInt(input("Opción"));
					try {
						if (parametro == 1) {
							String nuevoNom = input("Ingrese el nuevo nombre");
							sistemaAlquiler.modificarNombreSede(nuevoNom, nomSede);
						} else if (parametro == 2) {
							int hrsASede = Integer.parseInt(input("Nuevo horario de apertura de la sede"));
							int hrsCSede = Integer.parseInt(input("Nuevo horario de cierre de la sede"));
							sistemaAlquiler.modificarHorarioSede(nomSede, hrsASede, hrsCSede);
						} else {
							System.out.println("Por favor seleccione una opción valida.");
						}
					} catch (NumberFormatException e) {
						System.out.println("Debe seleccionar uno de los numeros de las opciones.");
					}

					opcionSeleccionada = 0;
				} else if (opcionSeleccionada == 1 && sedeAdmin != null) {
					// registrar empleado
					System.out.println("Para agregar un empleado ingrese la siguiente informacion: ");
					String usuario = input("Nombre usuario");
					String constraseña = input("Clave usuario");
					String rol = input("Rol del usuario");
					sistemaAlquiler.registroEmpleado(usuario, constraseña, rol);
					// agregar usuario a inventario
					opcionSeleccionada = 0;
				} else if (opcionSeleccionada == 2 && sedeAdmin != null) {
					// eliminar empleado
					System.out.println("Para remover un empleado ingrese la siguiente informacion: ");
					String usuario = input("Nombre usuario");
					sistemaAlquiler.eliminarEmpleado(usuario);
					opcionSeleccionada = 0;
				} else if (opcionSeleccionada == 5) {
					// call consultar ubicacion vehiculo (pedir parametros y llamar funcion)
					System.out.println("Para consultar la ubicacion de un vehiculo ingrese la siguiente informacion: ");
					String placa = input("Placa");
					sistemaAlquiler.consultarUbicacionVehiculo(placa);
					opcionSeleccionada = 0;
				} else if (opcionSeleccionada == 6) {
					// call consultar historial vehiculo (pedir parametros y llamar funcion)
					System.out.println("Para consultar el historial de un vehiculo ingrese la siguiente informacion: ");
					String placa = input("Placa");
					sistemaAlquiler.consultarHistorialVehiculo(placa);
					opcionSeleccionada = 0;
				}

				else if (opcionSeleccionada == 7) {
					// cerrar sesion
					System.out.println("Cerrando sesión ...");
					this.adminActual = null;
					this.sedeAdmin = null;
					continuar = false;
					sistemaAlquiler.guardarDatos();

				} else if (opcionSeleccionada == 0) {

					if (sedeAdmin == null) {
						// Cuando la sede es null se tiene un administrador general
						mostrarMenuGeneral();

					} else {
						// cuando sede != null, es un administrador local
						mostrarMenuLocal();
					}
					System.out.println("5. Consultar ubicacion vehiculo");
					System.out.println("6. Consultar historial vehiculo");
					System.out.println("7. Cerrar sesión");
				} else {
					System.out.println("Por favor seleccione una opción valida.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Debe seleccionar uno de los numeros de las opciones.");
			}
		}
	}
	// Input -------------------------------------------------------------------

	public String input(String mensaje) {
		try {
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		} catch (IOException e) {
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

}
