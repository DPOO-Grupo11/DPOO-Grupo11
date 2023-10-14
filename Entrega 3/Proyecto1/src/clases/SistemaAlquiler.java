package clases;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;

public class SistemaAlquiler {
	private ContenedorDeDatos datos;
	private static final String pathArchivoDatos = "./datos";
	private static final String dirImagenes = "./";

	public SistemaAlquiler() throws FileNotFoundException, IOException {
		System.out.println("hola");
	}

	/*
	 * funciones
	 */
	public void cargarDatos() throws IOException {
		// cargar bytes de archivo
		File archivoDatos = new File(pathArchivoDatos);
		byte[] bytes = Files.readAllBytes(archivoDatos.toPath());
		// convertir bytes a objeto
		ByteArrayInputStream bs= new ByteArrayInputStream(bytes); // bytes es el byte[]
		ObjectInputStream is = new ObjectInputStream(bs);
		ContenedorDeDatos unObjetoSerializable = (ContenedorDeDatos)is.readObject();
		is.close();
	}

	public void guardarDatos() throws IOException {
		// convertir objeto de datos a bytes
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(bs);
		os.writeObject(datos);
		os.close();
		byte[] bytes = bs.toByteArray();
		// guardar bytes en archivo
		File archivoDatos = new File(pathArchivoDatos);
		try (FileOutputStream outputStream = new FileOutputStream(archivoDatos)) {
			outputStream.write(bytes);
		}
	}
}
