package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


import clases.*;

public class MenuPrincipal {
	
	public void mostrarMenu() throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		
		System.out.println("\n Bienvenido al sistema de alquiler de vehiculos \n");
		
		System.out.println("Menú principal \n");
		
		System.out.println("1. iniciar sesión");
		System.out.println("2. Registrar usuario nuevo");
		System.out.println("3. Salir de la aplicacion");
		
		int opcionSeleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
		ejecutarOpcion(opcionSeleccionada);
		
	}
	
	public void ejecutarOpcion(int opcionSeleccionada) throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		SistemaAlquiler sistemaAlquiler = new SistemaAlquiler();
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				if (opcionSeleccionada == 1  && sistemaAlquiler != null) 
				{
					
					System.out.println("Para iniciar sesion debe ingresar sus credenciales");
					String usuario = input("Usuario");
					String clave = input("Clave");
					Usuario usuarioActual = sistemaAlquiler.getUsuario(usuario, clave); 
					String rolUsuario = usuarioActual.getTipo();
					 if (rolUsuario.equals("Administrador"))
					{
						System.out.println("Inicio de sesión como Admin exitoso");
					//	MenuAdmin menuAdmin = new MenuAdmin();
					//	menuAdmin.mostrarMenu();
					}
					else if (rolUsuario.equals("Empleado"))
					{
						System.out.println("Inicio de sesión como Empleado exitoso");
					//	MenuEmpleado menuEmpleado = new MenuEmpleado();
					//  MenuEmpleado.mostrarMenu();
					}
					else if (rolUsuario.equals("Cliente"))
					{
						System.out.println("Inicio de sesión como Empleado exitoso");
					//  MenuCliente menuAdmin = new MenuCliente();
					//  menuCliente.mostrarMenu();
					}
					else
					{
						System.out.println("el usuario solicitado no fue encontrado");
					}
					opcionSeleccionada=0;
				}
				else if (opcionSeleccionada == 2 && sistemaAlquiler != null) 
				{
					MenuRegistro menuRegistro = new MenuRegistro(sistemaAlquiler);
					menuRegistro.mostrarMenu();
					
			        opcionSeleccionada=0;
			    }
				
				else if (opcionSeleccionada == 3 && sistemaAlquiler != null)
				{
					System.out.println("Saliendo de la aplicacion ...");
					continuar = false;
					
				}
				else if (sistemaAlquiler == null)	
				{
					System.out.println("Ha ocurrido un error al cargar la aplicacion. ");
				}
				else if (opcionSeleccionada == 0)	
				{
					
					System.out.println("Menú principal \n");
					
					System.out.println("1. iniciar sesión");
					System.out.println("2. Registrar usuario nuevo");
					System.out.println("3. Salir de la aplicacion");
					opcionSeleccionada = Integer.parseInt(input("\nPor favor seleccione una opcion"));
				}
				else
				{
					System.out.println("Por favor seleccione una opción valida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los numeros de las opciones.");
			}
		}
	}
	
	
	
	
	
	
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		MenuPrincipal menuprincipal = new MenuPrincipal();
		menuprincipal.mostrarMenu();

	}

}
