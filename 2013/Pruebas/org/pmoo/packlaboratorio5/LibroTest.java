package org.pmoo.packlaboratorio5;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;
public class LibroTest extends TestCase
{
	Libro l1;
	@Before
	public void setUp()
    {
    	l1=new Libro("El amor dura tres años", "Frederic Beigbeder",4);
    }
    @After
    public void tearDown()
    {
    	l1=null;
    }
    @Test
	public void testGetIdLibro()
    {
    	assertEquals(l1.getIdLibro(),4);
    }
    @Test
	public void testTieneEsteId()
    {
    	assertTrue(l1.tieneEsteId(4));
    	assertFalse(l1.tieneEsteId(6));
    }
    @Test
	public void testImprimir()
	{
		assertNotNull(l1);
		System.out.println("\n===============================================================");
		System.out.println("\nCaso de prueba del método imprimir de la clase Libro");
		System.out.println("\nLa información del libro debería mostrarse de este modo:\n");
		System.out.println("* El amor dura tres años, escrito por Frederic Beigbeder.");
		System.out.println("\nY tu programa lo muestra de este modo:\n");
		l1.imprimir();
		System.out.println("\n===============================================================");
	}
}