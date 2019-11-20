import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import LD.clsBicicleta;
import LD.clsUsuario;
import LD.clsAlquiler;
import LN.gestorLN;

public class clsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hola, esto es un proyecto de bicicletas. Para clase.");
		
		gestorLN.altaBicicleta(7, "Rojo", "Standard", "Boulevard");
		gestorLN.altaBicicleta(5, "Amarillo", "Tandem", "Plaza gipuzkoa");
		gestorLN.altaBicicleta(6, "Azul", "Mountain", "Monte Ulia");
		
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
		
		
		clsAlquiler a = new clsAlquiler(1, "dni1",1);
		clsAlquiler b =new clsAlquiler(2, "dni2",2);
		
		gestorLN.altaAlquiler(a.getBici_id(), a.getUser_dni());
		gestorLN.altaAlquiler(b.getBici_id(), b.getUser_dni());
		
		ArrayList<clsAlquiler>alq = new ArrayList<clsAlquiler>();
		alq= gestorLN.getAlquileresBD();
		System.out.println(alq.size());
		
		for(clsAlquiler item:alq) {
			System.out.println(item.getIdAlquiler()+"; "+item.getBici_id()+"; "+item.getUser_dni()+
			"FECHAS: "+item.getFecha_inicio()+item.getFecha_fin()+ " DUR: "+item.getDuracion());
		}
		
		//FALTA hacer que se modifique el registro de alquiler cuando se deje la bici.
			//HACER funciones de coger bici
			//HACER funciones de dejar bici
		
		
		
	}

}
