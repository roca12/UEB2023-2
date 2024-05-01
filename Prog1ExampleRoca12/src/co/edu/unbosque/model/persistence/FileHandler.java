package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Scanner;

public class FileHandler {

	private static File archivo;
	private static Scanner lectorDeArchivo;
	private static PrintWriter escritorDeArchivo;

	// serializados
	// lectura de serializados
	private static FileInputStream fis;
	private static ObjectInputStream ois;

	// escritura de serializados;
	private static FileOutputStream fos;
	private static ObjectOutputStream oos;

	public static void checkDataFolder() {
		archivo = new File("data");
		if (archivo.mkdir()) {
			System.out.println("Data folder first time created in: " + archivo.toURI());
		} else {
			// System.out.println("Data folder found in: " + archivo.toURI());
		}
	}

	public static void checkConfigFolder() {
		archivo = new File("config");
		if (archivo.mkdir()) {
			System.out.println("Config folder first time created in: " + archivo.toURI());
		} else {
			// System.out.println("Config folder found in: " + archivo.toURI());
		}

	}

	public static boolean checkSerializedFile(String url) {
		archivo = new File(url);
		return archivo.exists() ? true : false;

	}

	public static String openAndReadTextfiles(String url) {
		String contenido = "";
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			lectorDeArchivo = new Scanner(archivo);

			while (lectorDeArchivo.hasNext()) {
				contenido += lectorDeArchivo.nextLine() + "\n";
			}

			lectorDeArchivo.close();

		} catch (IOException e) {
			System.out.println("error al abrir y leer en el archivo (texto) " + e.getMessage());
			e.printStackTrace();
		}

		return contenido;
	}

	public static void openAndWriteTextfiles(String url, String conetenido) {

		archivo = new File(url);
		try {
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			escritorDeArchivo = new PrintWriter(archivo);
			escritorDeArchivo.print(conetenido);
			escritorDeArchivo.close();
		} catch (IOException e) {
			System.out.println("error al abrir y escribir en el archivo (texto) " + e.getMessage());
			e.printStackTrace();
		}

	}

	public static Object openAndReadFileSerial(String fileName) {
		Object content = null;
		try {
			archivo = new File(fileName);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);
			content = ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException e) {
			System.out.println("No se pudo leer en el archivo serializado (input)" + e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("error al obtener el contenido " + e.getMessage());
			e.printStackTrace();
		}
		return content;
	}

	public static void openAndWriteFileSerial(String fileName, Object content) {
		try {
			archivo = new File(fileName);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(content);
			oos.close();
			fos.close();
		} catch (IOException e) {
			System.out.println("problemas al abrir el archivo serializado (escritura) " + e.getMessage());
			e.printStackTrace();
		}

	}

	public static Properties loadProperties(String url) {
		Properties prop = null;
		try {
			prop = new Properties();
			prop.load(new FileInputStream(url));
		} catch (IOException e) {
			System.out.println("Error al cargar el archivo de propiedades: " + e.getMessage());
			e.printStackTrace();
		}
		
		return prop;
	}

	public static void saveProperties(String url, Properties prop) {
		try {
			prop.store(new FileWriter(url), "store to properties file");
		} catch (IOException e) {
			System.out.println("Error al guardar el archivo de propiedades: " + e.getMessage());
			e.printStackTrace();
		}
	}

}