package LN;
/**
 * Clase que contiene los métodos necesarios para la funcionalidad de la aplicación
 * estos métodos hacen de enlace entre la lógica de datos LD y la lógica de presentación LP
 */
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import LD.BaseDatos;
import LD.clsBicicleta;
import LD.clsEstacion;
import LD.clsUsuario;
import LD.clsAlquiler;

public class gestorLN {
	
	private static ArrayList<clsBicicleta> listaBicis; 
	private static ArrayList<clsUsuario> listaUsuarios; 
	private static ArrayList<clsEstacion> listaEstaciones;
	private static ArrayList<clsAlquiler> listaAlquileres;
	/**
	 * Método encargado de dar de alta una bicicleta en la BD
	 * @param cod
	 * @param color
	 * @param modelo
	 * @param ubicacion
	 * @return
	 */
	public static boolean altaBicicleta(int cod, String color, String modelo, String ubicacion){
		
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
		boolean resultado = false;
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
			resultado=true;
			return resultado;
		}else {
			System.out.println("La bicicleta que has intentado introducir tiene un identificador que ya existe.");
			resultado=false;
			return resultado;
		}
		
		//System.out.println(listaBicis.size());
	}
	/**
	 * Método encargado de dar de alta un usuario en la BD
	 * @param nombre
	 * @param apellido
	 * @param dni
	 * @param usuario
	 * @param password
	 */
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
			System.out.println("Intentamos crear tabla");
			BaseDatos.crearTablaUsuario();
			BaseDatos.insertUsuario(nombre, apellido, dni, usuario, password);
			BaseDatos.close();
		}else {
			System.out.println("El usuario que has intentado introducir tiene un identificador que ya existe.");
		}
		
		System.out.println("USUARIO CREADO HULIO");
		//System.out.println(listaBicis.size());
	}
/**
 * Método encargado de dar de alta una estación en la BD
 * @param idEstacion
 * @param localizacion
 * @param plazas
 */
