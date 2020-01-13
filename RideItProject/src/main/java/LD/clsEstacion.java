package LD;

import LN.gestorLN;

public class clsEstacion {
	
	private int IdEstacion;
	private int NumPlazas;
	private String Localizacion;
	
	
	
	public clsEstacion(int idEstacion, String localizacion, int numPlazas) {
		super();
		
		this.IdEstacion = idEstacion;
		this.NumPlazas = numPlazas;
		this.Localizacion = localizacion;
		
	}
	public clsEstacion(int idEstacion, String localizacion) {
		super();
		
		this.IdEstacion = idEstacion;
		this.NumPlazas = 10;
		this.Localizacion = localizacion;
		
	}
	public int getIdEstacion() {
		return IdEstacion;
	}
	public void setIdEstacion(int idEstacion) {
		IdEstacion = idEstacion;
	}
	public int getNumPlazas() {
		return NumPlazas;
	}
	public void setNumPlazas(int numPlazas) {
		NumPlazas = numPlazas;
	}
	
	public String getLocalizacion() {
		return Localizacion;
	}
	public void setLocalizacion(String localizacion) {
		Localizacion = localizacion;
	}
	@Override
	public String toString() {
		return "P. libres="+gestorLN.getPlazasDisp(IdEstacion)+"/" + NumPlazas + ", Zona=" + Localizacion
				+", Cod: "+ IdEstacion+"]";
	}

	
}
