package dam2.add.p11;


import java.io.File;
import java.util.ArrayList;


public class MainP11 {

	public static void main(String[] args) {
		//En el array se guarda al usuario de forma igual que se van registrando en el fichero acceso.
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario.cargaInicial(usuarios);
					
		File acceso = new File ("src"+File.separator+"dam2"+File.separator+"add"+File.separator+"p11"+File.separator+"acceso.txt");
		File loginLog = new File ("src"+File.separator+"dam2"+File.separator+"add"+File.separator+"p11"+File.separator+"login.log");
		
		boolean salir = false;
		
		while (!salir) {
			String login = Usuario.Login();
			Log.nuevoLog(loginLog, login);
			int accion = Usuario.comprobacionUserPass(acceso, login, usuarios);
			Menu.menu(accion, login, acceso, usuarios, loginLog);
		}
		

			

		
		
		
	}

}