public static void altaEstacion(int idEstacion, String localizacion, int plazas)
{
	
	clsEstacion estacion = new clsEstacion(idEstacion, localizacion, plazas);
	
	if(listaEstaciones == null) 
	{
		listaEstaciones= new ArrayList<clsEstacion>();
		//Cuando se inicie el programa la arrayist estar� vac�a. Entonces cogeremos lo de la base de datos por si ya hay datos.
		//Salta una excepci�n la primera vez cuando a�n no existe la tabla. Se debe recoger la excepcion.
		listaEstaciones = gestorLN.getEstacionBD();
	}
	
	//CHEQUEA QUE NO SE REPITE EL ID
	boolean repetido = false;
	for(clsEstacion e:listaEstaciones) 
	{
		if(e.getIdEstacion()==idEstacion) 
			repetido=true;
	}
	
	if(repetido==false) {
		listaEstaciones.add(estacion);
		
		BaseDatos.initBD("RideIt");
		BaseDatos.crearTablaEstacion();
		BaseDatos.insertEstacion(estacion.getIdEstacion(), estacion.getLocalizacion(),estacion.getNumPlazas());
		BaseDatos.close();
	}else {
		System.out.println("La estacion que has intentado introducir tiene un identificador que ya existe.");
	}
	
	//System.out.println(listaBicis.size());
}
/**
 * Método encargado de dar de alta un alquiler en la BD
 * @param id_bici
 * @param dni_user
 */
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
/**
 * Método que devuelve las bicicletas que hay guardadas en la BD
 * @return
 */
	public static ArrayList<clsBicicleta> getBicisBD()
	{
		BaseDatos.initBD("RideIt");
		ArrayList<clsBicicleta>List=new ArrayList<clsBicicleta>();
		
		List = BaseDatos.getAllBicicletas();

		BaseDatos.close();
		
		return List;
	}
	/**
	 * Método que devuelve los usuarios que hay guardados en la BD
	 * @return
	 */
	public static ArrayList<clsUsuario> getUsuariosBD() 
	{
		BaseDatos.initBD("RideIt");
		ArrayList<clsUsuario>List=new ArrayList<clsUsuario>();
		List = BaseDatos.getAllUsuarios();

		BaseDatos.close();
			
		return List;
	}
	/**
	 * Método que devuelve las estaciones que hay guardadas en la BD
	 * @return
	 */
	public static ArrayList<clsEstacion> getEstacionBD() 
	{
		BaseDatos.initBD("RideIt");
		ArrayList<clsEstacion>List=new ArrayList<clsEstacion>();
		List = BaseDatos.getAllEstaciones();

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
	/**
	 * Métododo que guarda el alquiler de una bicicleta por parte de un usuario
	 * @param Dni
	 * @param idBicicleta
	 */
	public static void cogerBici(String Dni, int idBicicleta)
	{
		clsBicicleta bici=new clsBicicleta();
		
		for(int i=0;i<listaBicis.size();i++)
		{
			if(listaBicis.get(i).getBici_id()==idBicicleta) 
			{
				bici=listaBicis.get(i);
				listaBicis.remove(i);
			}
		}
		
		gestorLN.altaAlquiler(idBicicleta, Dni);
		
		BaseDatos.initBD("RideIt");
		BaseDatos.borrarBici(idBicicleta);
		BaseDatos.close();
		
		//CREO QUE AQUI NO ESTÁ CREANDO PORQUE YA EXISTE UNA CON ESE CODIGO
		gestorLN.altaBicicleta(bici.getBici_id(), bici.getColor(), bici.getModelo(), null);
		
		
	}
	/**
	 * Método que guarda la finalización del alquiler de una bicicleta por parte de un usuario
	 * @param dni
	 * @param estacion
	 * @return
	 */
	public static int dejarBici(String dni, int estacion)
	{
		clsAlquiler modif = null;
		clsBicicleta bici=new clsBicicleta();
		int idBici=0;
		
		for(clsAlquiler a: listaAlquileres) {
			if(a.getUser_dni().equals(dni) && a.getFecha_fin()==null) {
				LocalDateTime fin = LocalDateTime.now();
				a.setFecha_fin(fin);
				modif=a;
				idBici=a.getBici_id();
			}
		}
		
		BaseDatos.initBD("RideIt");
		System.out.println("PROCEDO A INTENTAR MODIFICAR ALQUILER");
		BaseDatos.finalizarAlquiler(dni);
		BaseDatos.insertAlquiler(modif.getIdAlquiler(), modif.getBici_id(), modif.getUser_dni(), modif.getFecha_inicio(), modif.getFecha_fin());
		BaseDatos.close();	
		
		for(int i=0;i<listaBicis.size();i++) 
		{
			if(idBici==listaBicis.get(i).getBici_id()) {
				
				bici = listaBicis.get(i);
				bici.setUbicacion(Integer.toString(estacion));
				listaBicis.remove(i);
				
			}
		}
		
		BaseDatos.initBD("RideIt");
		BaseDatos.borrarBici(idBici);
		BaseDatos.close();
		
		gestorLN.altaBicicleta(bici.getBici_id(), bici.getColor(), bici.getModelo(), bici.getUbicacion());
		
		return modif.getDuracion();
	}
	
	/**
	 * Método realizado para autenticar a un usuario en la aplicación
	 * @param usuario
	 * @param pswd
	 * @return
	 */
	public static boolean autenticacion(String usuario, String pswd) 
	{
		boolean autenticado=false;
		for(clsUsuario u: listaUsuarios) 
		{
			if(u.getUser().equals(usuario)) 
			{
				if(u.getPasswaord().equals(pswd)) {
					autenticado=true;
					return autenticado;
				}
			}
		}
		
		return autenticado;
	}
	/**
	 * Devuelve las bicicletas disponibles que hay en la BD
	 * @return
	 */
	public static ArrayList<clsBicicleta> bicisDisp()
	{
		ArrayList<clsBicicleta> bicis = new ArrayList<clsBicicleta>();
		bicis= listaBicis;
		
		for(clsAlquiler al:listaAlquileres)
		{
			if(al.getFecha_fin()==null) 
			{
				int idBici=al.getBici_id();
				
				for(int i=0; i<bicis.size();i++) 
				{
					if(idBici==bicis.get(i).getBici_id()) 
					{
						bicis.remove(i);
					}
				}
			}
		}
		return bicis;
	}
	/**
	 * En este método iniciamos las listas
	 */
	public static void iniciarListas() 
	{
		listaUsuarios = gestorLN.getUsuariosBD();
		listaAlquileres = gestorLN.getAlquileresBD();
		listaBicis= gestorLN.getBicisBD();
		listaEstaciones = gestorLN.getEstacionBD();
		
		gestorLN.altaEstacion(1,"Amara",10);
		gestorLN.altaEstacion(2,"Deusto",4);
		gestorLN.altaEstacion(3,"Aiete",13);
		
		gestorLN.altaBicicleta(7, "Roja", "Tandem", "1");
		gestorLN.altaBicicleta(8, "Azul", "Paseo", "2");
		gestorLN.altaBicicleta(9, "Verde", "Carretera", "3");
		
		//System.out.println(gestorLN.getPlazasDisp(1)+" plazas libres en la 2");
		
	}
	/**
	 * Método que comprueba si las estaciones estan libres o no de bicicletas
	 * @param codigoEst
	 * @return
	 */
	public static boolean comprobarEstacion(int codigoEst) 
	{
		int numeroPlazas=0;
		for(clsEstacion e: listaEstaciones) 
		{
			if(e.getIdEstacion()==codigoEst) {
				numeroPlazas=e.getNumPlazas();
			}
		}
		
		int contador=0;
		for(clsBicicleta b:listaBicis) 
		{
			if(b.getUbicacion()!=null && Integer.parseInt(b.getUbicacion())==codigoEst) {
				contador++;
			}
		}
		
		if(contador>=numeroPlazas) {
			return false;
		}
		else return true;
	}
	/**
	 * Devuelve las bicicletas de la estación que le pasemos por parámetro
	 * @param codEst
	 * @return
	 */
	public static ArrayList<clsBicicleta> getBicisEstacion(int codEst)
	{
		ArrayList<clsBicicleta>bicisEst=new ArrayList<clsBicicleta>();
		
		for(clsBicicleta b:listaBicis) 
		{
			if(b.getUbicacion()!=null && Integer.parseInt(b.getUbicacion())==codEst) {
				bicisEst.add(b);
			}
		}
		
		return bicisEst;
	}
	/**
	 * Devuelve el número de plazas disponibles en una estación
	 * @param estacion
	 * @return
	 */
	public static int getPlazasDisp(int estacion) 
	{
		int plazasDisp = 0;
		
		
		for(clsEstacion e:listaEstaciones) {
			if(estacion==e.getIdEstacion()) {
				plazasDisp = e.getNumPlazas()-gestorLN.getBicisEstacion(estacion).size();
			}
		}
		return plazasDisp;
	}
	/**
	 * Devuelve el usuario que coincida con el atributo user
	 * @param user
	 * @return
	 */
	public static clsUsuario getUsuario(String user) 
	{
		for(clsUsuario u: listaUsuarios) {
			if(u.getUser().equals(user)) {
				return u;
			}
		}
		
		return null;
	}
	/**
	 * Devuelve los alquileres efectuados por un usuario
	 * @param dni
	 * @return
	 */
	public static ArrayList<clsAlquiler> getAlquileresUser(String dni) 
	{
		ArrayList<clsAlquiler>ret = new ArrayList<clsAlquiler>();
		
		for(clsAlquiler u:listaAlquileres) 
		{
			if(u.getUser_dni().equals(dni)&&u.getFecha_fin()!=null) 
			{
				ret.add(u);
			}
		}
		return ret;
	}
	/**
	 * Devuelve el coste total por los alquileres efectuados
	 * @param lista
	 * @param precio
	 * @return
	 */
	public static double getCosteAlquileres(ArrayList<clsAlquiler>lista, double precio) 
	{
		double total=0;
		for(clsAlquiler a:lista) 
		{
			total = a.getDuracion()*precio + total;
		}
		return total;
	}
	/**
	 * Devuelve el estado del usuario, para ver si esta haciendo uso de un alquiler o no en ese momento
	 * @param dni
	 * @return
	 */
	public static boolean estadoUser(String dni) 
	{
		boolean pendiente=false;
		
		for(clsAlquiler a:listaAlquileres) {
			if(a.getFecha_fin()==null) 
			{
				if(a.getUser_dni().equals(dni)) {
					pendiente = true;
				}
			}
			
		}
		return pendiente;
	}
	/**
	 * Método para probar funcionalidades
	 */
	public static void probarListaUs() 
	{
		for(clsUsuario user: listaUsuarios) {
			System.out.println(user);
		}
		System.out.println("FIN USUARIOS");
		for(clsAlquiler user: listaAlquileres) {
			//System.out.println(user);
		}
		System.out.println("FIN Alquileres");
		for(clsBicicleta user: listaBicis) {
			System.out.println(user);
		}
		System.out.println("FIN BICIS");
		for(clsEstacion user: listaEstaciones) {
		//	System.out.println(user);
		}
		System.out.println("FIN ESTACIONES");
	}
	

}
