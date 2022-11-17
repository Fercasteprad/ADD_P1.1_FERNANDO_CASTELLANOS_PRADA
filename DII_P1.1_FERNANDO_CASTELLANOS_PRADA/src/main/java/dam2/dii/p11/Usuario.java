package dam2.dii.p11;

public class Usuario {
	
	private String nombre;
	private String pass;
	private String pass2;
	
	public Usuario(String nombre, String pass, String pass2) {
		super();
		this.nombre = nombre;
		this.pass = pass;
		this.pass2 = pass2;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPass2() {
		return pass2;
	}
	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}
	
	

}
