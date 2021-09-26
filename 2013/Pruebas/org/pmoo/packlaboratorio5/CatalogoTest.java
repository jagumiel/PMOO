package org.pmoo.packlaboratorio5;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;
public class CatalogoTest extends TestCase
{
	private Libro l1;
	private Libro l2;
	private Libro l3;
	private Libro l4;
	private Usuario e1;
	private Usuario e2;
	@Before
	public void setUp()
	{
		l1 = new Libro("Construcción de software orientado a objetos", "Bertrand Meyer",1);
		l2 = new Libro("Cien años de soledad", "Gabriel García Márquez",2); 
		l3 = new Libro("El hobbit", "JRR Tolkien",3);
		l4=  new Libro("El perfume", "Patrick Suskind",4);
		e1=new Usuario("Kepa Sarasola", 1);	
	    e2=new Usuario("Armando Guerra", 2);
		Catalogo.getCatalogo().catalogarLibro(l1);
		Catalogo.getCatalogo().catalogarLibro(l2);
		Catalogo.getCatalogo().catalogarLibro(l3);
		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(e1);
		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(e2);
	}
	@After
	public void tearDown()
	{
		l1 = null;
		l2 = null;
		l3 = null;
		e1=null;
		e2=null;
		Catalogo.getCatalogo().resetear();
	}
	@Test
	public void testGetTamano()
	{
		assertEquals(Catalogo.getCatalogo().getTamano(),3);
	}
	@Test
	public void testBuscarLibroPorId()
	{
		assertEquals(Catalogo.getCatalogo().buscarLibroPorId(1),l1);
	}
	@Test
	public void testPrestarLibro()
	{
		System.out.println("En el caso de prueba de prestar libro la informacion deberia mostrarse de la siguiente manera:");
		System.out.println("El usuario no existe.");
		System.out.println("El libro se ha prestado al usuario.");
		System.out.println("El libro se ha prestado al usuario.");
		System.out.println("El libro se ha prestado al usuario.");
		System.out.println("El usuario ha alcanzado el limite de prestados.");
		System.out.println("El libro ya esta prestado.");
		System.out.println("El libro no existe.");
		System.out.println("Se muestra:" +
				"###########################################################################################");
		Catalogo.getCatalogo().prestarLibro(1,3);
		Catalogo.getCatalogo().prestarLibro(1,1);
		Catalogo.getCatalogo().prestarLibro(2,1);
		Catalogo.getCatalogo().prestarLibro(3,1);
		assertTrue(ListaUsuarios.getListaUsuarios().buscarUsuarioPorId(1).haAlcanzadoElMaximo());
		Catalogo.getCatalogo().catalogarLibro(l4);
		Catalogo.getCatalogo().prestarLibro(4,1);
		Catalogo.getCatalogo().prestarLibro(2,2);
		Catalogo.getCatalogo().prestarLibro(5,2);
	}
	@Test
	public void testDevolverLibro()
	{
		Catalogo.getCatalogo().prestarLibro(1,1);
		assertTrue(ListaUsuarios.getListaUsuarios().buscarUsuarioPorId(1).loTieneEnPrestamo(l1));
		Catalogo.getCatalogo().devolverLibro(1);
		assertTrue(ListaUsuarios.getListaUsuarios().buscarUsuarioPorId(1).loTieneEnPrestamo(l1));
		Catalogo.getCatalogo().prestarLibro(6,1);
	}
	@Test
	public void testCatalogarLibro()
	{
		Catalogo.getCatalogo().catalogarLibro(l4);
		assertEquals(Catalogo.getCatalogo().getTamano(),4);
		System.out.println("En el caso de prueba de Catalogar libro la informacion deberia mostrarse de la siguiente manera:");
		System.out.println("El libro ya estaba catalogado.");
		System.out.println("Se muestra:");
		Catalogo.getCatalogo().catalogarLibro(l1);
	}
	@Test
	public void testDescatalogarLibro()
	{
		System.out.println("En el caso de prueba de Descatalogar libro la informacion deberia mostrarse de la siguiente manera:");
		System.out.println("El libro no existe.");
		Catalogo.getCatalogo().descatalogarLibro(1);
		assertEquals(Catalogo.getCatalogo().getTamano(),2);
		Catalogo.getCatalogo().descatalogarLibro(1);
	}
	@Test
	public void testimprimir()
	{
		assertEquals(3,Catalogo.getCatalogo().getTamano());
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
		Catalogo.getCatalogo().descatalogarLibro(1);
		Catalogo.getCatalogo().descatalogarLibro(2);
		Catalogo.getCatalogo().descatalogarLibro(3);
		assertEquals(0,Catalogo.getCatalogo().getTamano());	
	}
}