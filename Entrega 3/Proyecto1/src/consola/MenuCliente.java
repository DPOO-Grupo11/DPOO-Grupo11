package consola;

import clases.Admin;
import clases.SistemaAlquiler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import clases.*;


public class MenuCliente {
	
	private SistemaAlquiler sistemaAlquiler;
	private Cliente clienteActual;
	
	public MenuCliente(SistemaAlquiler SA, Cliente CA) 
	{
		this.sistemaAlquiler = SA;
		this.clienteActual = CA;
	}
	
	public void mostrarMenu() throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		System.out.println("Menú cliente \n");
		
		System.out.println("1. Crear reserva");
		System.out.println("2. Modificar reserva");
		System.out.println("3. Cerrar sesión");
		
		int opcionSeleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
		ejecutarOpcion(opcionSeleccionada);
	}
	
	public void ejecutarOpcion(int opcionSeleccionada) throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				if (opcionSeleccionada == 1) 
				{
					//Todo Call crear reserva
					opcionSeleccionada=0;
				}
				else if (opcionSeleccionada == 2) 
				{
					//ToDo call modificar reserva
			        opcionSeleccionada=0;
			    }
				else if (opcionSeleccionada == 3)
				{
					System.out.println("Cerrando sesión ...");
					this.clienteActual = null;
					continuar = false;
					
				}
				else if (opcionSeleccionada == 0)	
				{
					System.out.println("Menú cliente \n");
					
					System.out.println("1. Crear reserva");
					System.out.println("2. Modificar reserva");
					System.out.println("3. Cerrar sesión");
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
	
	//Input -------------------------------------------------------------------
	
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

}
