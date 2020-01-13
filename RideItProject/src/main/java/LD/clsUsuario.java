package LD;
/**
 * Clase que crea el objeto usuario
 * Contiene todos los atributos que componen la entidad usuario
 *
 */
public class clsUsuario 
{
/**
 * Atributos de la clase clsUsuario
 */
	String nombre;
	String apellidos;
	String dni;
	String user;
	String passwaord;
	/**
	 * Constructor con parámetros de la clase clsUsuario
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param user
	 * @param passwaord
	 */
	public clsUsuario(String nombre, String apellidos, String dni, String user, String passwaord) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.user = user;
		this.passwaord = passwaord;
	}
/**
 * getters y setters de los atributos de la clase
 * @return
 */
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

	/**
	 * Método que devuelve la cadena de caracteres del objeto clsUsuario
	 */
	@Override
	public String toString() {
		return "clsUsuario [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", user=" + user
				+ ", passwaord=" + passwaord + "]";
	}
	
	
	
	
	
}
