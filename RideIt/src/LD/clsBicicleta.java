package LD;

public class clsBicicleta {
	
	private int bici_id;
	private String color;
	private String modelo; //Podemos diferenciarlas entre electricas, tandem o estándar por ejemplo. Y que al hacer el setModelo se controle que es una de esas.
	private String ubicacion; //Esto pueden ser coordenadas por ejemplo. O la ubicacion de una estacion, que se modifique cuando se deja en alguna nueva.
	
	
	
	public clsBicicleta(int bici_id, String color, String modelo, String ubicacion) {
		
		this.bici_id = bici_id;
		this.color = color;
		this.modelo = modelo;
		this.ubicacion = ubicacion;
	}
	
	public int getBici_id() {
		return bici_id;
	}
	public void setBici_id(int bici_id) {
		this.bici_id = bici_id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	
	

}
