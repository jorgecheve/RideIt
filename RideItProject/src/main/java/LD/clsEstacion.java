package LD;

import LN.gestorLN;
/**
 * Clase que crea el objeto estación
 * Contiene todos los atributos que componen la entidad estación
 *
 */
public class clsEstacion {
	/**
	 * Atributos de la clase clsEstacion
	 */
	private int IdEstacion;
	private int NumPlazas;
	private String Localizacion;
	
	
	/**
	 * Constructor con parámetros de la clase clsEstacion
	 * @param idEstacion
	 * @param localizacion
	 * @param numPlazas
	 */
	public clsEstacion(int idEstacion, String localizacion, int numPlazas) {
		super();
		
		this.IdEstacion = idEstacion;
		this.NumPlazas = numPlazas;
		this.Localizacion = localizacion;
		
	}
	/**
	 * Constructor sin parámetros de la clase
	 * @param idEstacion
	 * @param localizacion
	 */
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
	/**
	 * Método que devuelve la cadena de caracteres del objeto estación
	 */
	@Override
	public String toString() {
		return "P. libres="+gestorLN.getPlazasDisp(IdEstacion)+"/" + NumPlazas + ", Zona=" + Localizacion
				+", Cod: "+ IdEstacion+"]";
	}

	
}
