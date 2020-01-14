package deusto.RideItProject;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;

import LD.clsAlquiler;
import LD.clsBicicleta;
import LD.clsEstacion;
import LD.clsUsuario;
import LN.gestorLN;

public class clsBicicletaTest {

	/*private clsBicicleta BValida;
	private clsBicicleta BInvalida;
	@Test
	public void test() 
	{
		
		BValida = Mockito.mock(clsBicicleta.class);
		BInvalida = Mockito.mock(clsBicicleta.class);
		
		//when(BValida.getColor()).thenReturn("normal");
		//when(BInvalida.getBici_id()).theReturn(-1);
	}
	
	@Test
	public void testsetBicicleta()
	{
		//clsBicicleta Bici = new clsBicicleta(0, null, null, null);
		//Bici.setBici_id(BValida.getBici_id());
	}
	*/
		@Test
		public void testBicisEstacion() 
		{
			gestorLN.iniciarListas();
			
			clsEstacion estacion = new clsEstacion(7,"Centro",4);
			clsBicicleta b = new clsBicicleta(12, "Roja","Monte","7");
			clsBicicleta c = new clsBicicleta(13, "Roja","Ciudad","7");
			gestorLN.listaEstaciones.add(estacion);
			gestorLN.listaBicis.add(b);
			gestorLN.listaBicis.add(c);
			
			int p = gestorLN.getPlazasDisp(estacion.getIdEstacion());
			System.out.println("Plazas: "+p);
			
			assertEquals(p, estacion.getNumPlazas()-gestorLN.getBicisEstacion(estacion.getIdEstacion()).size());
		}
		
		@Test
		public void testCosteAlquileres() 
		{
			LocalDateTime ini=LocalDateTime.now();
			LocalDateTime fin=ini.plusMinutes(5);
			LocalDateTime fin2=ini.plusMinutes(7);
			clsAlquiler a = new clsAlquiler(2, "aaa",1,ini, fin);
			clsAlquiler b = new clsAlquiler(3, "aaa",2,ini, fin2);
			ArrayList<clsAlquiler>lista=new ArrayList<clsAlquiler>();
			lista.add(a); lista.add(b);
			
			int resultado = (int) gestorLN.getCosteAlquileres(lista, 0.5);
			
			assertEquals(resultado,6);
		}
		
		@Test
		public void testComprobarEstacion() 
		{
			gestorLN.iniciarListas();
			clsEstacion estacion = new clsEstacion(7,"Centro",2);
			clsBicicleta b = new clsBicicleta(12, "Roja","Monte","7");
			clsBicicleta c = new clsBicicleta(13, "Roja","Ciudad","7");
			gestorLN.listaEstaciones.add(estacion);
			gestorLN.listaBicis.add(b); 
			gestorLN.listaBicis.add(c);
			
			assertFalse(gestorLN.comprobarEstacion(7));
		}
		
		@Test
		public void TestDispBicis() 
		{
			gestorLN.listaAlquileres.clear();
			
			assertEquals(gestorLN.bicisDisp().size(),gestorLN.listaBicis.size());
		}
		
		@Test
		public void TestAutenticacion() 
		{
			clsUsuario u =new clsUsuario("jorge","echeverria","123","adminTestU","psw");
			gestorLN.listaUsuarios.add(u);
			
			assertTrue(gestorLN.autenticacion(u.getUser(), u.getPasswaord()));
		}
		
		@Test
		public void TestGetBicisBD() 
		{
			gestorLN.iniciarListas();
			
			assertEquals(gestorLN.listaBicis.size(), gestorLN.getBicisBD().size());
		}
		
		@Test
		public void TestGetUsuariosBD() 
		{
			gestorLN.iniciarListas();
			
			assertEquals(gestorLN.listaUsuarios.size(), gestorLN.getUsuariosBD().size());
		}
		
		@Test
		public void TestGetEstacionesBD() 
		{
			gestorLN.iniciarListas();
			
			assertEquals(gestorLN.listaEstaciones.size(), gestorLN.getEstacionBD().size());
		}
		
		@Test
		public void TestGetAlquileresBD() 
		{
			gestorLN.iniciarListas();
			
			assertEquals(gestorLN.listaAlquileres.size(), gestorLN.getAlquileresBD().size());
		}
		
		@Test
		public void TestEstadoUser() 
		{
			LocalDateTime ini=LocalDateTime.now();
			clsAlquiler a = new clsAlquiler(2, "7654",1,ini, null);
			gestorLN.listaAlquileres.add(a);
			
			assertTrue(gestorLN.estadoUser(a.getUser_dni()));
		}
		
		@Test
		public void TestDuracion() 
		{
			LocalDateTime ini=LocalDateTime.now();
			LocalDateTime fin=ini.plusMinutes(4);
			clsAlquiler a = new clsAlquiler(2, "7654",1,ini, fin);
			assertEquals(a.getDuracion(), 4);
		}
		
		@Test
		public void TestAlquileresUser() 
		{
			LocalDateTime ini=LocalDateTime.now();
			LocalDateTime fin=ini.plusMinutes(4);
			clsAlquiler a = new clsAlquiler(2, "7654test",1,ini, fin);
			gestorLN.listaAlquileres.add(a);
			
			assertEquals(gestorLN.getAlquileresUser(a.getUser_dni()).size(),1);
		}
		
		@Test
		public void TestGetUsuario() 
		{
			clsUsuario u =new clsUsuario("jorge","echeverria","123","adminTestU","psw");
			gestorLN.listaUsuarios.add(u);
			
			assertEquals(gestorLN.getUsuario("adminTestU").getDni(),"123");
		}
	

}
