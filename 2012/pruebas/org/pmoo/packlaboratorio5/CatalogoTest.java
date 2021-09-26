
package org.pmoo.packlaboratorio5;

import junit.framework.TestCase;

public class CatalogoTest extends TestCase
{
	
	private Libro l1;
	private Libro l2;
	private Libro l3;
	
	protected void setUp()
	{
		l1 = new Libro("Construcción de software orientado a objetos", "Bertrand Meyer",1);
		l2 = new Libro("Cien años de soledad", "Gabriel García Márquez",2); 
		l3 = new Libro("El hobbit", "JRR Tolkien",3);
	}
	
	protected void tearDown()
	{
		l1 = null;
		l2 = null;
		l3 = null;
		Catalogo.getCatalogo().resetear();
	}
	
	
	public void testGetCatalogo()
	{
		assertNotNull(Catalogo.getCatalogo());
	}
	
	public void testGetTamano()
	{
		Catalogo.getCatalogo().anadirLibro(l1);
		Catalogo.getCatalogo().anadirLibro(l2);
		Catalogo.getCatalogo().anadirLibro(l3);
		assertEquals(Catalogo.getCatalogo().getTamano(), 3);
	}
	
	public void testBuscarLibroPorId()
	{
		Catalogo.getCatalogo().anadirLibro(l1);
		assertEquals(Catalogo.getCatalogo().buscarLibroPorId(1),l1);
	}
	
	public void testAnadirLibro()
	{
		Catalogo.getCatalogo().anadirLibro(l1);
		assertEquals(Catalogo.getCatalogo().buscarLibroPorId(l1.getIdLibro()),l1);
	}
	
	public void testEliminarLibro()
	{
		Catalogo.getCatalogo().anadirLibro(l1);
		assertEquals(Catalogo.getCatalogo().getTamano(), 1);
		Catalogo.getCatalogo().eliminarLibro(l1);
		assertEquals(Catalogo.getCatalogo().getTamano(), 0);
		assertNull(Catalogo.getCatalogo().buscarLibroPorId(1));
	}
	
	public void testResetear()
	{
		Catalogo.getCatalogo().anadirLibro(l1);
		Catalogo.getCatalogo().resetear();
		assertNull(Catalogo.getCatalogo().buscarLibroPorId(1));
	}
	
			
	public void testImprimir()
	{
		assertEquals(0,Catalogo.getCatalogo().getTamano());
		
		Catalogo.getCatalogo().anadirLibro(l1);
		Catalogo.getCatalogo().anadirLibro(l2);
		Catalogo.getCatalogo().anadirLibro(l3);
		
		System.out.println("\n===============================================================");
		System.out.println("\nCaso de prueba del método imprimir de la clase Catalogo");
		System.out.println("\nLa información de la lista de usuarios debería mostrarse de este modo:\n");
		System.out.println("El catálogo tiene un total de 3 títulos.");
		System.out.println("* Construcción de software orientado a objetos, escrito por Bertrand Meyer.");
		System.out.println("* Cien años de soledad, escrito por Gabriel García Márquez.");
		System.out.println("* El hobbit, escrito por JRR Tolkien.");

		System.out.println("\nY tu programa lo muestra de este modo:");
		Catalogo.getCatalogo().imprimir();
		System.out.println("\n===============================================================");
		
		Catalogo.getCatalogo().eliminarLibro(l1);
		Catalogo.getCatalogo().eliminarLibro(l2);
		Catalogo.getCatalogo().eliminarLibro(l3);
		assertEquals(0,Catalogo.getCatalogo().getTamano());	
		
		//fail("Mira los mensajes que se muestran en la consola del sistema, y si todo ha ido bien elimina o comenta este fail");
		//No hay fail, funciona.
	}	
}



	
