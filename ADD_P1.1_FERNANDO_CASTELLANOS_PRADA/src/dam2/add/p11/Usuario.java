package dam2.add.p11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


public class Usuario {

	private int idLinea;
	private boolean estado;
	private boolean admin;
	public final static int intentos = 3;

	
	
	public Usuario(int idLinea, boolean estado) {
		this.idLinea = idLinea;
		this.estado = estado;
		this.admin = false;
	}
	
	public Usuario(int idLinea, boolean estado, boolean admin) {
		this.idLinea = idLinea;
		this.estado = estado;
		this.admin = admin;
	}

	public int getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	//Pide usuario y contraseña y devuelve un string las dos claves separadas por :
	public static String Login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce nombre de usuario");
		String user = sc.next();
		System.out.println("Introduce contraseña");
		String pass = sc.next();
		String userPass = user + ":" + pass;
		return userPass;
	}
	//Extrae el nombre de usuario
	public static String sacarUser(String texto) {
		String user = "";
		for (int i = 0; i < texto.length(); i++) {
			String ver = texto.substring(i,i+1);
			if (ver.equals(":")) {
				user = texto.substring(0, i);
			}
		}
		return user;
	}
	//Extrae la contraseña
	public static String sacarPass(String texto) {
		String pass = "";
		for (int i = 0; i < texto.length(); i++) {
			String ver = texto.substring(i,i+1);
			if (ver.equals(":")) {
				pass = texto.substring(i + 1, texto.length());
			}
		}
		return pass;
	}

	public static int comprobacionUserPass(File archivo, String passUser, ArrayList<Usuario> estado) {
		// devolver 1 es igual a logueado correctamente. devolver -1 es igual a usuario
		// bloqueado, devolver 0 es igual a nuevo usuario y devolver 2 es a admin logueado
		int devolver = 0;

		try {
			FileReader leoArchivo = new FileReader(archivo);
			BufferedReader loLeo = new BufferedReader(leoArchivo);
			String comparador = loLeo.readLine();

			String user = sacarUser(passUser);
			String pass = sacarPass(passUser);
			int contadorLineas = 0;
			while (comparador != null) {
				String userComparador = sacarUser(comparador);
				String passComparador = sacarPass(comparador);
				if (userComparador.equals(user) && passComparador.equals(pass) && estado.get(contadorLineas).isEstado() && estado.get(contadorLineas).isAdmin()) {
					devolver = 2;
				
				} else if (userComparador.equals(user) && passComparador.equals(pass) && estado.get(contadorLineas).isEstado()) {
					devolver = 1;
					
				} else if (userComparador.equals(user) && !(estado.get(contadorLineas).isEstado())) {
					devolver = -1;

				} else if (userComparador.equals(user) && !(passComparador.equals(pass))) {
					int intentosRestantes = intentos;
					boolean comprobarPass = comprobarPass(passComparador, intentosRestantes);
					if (comprobarPass) {
						devolver = 1;
					} else {
						estado.get(contadorLineas).setEstado(comprobarPass);
						devolver = -1;
					}
				
				}  else {
					
				}
				contadorLineas++;
				comparador = loLeo.readLine();

			}
			loLeo.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo");
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo");
		}
		
		return devolver;
	}

	public static boolean comprobarPass(String pass, int intentos) {
		boolean passCheck = false;
		Scanner sc = new Scanner(System.in);
		int contador = 0;
		while (contador < intentos) {
			System.out.println("Contraseña incorrecta, tienes " + (intentos - contador) + " intentos");
			System.out.println("Introduzca de nuevo la contrasena");
			String comprobarPass = sc.next();
			if (pass.equals(comprobarPass)) {
				passCheck = true;
			} else if (!(pass.equals(comprobarPass)) && contador+1 == intentos) {
				passCheck = false;
			} else {
				
			}
			contador++;
		}

		return passCheck;

	}
	
	public static void cargaInicial (ArrayList<Usuario> usuarios) {
		
		Usuario m0 = new Usuario (0,true,true);
		Usuario m1 = new Usuario (1,true);
		Usuario m2 = new Usuario (2,false);
		Usuario m3 = new Usuario (3,false);
		usuarios.add(m0);
		usuarios.add(m1);
		usuarios.add(m2);
		usuarios.add(m3);
		
	}
	
	public static void nuevoUser (File acceso, String user, ArrayList<Usuario> usuarios, File log) {
					
			Scanner sc = new Scanner (System.in);
			String usuario = sacarUser(user);
			System.out.println("Usuario no registrado");
			System.out.println("Tu usuario es "+usuario);
			System.out.println("Por favor escribe tu contraseña");
			String pass = "";
			pass = sc.next();
			String passComprobador = " ";
			while ( !(pass.equals(passComprobador)) && !(passComprobador.equals("0"))) {
				System.out.println("por favor introduce la contraseña de nuevo");
				passComprobador = sc.next();
				if (pass.equals(passComprobador)) {
					Log.nuevoRegistro(log, acceso, usuario, passComprobador);
					Usuario nuevo = new Usuario (usuarios.size(),true);
					usuarios.add(nuevo);
					System.out.println("Usuario creado correctamente");
				}
				else {
					
				}
			
				
			}
			
			if (passComprobador.equals("0")) {
				Log.intento(log);
			}
			
	}
	
	public static void desbloquearUsuario (File archivo, ArrayList<Usuario> usuarios, File log) {
		
		try {
			Scanner sc = new Scanner (System.in);
			FileReader leoArchivo = new FileReader(archivo);
			BufferedReader loLeo = new BufferedReader(leoArchivo);
			String comparador = loLeo.readLine();
			int contador = 0;
			int contador2 = 1;
			ArrayList<Integer> listaBloqueadosInt = new ArrayList<Integer>();
			ArrayList<String> listaBloqueadosString = new ArrayList<String>();
			
			System.out.println("A que usuario quieres desbloquear de los siguientes?");
			while (comparador != null) {
				
				String user = sacarUser(comparador);
				
				if (usuarios.get(contador).estado) {
					
				}
				else {
					System.out.println(contador2+" - "+user);
					listaBloqueadosInt.add(contador);
					listaBloqueadosString.add(user);
					contador2++;
				}
				
				comparador = loLeo.readLine();
				if (comparador == null) {
					
				}
				else {
					contador++;
				}
			}
			
			int opcion = sc.nextInt();
			usuarios.get(listaBloqueadosInt.get(opcion-1)).setEstado(true);
			System.out.println("El usuario "+listaBloqueadosString.get(opcion-1)+" ha sido desbloqueado");
			Log.desbloqueado(log, listaBloqueadosString.get(opcion-1));
			loLeo.close();
			
			
		} catch(FileNotFoundException e) {
			System.out.println("Error al abrir el archivo");
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo");
		}
		
	}

}
