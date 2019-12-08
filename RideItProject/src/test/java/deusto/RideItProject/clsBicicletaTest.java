package deusto.RideItProject;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import LD.clsBicicleta;

public class clsBicicletaTest {

	private clsBicicleta BValida;
	private clsBicicleta BInvalida;
	@Test
	public void test() 
	{
		
		BValida = Mockito.mock(clsBicicleta.class);
		BInvalida = Mockito.mock(clsBicicleta.class);
		
		/*when(BValida.getColor()).thenReturn("normal");
		when(BInvalida.getBici_id()).theReturn(-1);*/
	}
	
	@Test
	public void testsetBicicleta()
	{
		clsBicicleta Bici = new clsBicicleta(0, null, null, null);
		Bici.setBici_id(BValida.getBici_id());
	}

}
