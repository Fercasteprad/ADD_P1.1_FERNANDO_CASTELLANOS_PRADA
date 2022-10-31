package dam2.add.p11;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Log {

	public static void nuevoLog(File log, String usuario) {

		try {
			FileWriter loginLog = new FileWriter(log, true);
			BufferedWriter escribirLog = new BufferedWriter(loginLog);
			Date fecha = new Date();
			escribirLog.newLine();
			escribirLog.write("Usuario: " + Usuario.sacarUser(usuario) + " con fecha: " + fecha);
			escribirLog.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo");
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo");
		}

	}

	public static void correcto(File log) {

		try {
			FileWriter loginLog = new FileWriter(log, true);
			BufferedWriter escribirLog = new BufferedWriter(loginLog);
			escribirLog.write(" - Login: Correcto");
			escribirLog.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo");
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo");
		}

	}

	public static void nuevoRegistro(File log, File acceso, String usuario, String pass) {

		try {
			FileWriter loginLog = new FileWriter(log, true);
			BufferedWriter escribirLog = new BufferedWriter(loginLog);
			FileWriter escribir = new FileWriter(acceso, true);
			BufferedWriter escribirRegistro = new BufferedWriter(escribir);
			escribirRegistro.newLine();
			escribirRegistro.write(usuario + ":" + pass);
			escribirLog.write("- Login: Usuario nuevo registrado");
			escribirLog.close();
			escribirRegistro.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo");
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo");
		}

	}

	public static void intento(File log) {

		try {
			FileWriter loginLog = new FileWriter(log, true);
			BufferedWriter escribirLog = new BufferedWriter(loginLog);
			escribirLog.write(" - Login: Intento de registro");
			escribirLog.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo");
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo");
		}

	}

	public static void bloqueado(File log) {

		try {
			FileWriter loginLog = new FileWriter(log, true);
			BufferedWriter escribirLog = new BufferedWriter(loginLog);
			escribirLog.write(" - Login: Usuario bloqueado");
			escribirLog.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo");
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo");
		}

	}

	public static void admin(File log) {

		try {
			FileWriter loginLog = new FileWriter(log, true);
			BufferedWriter escribirLog = new BufferedWriter(loginLog);
			escribirLog.write(" - Login: Admin logueado");
			escribirLog.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo");
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo");
		}

	}
	
	public static void desbloqueado(File log, String usuario) {

		try {
			FileWriter loginLog = new FileWriter(log, true);
			BufferedWriter escribirLog = new BufferedWriter(loginLog);
			escribirLog.write(" - "+usuario+" desbloqueado");
			escribirLog.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo");
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo");
		}

	}

}
