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

public class SistemaAlquiler {
	private ContenedorDeDatos datos;
	// toca pedir archivo de persistencia cada vez que se inicie programa
	private static final String dirDatos = System.getProperty("user.dir");;

	public SistemaAlquiler() throws FileNotFoundException, IOException {
		System.out.println("hola");
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
}
