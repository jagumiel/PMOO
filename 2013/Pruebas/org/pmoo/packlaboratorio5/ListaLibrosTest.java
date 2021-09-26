package org.pmoo.packlaboratorio5;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;
public class ListaLibrosTest extends TestCase
{
	private ListaLibros lista1;
	private Libro l1,l2,l3;
	@Before
	public void setUp()
	{
		lista1=new ListaLibros();	
		l1=new Libro("Construcción de software orientado a objetos", "Bertrand Meyer",1);
		l2=new Libro("Cien años de soledad", "Gabriel García Márquez",2);
		l3=new Libro("El hobbit", "JRR Tolkien",3);
	}
	@After
	public void tearDown()
	{
		lista1=null;
	}
	@Test
	public void testListaLibros()
	{
		assertNotNull(lista1);
	}
	@Test
	public void testGetTammano()
	{
		assertEquals(lista1.getTamano(),0);
	}
	@Test
	public void testBuscarLibroPorId()
	{
		lista1.anadirLibro(l1);
		lista1.anadirLibro(l2);
		lista1.anadirLibro(l3);
		assertEquals(lista1.buscarLibroPorId(1),l1);
		assertNull(lista1.buscarLibroPorId(6));
	}
	@Test
	public void testAnadirLibro()
	{
		lista1.anadirLibro(l1);
		lista1.anadirLibro(l2);
		lista1.anadirLibro(l3);
		assertEquals(lista1.getTamano(),3);
	}
	@Test
	public void testEliminarLibro()
	{
		lista1.anadirLibro(l1);
		lista1.anadirLibro(l2);
		lista1.anadirLibro(l3);
		lista1.eliminarLibro(l3);
		assertEquals(lista1.getTamano(),2);
	}
	@Test
	public void testEsta()
	{
		lista1.anadirLibro(l1);
		lista1.anadirLibro(l2);
		assertTrue(lista1.esta(l1));
		assertFalse(lista1.esta(l3));
	}
	@Test
	public void testImprimir()
	{
		assertEquals(0,lista1.getTamano());
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
		}
}