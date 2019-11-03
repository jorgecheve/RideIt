package LN;

import java.util.ArrayList;

import LD.BaseDatos;
import LD.clsBicicleta;
import LD.clsUsuario;

public class gestorLN {
	
	private static ArrayList<clsBicicleta> listaBicis; 
	private static ArrayList<clsUsuario> listaUsuarios; 
	
	public static void altaBicicleta(int cod, String color, String modelo, String ubicacion){
		
		clsBicicleta bike = new clsBicicleta(cod, color, modelo, ubicacion);
		
		if(listaBicis == null) 
		{
			listaBicis= new ArrayList<clsBicicleta>();
			//Cuando se inicie el programa la arrayist estará vacía. Entonces cogeremos lo de la base de datos por si ya hay datos.
			//Salta una excepción la primera vez cuando aún no existe la tabla. Se debe recoger la excepcion.
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
			//Cuando se inicie el programa la arrayist estará vacía. Entonces cogeremos lo de la base de datos por si ya hay datos.
			//Salta una excepción la primera vez cuando aún no existe la tabla. Se debe recoger la excepcion.
			listaUsuarios = gestorLN.getUsuariosBD();
		}
		
		//CHEQUEA QUE NO SE REPITE EL ID
		boolean repetido = false;
		for(clsUsuario b:listaUsuarios) 
		{
			if(b.getDni()==dni) 
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
	public static ArrayList<clsBicicleta> getBicisBD() 
	{
		BaseDatos.initBD("RideIt");
		ArrayList<clsBicicleta>List=new ArrayList<clsBicicleta>();
		List = BaseDatos.getAllBicicletas();

		BaseDatos.close();
		
		/*for(clsBicicleta b: pruebaList) 
		{
			System.out.println(b.getBici_id()+b.getColor()+b.getModelo()+b.getUbicacion());
		}*/
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

}
