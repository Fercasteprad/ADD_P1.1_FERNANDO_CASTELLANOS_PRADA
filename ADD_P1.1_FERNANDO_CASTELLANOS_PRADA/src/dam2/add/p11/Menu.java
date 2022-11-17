package dam2.add.p11;

import java.io.File;
import java.util.ArrayList;

public class Menu {
	
	public static void menu (int accion, String login, File acceso, ArrayList<Usuario> usuarios, File loginLog) {
		
		
		if (accion == 1) {
			Log.correcto(loginLog);
			System.out.println("Hola "+Usuario.sacarUser(login));
		}
		else if (accion == 0) {
			Usuario.nuevoUser(acceso, login, usuarios, loginLog);
			
		}
		else if (accion == -1) {
			Log.bloqueado(loginLog);
		}
		
		else if (accion == 2) {
			Log.admin(loginLog);
			Usuario.desbloquearUsuario(acceso, usuarios, loginLog);
		}
	}

}
