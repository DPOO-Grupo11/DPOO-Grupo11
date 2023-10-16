package clases;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Map;

public class SistemaAlquiler {
	private ContenedorDeDatos datos;
	
	
	// toca pedir archivo de persistencia cada vez que se inicie programa
	private static final String dirDatos = System.getProperty("user.dir");;

	public SistemaAlquiler() throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("pass");
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
		File archivoDatos = new File(dirDatos, "datos");
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
		File archivoDatos = new File(dirDatos, "datos");
		if (!archivoDatos.exists()) {
			if (!archivoDatos.createNewFile())
				throw new FileNotFoundException("no se pudo crear el archivo");
		}
		try (FileOutputStream outputStream = new FileOutputStream(archivoDatos)) {
			outputStream.write(bytes);
		}
	}
	
	
	
	public Usuario getUsuario(String usuario, String clave)
	{
		Usuario usuarioInteres = datos.getUsuario(usuario, clave);
		return usuarioInteres;
	}
	
	public ArrayList<Sede> getSedes()
	{
		ArrayList<Sede> listaSedes = datos.getSedes();
		return listaSedes;
	}
	
	public void registroAdmin(String usuario, String clave, String sede) 
	{
		Map<String, Admin> mapaAdmins = datos.getAdmins();
		if (!mapaAdmins.containsKey(usuario)) 
		{
            // El admin no existe, agregarlo
			Admin nuevoAdmin = new Admin(usuario, clave, sede);
			mapaAdmins.put(usuario, nuevoAdmin);
			datos.actUsuarios();
        } 
		else
        {
            // El admin ya existe
            System.out.println("El nombre de usuario ya esta en uso. Intenta con otro");
        }
		
	}

	
}
	