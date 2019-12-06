package deusto.RideItProject;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import LD.clsBicicleta;
import LN.gestorLN;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    
 	public void testAltaBici() {
		
		boolean a = gestorLN.altaBicicleta(6, "Azul", "Mountain", "Monte Ulia");		       	
    	assertFalse(a); 
    	
    	boolean b = gestorLN.altaBicicleta(200, "Rojo", "Mountain", "Errotaburu");		       	
    	assertTrue(b); 
    	    	
	}
 	
    public void testApp()
    {
        assertTrue( true );
    }
    
    
   
}
