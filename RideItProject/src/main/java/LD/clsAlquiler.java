package LD;

import java.time.Duration;
import java.time.LocalDate;

public class clsAlquiler {
	
	private int idAlquiler;
	private int bici_id;
	private String user_dni;
	
	private LocalDate fecha_inicio;
	private LocalDate fecha_fin;
	
	
	
	public clsAlquiler(int bici_id, String user_dni, int idAlquiler) {
		super();
		this.bici_id = bici_id;
		this.user_dni = user_dni;
		this.idAlquiler = idAlquiler;
		
		LocalDate ini = LocalDate.now();
		this.fecha_inicio = ini;
	}
	
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
	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public LocalDate getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(LocalDate fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	
	public int getDuracion() 
	{
		Duration duracion=Duration.between(this.fecha_inicio, this.fecha_fin);
		System.out.println("Esta es la duracion"+duracion);
		return 0;
	}
	

}
