package LN;

import java.util.ArrayList;

import LD.clsBicicleta;

public class gestorLN {
	
	private static ArrayList<clsBicicleta> listaBicis; 
	
	public static void altaBicicleta(int cod, String color, String modelo, String ubicacion){
		
		clsBicicleta bike =new clsBicicleta(cod, color, modelo, ubicacion);
		
		if(listaBicis == null) 
		{
			listaBicis= new ArrayList<clsBicicleta>();
		}
		
		listaBicis.add(bike);
		
		System.out.println("Bici: "+listaBicis.get(listaBicis.size()-1).getBici_id()); //Prueba
	}

}
