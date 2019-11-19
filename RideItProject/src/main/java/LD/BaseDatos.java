package LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BaseDatos {
	
	private static Connection connection = null;
	private static Statement statement = null;

	/** Inicializa una BD SQLITE y devuelve una conexión con ella. Debe llamarse a este 
	 * método antes que ningún otro, y debe devolver no null para poder seguir trabajando con la BD.
	 * @param nombreBD	Nombre de fichero de la base de datos
	 * @return	Conexión con la base de datos indicada. Si hay algún error, se devuelve null
	 */
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    connection = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
		    return connection;
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog( null, "Error de conexión!! No se ha podido conectar con " + nombreBD , "ERROR", JOptionPane.ERROR_MESSAGE );
			System.out.println( "Error de conexión!! No se ha podido conectar con " + nombreBD );
			return null;
		}
	}
	
	/** Cierra la conexión con la Base de Datos
	 */
	public static void close() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Devuelve la conexión si ha sido establecida previamente (#initBD()).
	 * @return	Conexión con la BD, null si no se ha establecido correctamente.
	 */
	public static Connection getConnection() {
		return connection;
	}
	
	/** Devuelve una sentencia para trabajar con la BD,
	 * si la conexión si ha sido establecida previamente (#initBD()).
	 * @return	Sentencia de trabajo con la BD, null si no se ha establecido correctamente.
	 */
	public static Statement getStatement() {
		return statement;
	}

	public static void crearTablaBicicleta() 
	{
		if (statement==null) return;
		try {
			statement.executeUpdate("create table bicicleta " +
				"(id string, color string, modelo string" +
				", ubicacion string)");
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}

	public static void crearTablaUsuario() 
	{
		if (statement==null) return;
		try {
			statement.executeUpdate("create table if not exists USUARIO ( nombre string, apellido string, dni string, user string , password string)");
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
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
			//e.printStackTrace();
		}
		return lista;
	}
}
