package clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CSVReader {
	
	private SistemaAlquiler SA;
	private ContenedorDeDatos CD;
	
	public CSVReader(SistemaAlquiler SA,ContenedorDeDatos CD) throws FileNotFoundException, IOException {
		this.SA=SA;
		this.CD=CD;
		
		cargarVehiculos();
		cargarClientes();
		cargarSedes();
		cargarAdmins();
	}

	private void cargarAdmins() throws FileNotFoundException, IOException {
		
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/catalinavillacris/git/DPOO-Grupo3/Proyecto2/Entrega 2/Proyecto2/Persistencia/Administradores.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] info= line.split(";");
		        
		        SA.registroAdmin(info[0],info[1],info[2]);
		        
		        
		    }
		}
		
	}

	private void cargarSedes() throws FileNotFoundException, IOException {
		
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/catalinavillacris/git/DPOO-Grupo3/Proyecto2/Entrega 2/Proyecto2/Persistencia/Sedes.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] info= line.split(";");
		        
		        String nombre= info[0];
		        String ubicacion= info[1];
		        String[] horario= info[2].split(",");
		        
		        SA.crearSede(nombre, ubicacion, Integer.parseInt(horario[0]), Integer.parseInt(horario[1]));
		        
		        String[] empleados= info[3].split("|");
		        
		        for(String empleado:empleados) {
		        	String[] data= empleado.split(",");
		        	SA.registroEmpleado(data[1], data[2],data[3],SA.getSede(nombre));
		        }
		    }
		}
		
	}

	private void cargarClientes() throws FileNotFoundException, IOException {
		
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/catalinavillacris/git/DPOO-Grupo3/Proyecto2/Entrega 2/Proyecto2/Persistencia/clientes.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] info= line.split(";");
		        
		        String usuario= info[0];
		        String contraseña= info[1];
		        String nombre= info[2];
		        String numero= info[3];
		        String direccion= info[4];
		        String fechaNacimiento= info[5];
		        String nacionalidad=info[6];
		        String documento= info[7];
		        LicenciaDeConduccion licencia= new LicenciaDeConduccion(info[8],info[9],info[10],info[11]);
		        TarjetaDeCredito tarjeta= new TarjetaDeCredito(info[13],info[14],"134");
		        
		        Cliente nuevo= new Cliente(usuario,contraseña,nombre,numero,direccion,fechaNacimiento,nacionalidad,documento,licencia,tarjeta);
		        
		        CD.nuevoCliente(nuevo);
		    }
		}
	}

	private void cargarVehiculos() throws FileNotFoundException, IOException {
		
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/catalinavillacris/git/DPOO-Grupo3/Proyecto2/Entrega 2/Proyecto2/Persistencia/Vehiculo.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] info= line.split(";");
		        
		        String placa= info[0];
		        String marca= info[1];
		        String color= info[2];
		        String transmision= info[3];
		        String clasificacion= info[4];
		        String sede= info[5];
		        LocalDateTime fechadisponible= LocalDateTime.parse(info[6]);
		        String comentarios=info[7];
		        String estado= info[8];
		        
		        SA.AgregarVehiculo(placa, marca, color, transmision, clasificacion, sede, estado);
		    }
		}
	}
	

}
