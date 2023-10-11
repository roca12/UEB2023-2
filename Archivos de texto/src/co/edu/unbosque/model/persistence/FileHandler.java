package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandler {

	private static Scanner fileReader;
	private static PrintWriter fileWriter;
	private static File myFile;

	public FileHandler() {

	}

	public static String openAndReadFile(String url) {

		myFile = new File(url);

		try {
			fileReader = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			try {
				myFile.createNewFile();
			} catch (IOException e1) {

				System.out.println("No tengo permisos de escritura");
			}
			System.out.println("El archivo no existia, ha sido creado");
		}
		String content = "";
		while (fileReader.hasNext()) {
			content += fileReader.nextLine() + "\n";
		}
		return content;
	}

	public static void openAndWriteFile(String url, String content) {

		myFile = new File(url);

		try {
			if (!myFile.exists()) {

				myFile.createNewFile();
			}
			fileWriter = new PrintWriter(myFile);
			fileWriter.write(content);
			fileWriter.close();
			//System.out.println(myFile.length());
		} catch (FileNotFoundException e) {

			System.out.println("No encontre el archivo");
		} catch (IOException e) {

			System.out.println("No tengo permisos");
		}

	}

}
