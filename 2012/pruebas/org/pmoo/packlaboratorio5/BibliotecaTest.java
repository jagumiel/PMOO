package org.pmoo.packlaboratorio5;

import junit.framework.TestCase;

public class BibliotecaTest extends TestCase
{
	protected void setUp()
	{
		Biblioteca.getBiblioteca().catalogarLibro("Construcción de software orientado a objetos", "Bertrand Meyer",1);
		Biblioteca.getBiblioteca().catalogarLibro("Cien años de soledad", "Gabriel García Márquez",2); 
		Biblioteca.getBiblioteca().catalogarLibro("El hobbit", "JRR Tolkien",3);
		Biblioteca.getBiblioteca().catalogarLibro("El perfume", "Patrick Suskind",4);
	
		Biblioteca.getBiblioteca().darDeAltaUsuario("Armando Guerra", 1);
		Biblioteca.getBiblioteca().darDeAltaUsuario("Kepa Sarasola", 2);
		Biblioteca.getBiblioteca().darDeAltaUsuario("Lola Mento", 3);
	}
	
	protected void tearDown()
	{
		Biblioteca.getBiblioteca().resetear();				
	}
	
	//TODO realizar las pruebas de los métodos de la clase Biblioteca
	
	public void testGetBiblioteca()
	{
		assertNotNull(Biblioteca.getBiblioteca());
	}
	
	
	public void testDarDeAltaUsuario()
	{
		Usuario u1;
		
		u1=ListaUsuarios.getListaUsuarios().buscarUsuarioPorId(1);
		assertNotNull(u1);
		assertEquals(u1.getIdUsuario(),1);
		assertEquals(u1.getNombreCompleto(),"Armando Guerra");
		Biblioteca.getBiblioteca().darDeAltaUsuario("Pancho Colate",1);
		assertEquals(ListaUsuarios.getListaUsuarios().getTamano(),3);
		
		u1=ListaUsuarios.getListaUsuarios().buscarUsuarioPorId(4);
		assertNull(u1);
		Biblioteca.getBiblioteca().darDeAltaUsuario("Pancho Colate",4);
		u1=ListaUsuarios.getListaUsuarios().buscarUsuarioPorId(4);
		assertNotNull(u1);
		assertEquals(u1.getNombreCompleto(),"Pancho Colate");
		assertEquals(ListaUsuarios.getListaUsuarios().getTamano(),4);
	}
	
	public void testDarDeBajaUsuario()
	{
		Usuario u1;
		
		u1=ListaUsuarios.getListaUsuarios().buscarUsuarioPorId(1);
		assertNotNull(u1);
		assertEquals(u1.getIdUsuario(),1);
		assertEquals(u1.getNombreCompleto(),"Armando Guerra");
		assertEquals(ListaUsuarios.getListaUsuarios().getTamano(),3);
		Biblioteca.getBiblioteca().darDeBajaUsuario(1);
		assertEquals(ListaUsuarios.getListaUsuarios().getTamano(),2);
	}
	
	public void testCatalogarLibro()
	{
		Libro l1;
		
		l1=Catalogo.getCatalogo().buscarLibroPorId(3);
		assertNotNull(l1);
		assertEquals(l1.getIdLibro(),3);
		assertEquals(l1.getTitulo(),"El hobbit");
		assertEquals(l1.getAutor(),"JRR Tolkien");
		Biblioteca.getBiblioteca().catalogarLibro("La edad de la razón","Thomas Paine", 1);
		assertEquals(Catalogo.getCatalogo().getTamano(),4);
		
		l1=Catalogo.getCatalogo().buscarLibroPorId(5);
		assertNull(l1);
		l1=new Libro("1984", "George Orwell", 5);
		Biblioteca.getBiblioteca().catalogarLibro(l1.getTitulo(),l1.getAutor(), l1.getIdLibro());
		assertEquals(Catalogo.getCatalogo().getTamano(),5);
	}
	
	public void testDescatalogarLibro()
	{
		Libro l1;
		
		l1=Catalogo.getCatalogo().buscarLibroPorId(1);
		assertNotNull(l1);
		assertEquals(l1.getIdLibro(),1);
		assertEquals(l1.getTitulo(),"Construcción de software orientado a objetos");
		assertEquals(l1.getAutor(),"Bertrand Meyer");
		assertEquals(Catalogo.getCatalogo().getTamano(),4);
		Biblioteca.getBiblioteca().descatalogarLibro(1);
		assertEquals(Catalogo.getCatalogo().getTamano(),3);
	}
	
	public void testResetear()
	{
		assertEquals(Catalogo.getCatalogo().getTamano(),4);
		assertEquals(ListaUsuarios.getListaUsuarios().getTamano(),3);
		Biblioteca.getBiblioteca().resetear();
		assertEquals(Catalogo.getCatalogo().getTamano(),0);
		assertEquals(ListaUsuarios.getListaUsuarios().getTamano(),0);
	}
	
	
	
 	public void testImprimirEstado()
	{
		assertNotNull(Biblioteca.getBiblioteca());
		
		Biblioteca.getBiblioteca().prestarLibro(1, 1);
		Biblioteca.getBiblioteca().prestarLibro(2, 3);
		Biblioteca.getBiblioteca().prestarLibro(3, 3);
		Biblioteca.getBiblioteca().prestarLibro(4, 3);
		
		System.out.println("\n===============================================================");
		System.out.println("\nCaso de prueba del método imprimir de la clase Biblioteca");
		System.out.println("\nLa información de la biblioteca debería mostrarse de este modo:\n");
		
		System.out.println("------------------------------------");
		System.out.println("Libros disponibles en la biblioteca.");
		System.out.println("------------------------------------");
		
		System.out.println("El catálogo tiene un total de 4 títulos.");
		System.out.println("* Construcción de software orientado a objetos, escrito por Bertrand Meyer.");
		System.out.println("* Cien años de soledad, escrito por Gabriel García Márquez.");
		System.out.println("* El hobbit, escrito por JRR Tolkien.");
		System.out.println("* El perfume, escrito por Patrick Suskind.");
		
		System.out.println("-------------------------------------");
		System.out.println("Listado de usuarios de la biblioteca.");
		System.out.println("-------------------------------------");
		
		System.out.println("Hay un total de 3 usuarios.");
		System.out.println("ID: 1: Armando Guerra");
		System.out.println("---> Tiene el siguiente título en préstamo:");
		System.out.println("* Construcción de software orientado a objetos, escrito por Bertrand Meyer.");
		System.out.println("ID: 2: Kepa Sarasola");
		System.out.println("---> No tiene libros en préstamo.");
		System.out.println("ID: 3: Lola Mento");
		System.out.println("---> Tiene los siguientes 3 títulos en préstamo:");
		System.out.println("* Cien años de soledad, escrito por Gabriel García Márquez.");
		System.out.println("* El hobbit, escrito por JRR Tolkien.");
		System.out.println("* El perfume, escrito por Patrick Suskind.");
		
		System.out.println("\nY tu programa lo muestra de este modo\n");
		Biblioteca.getBiblioteca().imprimirEstado();
		System.out.println("\n===============================================================");
		
		//fail("Mira los mensajes que se muestran en la consola del sistema, y si todo ha ido bien elimina o comenta este fail");
	}


}

