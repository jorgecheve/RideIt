package LD;

public class clsEstacion {
	
	private int IdEstacion;
	private int NumPlazas;
	private final int PlazasTotal;
	private int[] Plazas;
	private String Localizacion;
	
	
	
	public clsEstacion(int idEstacion, String localizacion) {
		super();
		
		this.IdEstacion = idEstacion;
		this.PlazasTotal = 10;
		this.NumPlazas = PlazasTotal;
		this.Plazas= new int[NumPlazas];
		this.Localizacion = localizacion;
		
		for (int i=0;i<PlazasTotal; i++)
		{
			this.Plazas[i]=-1;
		}
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
	public int[] getPlazas() {
		return Plazas;
	}
	public void setPlazas(int[] plazas) {
		Plazas = plazas;
	}
	public String getLocalizacion() {
		return Localizacion;
	}
	public void setLocalizacion(String localizacion) {
		Localizacion = localizacion;
	}

	
	public int getPlazasTotal() {
		return PlazasTotal;
	}
	
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
		
		
	}
}
