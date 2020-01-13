package LD;

public class clsUsuario 
{

	String nombre;
	String apellidos;
	String dni;
	String user;
	String passwaord;
	
	public clsUsuario(String nombre, String apellidos, String dni, String user, String passwaord) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.user = user;
		this.passwaord = passwaord;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPasswaord() {
		return passwaord;
	}


	public void setPasswaord(String passwaord) {
		this.passwaord = passwaord;
	}


	@Override
	public String toString() {
		return "clsUsuario [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", user=" + user
				+ ", passwaord=" + passwaord + "]";
	}
	
	
	
	
	
}
