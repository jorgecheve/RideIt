package LD;

import java.time.Duration;
import java.time.LocalDateTime;
/**
 * 
 * clase que contiene todos los atributos que componen un alquiler
 *
 */
public class clsAlquiler {
	
	private int idAlquiler;
	private int bici_id;
	private String user_dni;
	
	private LocalDateTime fecha_inicio;
	private LocalDateTime fecha_fin;
	
	/**
	 * Método constructor de la clase alquiler
	 * @param bici_id
	 * @param user_dni
	 * @param idAlquiler
	 * @param inicio
	 * @param fin
	 */
	
	public clsAlquiler(int bici_id, String user_dni, int idAlquiler, LocalDateTime inicio, LocalDateTime fin) {
		super();
		this.bici_id = bici_id;
		this.user_dni = user_dni;
		this.idAlquiler = idAlquiler;
		this.fecha_inicio = inicio;
		this.fecha_fin = fin;
	}
	/**
	 * Método constructor de la clase alquiler
	 * @param bici_id
	 * @param user_dni
	 * @param idAlquiler
	 */
	public clsAlquiler(int bici_id, String user_dni, int idAlquiler) {
		super();
		this.bici_id = bici_id;
		this.user_dni = user_dni;
		this.idAlquiler = idAlquiler;
		
		LocalDateTime ini = LocalDateTime.now();
		this.fecha_inicio = ini;
		this.fecha_fin=null;
	}
	/**
	 * getters y setters de los atributos de la entidad alquiler
	 * 
	 */
	public int getIdAlquiler() {
		return idAlquiler;
	}
	public void setIdAlquiler(int idAlquiler) {
		this.idAlquiler = idAlquiler;
	}
	public int getBici_id() {
		return bici_id;
	}
	public void setBici_id(int bici_id) {
		this.bici_id = bici_id;
	}
	public String getUser_dni() {
		return user_dni;
	}
	public void setUser_dni(String user_dni) {
		this.user_dni = user_dni;
	}
	public LocalDateTime getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(LocalDateTime fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public LocalDateTime getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(LocalDateTime fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	/**
	 * Metodo para obtener la duración de alquiler
	 * @return devuelve la duración del alquiler de bicicletas
	 */
	//Si se devuelve -1 es que no se ha devuelto la bici todavía
	public int getDuracion() 
	{
		int diferencia = -1;
		if(this.fecha_inicio!=null && this.fecha_fin!=null) 
		{
			Duration duracion=Duration.between(this.fecha_inicio, this.fecha_fin);
			diferencia = (int) duracion.toMinutes();
		}
		
		return diferencia;
	}
	/**
	 * Devolvemos una cadena de caracteres con lo que queremos sacar por pantalla 
	 */
	@Override
	public String toString() {
		return "[Dur.= "+getDuracion()+" mins, Fecha=" + fecha_inicio.getDayOfMonth()+"/"+fecha_inicio.getMonthValue()+"/"+fecha_inicio.getYear() 
		+" a las: "+fecha_fin.getHour()+":"+fecha_fin.getMinute()+"]";
	}
	
	

}
