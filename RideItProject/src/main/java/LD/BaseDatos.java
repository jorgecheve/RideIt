package LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;
/**
 * 
 * Clase BaseDatos será la encargada de contener todos los métodos necesarios para interactuar 
 * con la base de datos. La BD contendrá las tablas de usuarios, bicicletas, alquileres y estaciones.
 *
 */
public class BaseDatos {
	
	private static Connection connection = null;
	private static Statement statement = null;

	/** Inicializa una BD SQLITE y devuelve una conexi�n con ella. Debe llamarse a este 
	 * m�todo antes que ning�n otro, y debe devolver no null para poder seguir trabajando con la BD.
	 * @param nombreBD	Nombre de fichero de la base de datos
	 * @return	Conexi�n con la base de datos indicada. Si hay alg�n error, se devuelve null
	 */
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    connection = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
		    return connection;
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog( null, "Error de conexi�n!! No se ha podido conectar con " + nombreBD , "ERROR", JOptionPane.ERROR_MESSAGE );
			System.out.println( "Error de conexi�n!! No se ha podido conectar con " + nombreBD );
			return null;
		}
	}
	
	/** Cierra la conexi�n con la Base de Datos
	 */
	public static void close() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Devuelve la conexi�n si ha sido establecida previamente (#initBD()).
	 * @return	Conexi�n con la BD, null si no se ha establecido correctamente.
	 */
	public static Connection getConnection() {
		return connection;
	}
	
	/** Devuelve una sentencia para trabajar con la BD,
	 * si la conexi�n si ha sido establecida previamente (#initBD()).
	 * @return	Sentencia de trabajo con la BD, null si no se ha establecido correctamente.
	 */
	public static Statement getStatement() {
		return statement;
	}

	/**
	 * Método encargado de crear la tabla bicicleta en la BD
	 */
	public static void crearTablaBicicleta() 
	{
		if (statement==null) return;
		try {
			statement.executeUpdate("create table bicicleta " +
				"(id string, color string, modelo string" +
				", ubicacion string)");
		} catch (SQLException e) {
			// Si hay excepci�n es que la tabla ya exist�a (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	/**
	 * Método encargado de crear la tabla usuario en la BD
	 */
	public static void crearTablaUsuario() 
	{
		if (statement==null) return;
		try {
			statement.executeUpdate("create table if not exists USUARIO ( nombre string, apellido string, dni string, user string , password string)");
		} catch (SQLException e) {
			// Si hay excepci�n es que la tabla ya exist�a (lo cual es correcto)
			e.printStackTrace();  
		}
	}
	/**
	 * Método encargado de crear la tabla alquiler en la BD
	 */
	public static void crearTablaAlquiler() 
	{
		if (statement==null) return;
		try {
			statement.executeUpdate("create table if not exists ALQUILER ( id int, bici_id int, user_dni string, fecha_ini string , fecha_fin string)");
		} catch (SQLException e) {
			// Si hay excepci�n es que la tabla ya exist�a (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	/**
	 * Método encargado de crear la tabla estación en la BD
	 */
	public static void crearTablaEstacion() 
	{
		if (statement==null) return;
		try {
			statement.executeUpdate("create table if not exists ESTACION ( idEstacion int, localizacion string)");
		} catch (SQLException e) {
			// Si hay excepci�n es que la tabla ya exist�a (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	/**
	 * Método encargado de grabar los alquileres de bicis
	 * @param id
	 * @param bici_id
	 * @param user_dni
	 * @param inicio
	 * @param fin
	 */
	public static void insertAlquiler(int id, int bici_id, String user_dni, LocalDateTime inicio, LocalDateTime fin)
	{
		if (statement==null) return;
		String i="insert into ALQUILER (id, bici_id, user_dni, fecha_ini, fecha_fin) values(?,?,?,?,?)";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		try {
			 PreparedStatement pstmt = connection.prepareStatement(i);
			 pstmt.setInt(1,id);
			 pstmt.setInt(2, bici_id);
			 pstmt.setString(3, user_dni);
			 
			 pstmt.setString(4, inicio.format(formatter));
			 if(fin!=null) 
			 {
				 pstmt.setString(5, fin.format(formatter));
			 }else {
				 pstmt.setString(5, "");
			 }
			 
			 pstmt.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Método encargado de insertar una bicicleta en la tabla bicicleta
	 * @param id
	 * @param color
	 * @param modelo
	 * @param ubicacion
	 */
	public static void insertBicicleta(int id, String color, String modelo, String ubicacion)
	{
		if (statement==null) return;
		String i="insert into bicicleta (id, color, modelo, ubicacion) values(?,?,?,?)";
		
		try {
			 PreparedStatement pstmt = connection.prepareStatement(i);
			 pstmt.setInt(1,id);
			 pstmt.setString(2, color);
			 pstmt.setString(3, modelo);
			 pstmt.setString(4, ubicacion);
			 pstmt.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Método encargado de insertar un usuario en la tabla usuario
	 * @param nombre
	 * @param apellido
	 * @param dni
	 *@param user
	 *@param password
	 */
	public static void insertUsuario(String nombre, String apellido, String dni, String user,String password )
	{
		if (statement==null) return;
		String i="insert into USUARIO (nombre, apellido, dni, user,password) values(?,?,?,?,?)";
		
		try {
			 PreparedStatement pstmt = connection.prepareStatement(i);
			 pstmt.setString(1,nombre);
			 pstmt.setString(2, apellido);
			 pstmt.setString(3, dni);
			 pstmt.setString(4, user);
			 pstmt.setString(5, password);
			 pstmt.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Método encargado de insertar una estación en la tabla estación
	 * @param idEstacion
	 * @param localizacion
	 */
	public static void insertEstacion(int idEstacion, String localizacion, int numPlazas)
	{
		if (statement==null) return;
		String i="insert into ESTACION (idEstacion, localizacion, numPlazas) values(?,?,?)";
		
		try {
			 PreparedStatement pstmt = connection.prepareStatement(i);
			 pstmt.setInt(1, idEstacion);
			 pstmt.setString(2, localizacion);
			 pstmt.setInt(3, numPlazas);
			 pstmt.executeUpdate();
			 System.out.println("INSERTANDO ESTACION");
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Método que devuelve todas las bicicletas guardadas en la tabla bicicleta de la BD
	 */
	public static ArrayList<clsBicicleta> getAllBicicletas()
	{
		if(statement==null)return null;
		ArrayList<clsBicicleta>lista = new ArrayList<clsBicicleta>();
		String s="select * from bicicleta;";
		try {
			ResultSet rs=statement.executeQuery(s);
			
			while (rs.next()) {
                /*System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("color") + "\t" +
                                   rs.getString("modelo")+ "\t"+
                                   rs.getString("ubicacion"));*/
                
                int id_bike = rs.getInt("id");
                String col = rs.getString("color");
                String modelo = rs.getString("modelo");
                String localizacion = rs.getString("ubicacion");
                
                clsBicicleta bike = new clsBicicleta(id_bike, col, modelo, localizacion);
                lista.add(bike);
                				}
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return lista;
	}
	/**
	 * Método que devuelve todas los alquileres guardados en la tabla alquiler de la BD
	 */
	public static ArrayList<clsAlquiler> getAllAlquileres()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		if(statement==null)return null;
		ArrayList<clsAlquiler>lista = new ArrayList<clsAlquiler>();
		String s="select * from ALQUILER;";
		try {
			ResultSet rs=statement.executeQuery(s);
			
			while (rs.next()) {
				//id int, bici_id int, user_dni string, fecha_ini datetime , fecha_fin datetime
					int id= rs.getInt("id");
	                int bici_id = rs.getInt("bici_id");
	                String dni = rs.getString("user_dni");
	               
	                String ini= rs.getString("fecha_ini");
	                LocalDateTime inicio = LocalDateTime.parse(ini, formatter);
	               
	                String fin_alq = rs.getString("fecha_fin");
	                LocalDateTime fin;
	                if(!fin_alq.equals("")) 
	                {
	                	 fin = LocalDateTime.parse(fin_alq, formatter);
	                }else {
	                	fin=null;
	                }
	                
	               
	                clsAlquiler alquiler = new clsAlquiler (bici_id, dni, id, inicio, fin);
	                lista.add(alquiler);
                
                }
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return lista;
	}
	/**
	 * Método que registra la finalización del alquiler de una bicicleta por parte de un usuario
	 * @param user_bici
	 */
	public static void finalizarAlquiler(String user_dni)
	//(String user_dni, LocalDateTime fin) 
	{
		if (statement==null) return;
		
				//(id, bici_id, user_dni, fecha_ini, fecha_fin) values(?,?,?,?,?)";
		
		
		String i="DELETE FROM ALQUILER WHERE user_dni='"+user_dni+"' AND fecha_fin=''";
		
		
		try {
			 PreparedStatement pstmt = connection.prepareStatement(i);
			 
			 pstmt.executeUpdate();
			 System.out.println("se intenta");
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void borrarBici(int id) 
	{
		if (statement==null) return;
		

		String i="DELETE FROM bicicleta WHERE id='"+id+"'";
		
		
		try {
			 PreparedStatement pstmt = connection.prepareStatement(i);
			 
			 pstmt.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Método que devuelve todas los usuarios guardados en la tabla usuario de la BD
	 */
	public static ArrayList<clsUsuario> getAllUsuarios()
	{
		if(statement==null)return null;
		ArrayList<clsUsuario>lista = new ArrayList<clsUsuario>();
		String s="select * from USUARIO;";
		try {
			ResultSet rs=statement.executeQuery(s);
			
			while (rs.next()) {
				 
				String nombre= rs.getString("nombre");
	                String apellido = rs.getString("apellido");
	                String dni = rs.getString("dni");
	                String user = rs.getString("user");
	                String password = rs.getString("password");
	                
	                clsUsuario usuario = new clsUsuario(nombre, apellido, dni, user,password);
	                lista.add(usuario);
                
                				}
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	/**
	 * Método que devuelve todas las estaciones guardadas en la tabla estaciones de la BD
	 */
	public static ArrayList<clsEstacion> getAllEstaciones()
	{
		if(statement==null)return null;
		ArrayList<clsEstacion>lista = new ArrayList<clsEstacion>();
		String s="select * from ESTACION;";
		try {
			ResultSet rs=statement.executeQuery(s);
			
			while (rs.next()) {
				 
				int idEstacion= rs.getInt("idEstacion");
	            String localizacion = rs.getString("localizacion");
	            int plazas = rs.getInt("numPlazas");
	                   
	            clsEstacion estacion = new clsEstacion(idEstacion, localizacion,plazas);
	            lista.add(estacion);
                
                				}
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
}