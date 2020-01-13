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

	
	
	/*
	public boolean getPlazasDisp()
	{
		if(NumPlazas>0)
		{
			return true;
		}
		return false;
	}
	
	public boolean DejarBici(int idBici)
	{
		for(int i=0; i<PlazasTotal; i++)
		{
			if(this.Plazas[i]==-1 && this.getPlazasDisp()==true)
			{
				this.Plazas[i]=idBici;
				System.out.println("Bicicleta estacionada");
				return true;
			}
		}
		
		System.out.println("No hay plazas disponibles para estacionar");
		return false;
	}
	
	public int CogerBicicleta(int NumeroP)
	{
		int idBicicleta=this.Plazas[NumeroP];
		
		if(idBicicleta!=-1)
		{
			Plazas[NumeroP]=-1;
			System.out.println("Bicicleta recogida");
			return idBicicleta;
		}
		else
		{
			System.out.println("No existe Bicicleta en esa plaza");
			return -1;
			
		}
		
		
	}*/
}
