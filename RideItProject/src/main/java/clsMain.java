import java.util.ArrayList;

import LD.clsBicicleta;
import LD.clsUsuario;
import LN.gestorLN;

public class clsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hola, esto es un proyecto de bicicletas. Para clase.");
		
		gestorLN.altaBicicleta(1, "Rojo", "Standard", "Boulevard");
		gestorLN.altaBicicleta(2, "Amarillo", "Tandem", "Plaza gipuzkoa");
		gestorLN.altaBicicleta(4, "Azul", "Mountain", "Monte Ulia");
		
		/*ArrayList<clsBicicleta>lista2 = new ArrayList<clsBicicleta>();
		lista2 = gestorLN.getBicisBD();
		
		for(clsBicicleta b: lista2) {
			System.out.println(b.getBici_id()+": "+b.getModelo()+", "+ b.getColor());
		}/*
		
		/*
		gestorLN.altaUsuario("IGNACIO", "SAEZ", "7255296T", "igna", "aaaa2");
		gestorLN.altaUsuario("Martin", "Odegaard", "21212121R", "martin", "134a2");
		
		ArrayList<clsUsuario>lista = new ArrayList<clsUsuario>();
		lista = gestorLN.getUsuariosBD();
		
		for(clsUsuario u: lista) {
			System.out.println(u.getDni()+": "+u.getNombre());
		}*/
		
		
		
		
		
	}

}
