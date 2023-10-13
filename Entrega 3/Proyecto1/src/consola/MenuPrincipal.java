package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import clases.*;

public class MenuPrincipal {
	
	public void mostrarMenu() throws FileNotFoundException, IOException 
	{
		
		System.out.println("\n Bienvenido al sistema de alquiler de vehiculos \n");
		
		System.out.println("Menú principal \n");
		
		System.out.println("1. iniciar sesión");
		System.out.println("2. Registrar cliente nuevo");
		System.out.println("3. Salir de la aplicacion");
		
		int opcionSeleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
		ejecutarOpcion(opcionSeleccionada);
		
	}
	
	public void ejecutarOpcion(int opcionSeleccionada) throws FileNotFoundException, IOException 
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
					String usuario = input("Usuario: ");
					String contraseña = input("Contraseña: ");
					//Usuario usuarioActual = SistemaAlquiler.getUsuario(usuario, contraseña); 
					opcionSeleccionada=0;
				}
				else if (opcionSeleccionada == 2 && sistemaAlquiler != null) 
				{
					//ejecutarOpcion2();
					//ToDo: Crear menu registro 
					
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
					System.out.println("2. Registrar cliente nuevo");
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

	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		MenuPrincipal menuprincipal = new MenuPrincipal();
		menuprincipal.mostrarMenu();

	}

}
