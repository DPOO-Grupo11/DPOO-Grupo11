package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import clases.*;

public class MenuAdmin {
	
	private SistemaAlquiler sistemaAlquiler;
	private Admin adminActual;
	private String sedeAdmin;
	
	public MenuAdmin(SistemaAlquiler SA, Admin AA) 
	{
		this.sistemaAlquiler = SA;
		this.adminActual = AA;
		this.sedeAdmin = adminActual.getSede();
		
	}
	
	public void mostrarMenu() throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		
		if (sedeAdmin.equals(null))
		{
			//Cuando la sede es null se tiene un administrador general
			mostrarMenuGeneral();
			
		}
		else
		{
			//cuando sede != null, es un administrador local 
			mostrarMenuLocal();
		}
		System.out.println("5. Consultar ubicacion vehiculo");
		System.out.println("6. Consultar historial vehiculo");
		System.out.println("7. Cerrar sesión");
		
		
		int opcionSeleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
		ejecutarOpcion(opcionSeleccionada);
	}
	private void mostrarMenuGeneral()
	{
		System.out.println("Menú administrador general \n");
		
		System.out.println("1. Agregar Carro");
		System.out.println("2. Eliminar Carro");
		System.out.println("3. Crear Sede");
		System.out.println("4. Modificar Sede");
		
	}
	
	private void mostrarMenuLocal() 
	{
		System.out.println("Menú administrador local \n");
		
		System.out.println("1. Registrar empleado");
		System.out.println("2. Eliminar empleado");
	}

	
	public void ejecutarOpcion(int opcionSeleccionada) throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				if (opcionSeleccionada == 1  && sedeAdmin.equals(null)) 
				{
					//Todo Call registrar carro
					opcionSeleccionada=0;
				}
				else if (opcionSeleccionada == 2 && sedeAdmin.equals(null)) 
				{
					//ToDo call eliminar carro
			        opcionSeleccionada=0;
			    }
				else if (opcionSeleccionada == 3 && sedeAdmin.equals(null)) 
				{
					//ToDo crear sede 
			        opcionSeleccionada=0;
			    }
				else if (opcionSeleccionada == 4 && sedeAdmin.equals(null)) 
				{
					//ToDo modificar sede
			        opcionSeleccionada=0;
			    }
				else if (opcionSeleccionada == 1 && !sedeAdmin.equals(null))
				{
					//ToDo call registrar empleado
			        opcionSeleccionada=0;
			    }
				else if (opcionSeleccionada == 2 && !sedeAdmin.equals(null))
				{
					//ToDo call eliminar empleado
			        opcionSeleccionada=0;
			    }
				else if (opcionSeleccionada == 5) 
				{
					//ToDo call consultar ubicacion vehiculo
			        opcionSeleccionada=0;
			    }
				else if (opcionSeleccionada == 6) 
				{
					//ToDo call consultar historial vehiculo
			        opcionSeleccionada=0;
			    }
				
				else if (opcionSeleccionada == 7)
				{
					System.out.println("Cerrando sesión ...");
					this.adminActual = null;
					this.sedeAdmin = null;
					continuar = false;
					
				}
				else if (opcionSeleccionada == 0)	
				{
					
					if (sedeAdmin.equals(null))
					{
						//Cuando la sede es null se tiene un administrador general
						mostrarMenuGeneral();
						
					}
					else
					{
						//cuando sede != null, es un administrador local 
						mostrarMenuLocal();
					}
					System.out.println("5. Consultar ubicacion vehiculo");
					System.out.println("6. Consultar historial vehiculo");
					System.out.println("7. Cerrar sesión");
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
