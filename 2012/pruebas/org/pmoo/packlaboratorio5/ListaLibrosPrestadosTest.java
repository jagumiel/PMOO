package org.pmoo.packlaboratorio5;

import junit.framework.TestCase;

public class ListaLibrosPrestadosTest extends TestCase
{

	private ListaLibrosPrestados lista1;
	private Libro l1,l2,l3;
	
	protected void setUp()
	{
		lista1=new ListaLibrosPrestados();	
		l1=new Libro("Construcción de software orientado a objetos", "Bertrand Meyer",1);
		l2=new Libro("Cien años de soledad", "Gabriel García Márquez",2);
		l3=new Libro("El hobbit", "JRR Tolkien",3);
	}

	protected void tearDown()
	{
		lista1=null;
		l1=null;
		l2=null;
		l3=null;
	}
	
	public void testGetTamano()
	{
		lista1.anadirLibro(l1);
		assertEquals(lista1.getTamano(),1);
		lista1.anadirLibro(l2);
		assertEquals(lista1.getTamano(),2);
		lista1.anadirLibro(l3);
		assertEquals(lista1.getTamano(),3);
	}
	
	public void testEsta()
	{
		lista1.anadirLibro(l1);
		lista1.anadirLibro(l2);
		lista1.anadirLibro(l3);
		assertTrue(lista1.esta(l1));
		assertTrue(lista1.esta(l2));
		assertTrue(lista1.esta(l3));
		
		lista1.eliminarLibro(l2);
		assertTrue(lista1.esta(l1));
		assertFalse(lista1.esta(l2));
		assertTrue(lista1.esta(l3));
	}
	
	
	public void testAnadirLibro()
	{
		lista1.anadirLibro(l1);
		lista1.anadirLibro(l3);
		assertEquals(lista1.getTamano(),2);
	}
	
	
	public void testEliminarLibro()
	{
		lista1.anadirLibro(l1);
		lista1.anadirLibro(l2);
		lista1.anadirLibro(l3);
		assertEquals(lista1.getTamano(),3);
		lista1.eliminarLibro(l1);
		assertEquals(lista1.getTamano(),2);
		lista1.eliminarLibro(l2);
		lista1.eliminarLibro(l3);
		assertEquals(lista1.getTamano(),0);
	}
	
	
	public void testImprimir()
	{
		assertEquals(0,ListaUsuarios.getListaUsuarios().getTamano());
			
		lista1.anadirLibro(l1);
		lista1.anadirLibro(l2);
		lista1.anadirLibro(l3);
			
		System.out.println("\n===============================================================");
		System.out.println("\nCaso de prueba del método imprimir de la clase ListaLibrosPrestados");
		System.out.println("\nLa información de la lista de libros debería mostrarse de este modo:\n");
		System.out.println("* Construcción de software orientado a objetos, escrito por Bertrand Meyer.");
		System.out.println("* Cien años de soledad, escrito por Gabriel García Márquez.");
		System.out.println("* El hobbit, escrito por JRR Tolkien.");
		
		System.out.println("\nY tu programa lo muestra de este modo:\n");
		lista1.imprimir();
		System.out.println("\n===============================================================");
	
		//fail("Mira los mensajes que se muestran en la consola del sistema, y si todo ha ido bien elimina o comenta este fail");
		//Funciona.
	}
}