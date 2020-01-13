package LD;

public class clsBicicleta {
	
	private int bici_id;
	private String color;
	private String modelo; //Podemos diferenciarlas entre electricas, tandem o est�ndar por ejemplo. Y que al hacer el setModelo se controle que es una de esas.
	private String ubicacion; //Esto será el código de la estación donde se encuentra o nulo si no está en ninguna.
	
	
	
	public clsBicicleta(int bici_id, String color, String modelo, String ubicacion) {
		
		this.bici_id = bici_id;
		this.color = color;
		this.modelo = modelo;
		this.ubicacion = ubicacion;
	}
	public clsBicicleta() {
		this.bici_id = -5;
		this.color = null;
		this.modelo = null;
		this.ubicacion = null;
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
	@Override
	public String toString() {
		return "[id:" + bici_id + ", " + color + ", " + modelo  + "]";
	}
	
	
	
	
	

}
