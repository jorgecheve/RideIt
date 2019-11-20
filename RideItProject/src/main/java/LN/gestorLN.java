package LN;

import java.time.LocalDateTime;
import java.util.ArrayList;

import LD.BaseDatos;
import LD.clsBicicleta;
import LD.clsUsuario;
import LD.clsAlquiler;

public class gestorLN {
	
	private static ArrayList<clsBicicleta> listaBicis; 
	private static ArrayList<clsUsuario> listaUsuarios; 
	private static ArrayList<clsAlquiler> listaAlquileres;
	
	public static void altaBicicleta(int cod, String color, String modelo, String ubicacion){
		
		clsBicicleta bike = new clsBicicleta(cod, color, modelo, ubicacion);
		
		if(listaBicis == null) 
		{
			listaBicis= new ArrayList<clsBicicleta>();
			//Cuando se inicie el programa la arrayist estar� vac�a. Entonces cogeremos lo de la base de datos por si ya hay datos.
			//Salta una excepci�n la primera vez cuando a�n no existe la tabla. Se debe recoger la excepcion.
			
			listaBicis = gestorLN.getBicisBD();
			
		}
		
		//CHEQUEA QUE NO SE REPITE EL ID
		boolean repetido = false;
		for(clsBicicleta b:listaBicis) 
		{
			if(b.getBici_id()==cod) 
				repetido=true;
		}
		
		if(repetido==false) {
			listaBicis.add(bike);
			
			BaseDatos.initBD("RideIt");
			BaseDatos.crearTablaBicicleta();
			BaseDatos.insertBicicleta(cod, color, modelo, ubicacion);
			BaseDatos.close();
		}else {
			System.out.println("La bicicleta que has intentado introducir tiene un identificador que ya existe.");
		}
		
		//System.out.println(listaBicis.size());
	}
public static void altaUsuario(String nombre, String apellido, String dni, String usuario,String password){
		
		clsUsuario user = new clsUsuario(nombre, apellido, dni, usuario,password);
		
		if(listaUsuarios == null) 
		{
			listaUsuarios= new ArrayList<clsUsuario>();
			//Cuando se inicie el programa la arrayist estar� vac�a. Entonces cogeremos lo de la base de datos por si ya hay datos.
			//Salta una excepci�n la primera vez cuando a�n no existe la tabla. Se debe recoger la excepcion.
			listaUsuarios = gestorLN.getUsuariosBD();
		}
		
		//CHEQUEA QUE NO SE REPITE EL ID
		boolean repetido = false;
		for(clsUsuario b:listaUsuarios) 
		{
			if(b.getDni().equals(dni)) 
				repetido=true;
		}
		
		if(repetido==false) {
			listaUsuarios.add(user);
			
			BaseDatos.initBD("RideIt");
			BaseDatos.crearTablaUsuario();
			BaseDatos.insertUsuario(nombre, apellido, dni, usuario, password);
			BaseDatos.close();
		}else {
			System.out.println("El usuario que has intentado introducir tiene un identificador que ya existe.");
		}
		
		//System.out.println(listaBicis.size());
	}

public static void altaAlquiler(int id_bici, String dni_user){
	
	
	
	if(listaAlquileres == null) 
	{
		listaAlquileres= new ArrayList<clsAlquiler>();
		//Cuando se inicie el programa la arrayist estar� vac�a. Entonces cogeremos lo de la base de datos por si ya hay datos.
		//Salta una excepci�n la primera vez cuando a�n no existe la tabla. Se debe recoger la excepcion.
		listaAlquileres = gestorLN.getAlquileresBD();
	}

		clsAlquiler alqui = new clsAlquiler(id_bici, dni_user, listaAlquileres.size());
		listaAlquileres.add(alqui);
		
		BaseDatos.initBD("RideIt");
		BaseDatos.crearTablaAlquiler();
		BaseDatos.insertAlquiler(alqui.getIdAlquiler(), id_bici, dni_user, alqui.getFecha_inicio(), alqui.getFecha_fin());
		BaseDatos.close();
	
	
	//System.out.println(listaBicis.size());
}

	public static ArrayList<clsBicicleta> getBicisBD()
	{
		BaseDatos.initBD("RideIt");
		ArrayList<clsBicicleta>List=new ArrayList<clsBicicleta>();
		
		List = BaseDatos.getAllBicicletas();

		BaseDatos.close();
		
		return List;
	}
	public static ArrayList<clsUsuario> getUsuariosBD() 
	{
		BaseDatos.initBD("RideIt");
		ArrayList<clsUsuario>List=new ArrayList<clsUsuario>();
		List = BaseDatos.getAllUsuarios();

		BaseDatos.close();
			
		return List;
	}
	public static ArrayList<clsAlquiler> getAlquileresBD()
	{
		BaseDatos.initBD("RideIt");
		ArrayList<clsAlquiler>List=new ArrayList<clsAlquiler>();
		
		List = BaseDatos.getAllAlquileres();

		BaseDatos.close();
		
		return List;
	}

}
