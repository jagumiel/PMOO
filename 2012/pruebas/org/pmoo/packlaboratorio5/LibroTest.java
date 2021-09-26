package org.pmoo.packlaboratorio5;

import junit.framework.TestCase;

public class LibroTest extends TestCase
{
	Libro l1;
	
    protected void setUp()
    {
    	l1=new Libro("El amor dura tres años", "Frederic Beigbeder",'4');
    }
    
    protected void tearDown()
    {
    	l1=null;
    }

    
    public void testGetTitulo()
    {
    	assertEquals(l1.getTitulo(), "El amor dura tres años");
    }
    
    public void testGetAutor()
    {
    	assertEquals(l1.getAutor(), "Frederic Beigbeder");
    }
    
    public void testGetIdLibro()
    {
    	assertEquals(l1.getIdLibro(),'4');
    }
       
    
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
		
		//fail("Mira los mensajes que se muestran en la consola del sistema, y si todo ha ido bien elimina o comenta este fail");
		//No hay fail, el resultado es correcto.
		}
}
