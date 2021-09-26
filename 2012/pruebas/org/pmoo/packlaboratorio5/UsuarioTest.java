package org.pmoo.packlaboratorio5;

import junit.framework.TestCase;

public class UsuarioTest extends TestCase
{

	Usuario usuario;
	Libro l1,l2;

	protected void setUp()
	{
		usuario= new Usuario("Lola Mento",1);
		l1=new Libro("El Cuaderno Dorado", "Doris Lessing",1);
		l2=new Libro("Rayuela", "Julio Cortazar",2);
	}

	protected void tearDown() {
		usuario=null;
		l1=null;
		l2=null;
	}

	
	public void testGetMaxLibros()	
	{
		assertEquals(usuario.getMaxLibros(),3);	
	}
	
	
	public void testUsuario()
	{
		assertNotNull(usuario);
	}
	
	public void testGetNombreCompleto()
	{
		assertEquals(usuario.getNombreCompleto(), "Lola Mento");
	}
	
	public void testGetIdUsuario()
	{
		assertEquals(usuario.getIdUsuario(),1);
	}
	
	public void testCuantosLibrosTiene()
	{
		usuario.anadirLibro(l1);
		assertEquals(usuario.cuantosLibrosTiene(),1);
	}
		
	public void testAnadirLibro()
	{
		usuario.anadirLibro(l1);
		usuario.anadirLibro(l2);
		assertEquals(usuario.cuantosLibrosTiene(),2);
	}
	
	public void testQuitarLibro()
	{
		usuario.anadirLibro(l1);
		usuario.anadirLibro(l2);
		usuario.quitarLibro(l1);
		assertEquals(usuario.cuantosLibrosTiene(),1);
	}
		
	public void testLoTieneEnPrestamo()
	{
		usuario.anadirLibro(l2);
		assertTrue(usuario.loTieneEnPrestamo(l2));
		assertFalse(usuario.loTieneEnPrestamo(l1));
	}
	

	public void testImprimir()
	{	
		assertNotNull(usuario);
		
		System.out.println("\n===============================================================");
		System.out.println("\nCaso de prueba del método imprimir de la clase Usuario (0 libros)");
		System.out.println("\nLa información del usuario debería mostrarse de este modo:\n");
		System.out.println("ID: 1: Lola Mento");
		System.out.println("---> No tiene libros en préstamo.");
		
		System.out.println("\nY tu programa lo muestra de este modo:\n");
		usuario.imprimir();
		System.out.println("\n===============================================================");
	
		usuario.anadirLibro(l1);
		
		System.out.println("\nCaso de prueba del método imprimir de la clase Usuario (1 libro)");
		System.out.println("\nLa información del usuario debería mostrarse de este modo:\n");
		System.out.println("ID: 1: Lola Mento");
		System.out.println("---> Tiene el siguiente título en préstamo:");
		System.out.println("* El Cuaderno Dorado, escrito por Doris Lessing.");

		System.out.println("\nY tu programa lo muestra de este modo:\n");
		usuario.imprimir();
		System.out.println("\n===============================================================");
	
		usuario.anadirLibro(l2);		

		System.out.println("\nCaso de prueba del método imprimir de la clase Usuario (2 libros)");
		System.out.println("\nLa información del usuario debería mostrarse de este modo:\n");
		System.out.println("ID: 1: Lola Mento");
		System.out.println("---> Tiene los siguientes 2 títulos en préstamo:");
		System.out.println("* El Cuaderno Dorado, escrito por Doris Lessing.");
		System.out.println("* Rayuela, escrito por Julio Cortazar.");
		
		System.out.println("\nY tu programa lo muestra de este modo:\n");
		usuario.imprimir();
		System.out.println("\n===============================================================");

		//fail("Mira los mensajes que se muestran en la consola del sistema, y si todo ha ido bien elimina o comenta este fail");
	}

}
