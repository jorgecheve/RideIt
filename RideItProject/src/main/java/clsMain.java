import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import LD.clsBicicleta;
import LD.clsEstacion;
import LD.clsUsuario;
import LD.clsAlquiler;
import LN.gestorLN;
/**
 * 
 * @author Jorge Echeverria Ignacio Sáez Ignacio Garbizu Mikel Aguiriano
 * La clase clsMain es la clase encargada de lanzar la aplicación, cargando una serie 
 * de bicicletas y usuarios en la base de datos
 */

public class clsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hola, esto es un proyecto de bicicletas. Para clase.");
		
		gestorLN.altaBicicleta(7, "Rojo", "Standard", "Boulevard");
		gestorLN.altaBicicleta(5, "Amarillo", "Tandem", "Plaza gipuzkoa");
		gestorLN.altaBicicleta(6, "Azul", "Mountain", "Monte Ulia");
		
		gestorLN.altaEstacion(1, "Avenida de Zarautz");
		
		gestorLN.altaUsuario("IGNACIO", "SAEZ", "7255296T", "igna", "aaaa2");
		gestorLN.altaUsuario("Martin", "Odegaard", "21212121R", "martin", "134a2");
		
		
		/*
		ArrayList<clsEstacion>lista2 = new ArrayList<clsEstacion>();
		lista2 = gestorLN.getEstacionBD();
		
		
		for(clsEstacion e: lista2) 
		{
			System.out.println(e.getIdEstacion()+": "+e.getLocalizacion());
			System.out.println("Hola");
		}
		
		/*ArrayList<clsBicicleta>lista2 = new ArrayList<clsBicicleta>();
		lista2 = gestorLN.getBicisBD();
		
		for(clsBicicleta b: lista2) {
			System.out.println(b.getBici_id()+": "+b.getModelo()+", "+ b.getColor());
		}
		
		
		
		
		
		
		ArrayList<clsUsuario>lista = new ArrayList<clsUsuario>();
		lista = gestorLN.getUsuariosBD();
		
		for(clsUsuario u: lista) {
			System.out.println(u.getDni()+": "+u.getNombre());
		}*/
		
		/*
		clsAlquiler a = new clsAlquiler(1, "dni1",1);
		clsAlquiler b =new clsAlquiler(2, "dni2",2);
		
		gestorLN.altaAlquiler(a.getBici_id(), a.getUser_dni());
		gestorLN.altaAlquiler(b.getBici_id(), b.getUser_dni());
		
		ArrayList<clsAlquiler>alq = new ArrayList<clsAlquiler>();
		alq= gestorLN.getAlquileresBD();
		System.out.println(alq.size());
		
		for(clsAlquiler item:alq) {
			System.out.println(item.getIdAlquiler()+"; "+item.getBici_id()+"; "+item.getUser_dni()+
			" FECHAS: "+item.getFecha_inicio()+item.getFecha_fin()+ " DUR: "+item.getDuracion());
		}
		
		System.out.println("Que usuario eres (introduce DNI): ");
		ArrayList<clsUsuario>User = new ArrayList<clsUsuario>();
		User=gestorLN.getUsuariosBD();
		System.out.println(User.size());
		String DNI;
	
		for(clsUsuario item: User)
		{
			System.out.println("/nDNI: " +item.getDni());
			
		}
		Scanner sc = new Scanner(System.in);
		DNI=sc.nextLine();
		
		System.out.println("Que bici quieres(introduce Id): ");
		ArrayList<clsBicicleta>Bici = new ArrayList<clsBicicleta>();
		Bici=gestorLN.getBicisBD();
		System.out.println(Bici.size());
		int ID=0;
		for(clsBicicleta item: Bici)
		{
			System.out.println("ID: " +item.getBici_id());
			
		}
		ID=sc.nextInt();
		gestorLN.cogerBici(DNI, ID);
		System.out.println(alq.size());
		*/
		
		//FALTA hacer que se modifique el registro de alquiler cuando se deje la bici.
			//HACER funciones de coger bici
			//HACER funciones de dejar bici
		

		
		
		
		
		
	}

}
