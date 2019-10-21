package LN;

import java.util.ArrayList;

import LD.BaseDatos;
import LD.clsBicicleta;

public class gestorLN {
	
	private static ArrayList<clsBicicleta> listaBicis; 
	
	public static void altaBicicleta(int cod, String color, String modelo, String ubicacion){
		
		clsBicicleta bike = new clsBicicleta(cod, color, modelo, ubicacion);
		
		if(listaBicis == null) 
		{
			listaBicis= new ArrayList<clsBicicleta>();
			//Cuando se inicie el programa la arrayist estará vacía. Entonces cogeremos lo de la base de datos por si ya hay datos.
			//Salta una excepción la primera vez cuando aún no existe la tabla. Se debe recoger la excepcion.
			listaBicis = gestorLN.getBicisBD();
		}
		
		//CHEQUEA QUE NO SE REPITE EL ID
		boolean repetido = false;
		for(clsBicicleta b:listaBicis) 
		{
			if(b.getBici_id()==cod) 
				repetido=true;
		}
		
		if(repetido==false) {
			listaBicis.add(bike);
			
			BaseDatos.initBD("RideIt");
			BaseDatos.crearTablaBicicleta();
			BaseDatos.insertBicicleta(cod, color, modelo, ubicacion);
			BaseDatos.close();
		}else {
			System.out.println("La bicicleta que has intentado introducir tiene un identificador que ya existe.");
		}
		
		//System.out.println(listaBicis.size());
	}
	
	public static ArrayList<clsBicicleta> getBicisBD() 
	{
		BaseDatos.initBD("RideIt");
		ArrayList<clsBicicleta>List=new ArrayList<clsBicicleta>();
		List = BaseDatos.getAllBicicletas();

		BaseDatos.close();
		
		/*for(clsBicicleta b: pruebaList) 
		{
			System.out.println(b.getBici_id()+b.getColor()+b.getModelo()+b.getUbicacion());
		}*/
		return List;
	}

}
