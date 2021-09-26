package org.pmoo.packlaboratorio5;

import junit.framework.TestCase;

public class ListaUsuariosTest extends TestCase
{
	
	private Usuario u1;
	private Usuario u2;
	private Usuario u3;
	
	protected void setUp()
	{
		u1 = new Usuario("Armando Guerra", 1);
		u2 = new Usuario("Kepa Sarasola", 2); 
		u3 = new Usuario("Lola Mento", 3);
	}
	
	protected void tearDown()
	{
		u1 = null;
		u2 = null;
		u3 = null;
		ListaUsuarios.getListaUsuarios().resetear();
	}
		
	
	public void testGetListaUsuarios()
	{
		assertNotNull(ListaUsuarios.getListaUsuarios());
	}
	
	public void testGetTamano()
	{
		ListaUsuarios.getListaUsuarios().anadirUsuario(u1);
		ListaUsuarios.getListaUsuarios().anadirUsuario(u2);
		ListaUsuarios.getListaUsuarios().anadirUsuario(u3);
		assertEquals(ListaUsuarios.getListaUsuarios().getTamano(),3);
	}
	
	public void testBuscarUsuarioPorId()
	{
		ListaUsuarios.getListaUsuarios().anadirUsuario(u1);
		ListaUsuarios.getListaUsuarios().anadirUsuario(u2);
		ListaUsuarios.getListaUsuarios().anadirUsuario(u3);
		assertEquals(ListaUsuarios.getListaUsuarios().buscarUsuarioPorId(1),u1);
		assertEquals(ListaUsuarios.getListaUsuarios().buscarUsuarioPorId(2),u2);
		assertEquals(ListaUsuarios.getListaUsuarios().buscarUsuarioPorId(3),u3);
	}
	
	public void testAnadirUsuario()
	{
		ListaUsuarios.getListaUsuarios().anadirUsuario(u1);
		assertEquals(ListaUsuarios.getListaUsuarios().buscarUsuarioPorId(1),u1);
	}
	
	public void testEliminarUsuario ()
	{
		ListaUsuarios.getListaUsuarios().anadirUsuario(u1);
		ListaUsuarios.getListaUsuarios().anadirUsuario(u2);
		assertEquals(ListaUsuarios.getListaUsuarios().getTamano(),2);
		ListaUsuarios.getListaUsuarios().eliminarUsuario(u1);
		assertEquals(ListaUsuarios.getListaUsuarios().getTamano(),1);
	}
	
	public void testQuienLoTienePrestado()
	{
		Libro l1=new Libro("Cumbres borrascosas","Emily Bronte",1);
		Libro l2=new Libro("Sentido y sensibilidad","Jane Austen",2);
		ListaUsuarios.getListaUsuarios().anadirUsuario(u1);
		ListaUsuarios.getListaUsuarios().anadirUsuario(u2);
		u1.anadirLibro(l1);
		u2.anadirLibro(l2);
		assertEquals(ListaUsuarios.getListaUsuarios().quienLoTienePrestado(l1),u1);
		assertEquals(ListaUsuarios.getListaUsuarios().quienLoTienePrestado(l2),u2);
	}
	
	public void testResetear()
	{
		ListaUsuarios.getListaUsuarios().anadirUsuario(u1);
		ListaUsuarios.getListaUsuarios().anadirUsuario(u2);
		ListaUsuarios.getListaUsuarios().anadirUsuario(u3);
		assertEquals(ListaUsuarios.getListaUsuarios().getTamano(),3);
		ListaUsuarios.getListaUsuarios().resetear();
		assertEquals(ListaUsuarios.getListaUsuarios().getTamano(),0);
	}
	
	public void testImprimir()
	{
			
		assertEquals(0, ListaUsuarios.getListaUsuarios().getTamano());
		Libro l1=new Libro("Cumbres borrascosas","Emily Bronte",1);
		Libro l2=new Libro("Sentido y sensibilidad","Jane Austen",2);
		Libro l3 = new Libro("El hobbit", "JRR Tolkien",3);
		
		u1.anadirLibro(l1);
		u3.anadirLibro(l2);
		u3.anadirLibro(l3);
		
		ListaUsuarios.getListaUsuarios().anadirUsuario(u1);
		ListaUsuarios.getListaUsuarios().anadirUsuario(u2);
		ListaUsuarios.getListaUsuarios().anadirUsuario(u3);
			
		System.out.println("\n===============================================================");
		System.out.println("\nCaso de prueba del método imprimir de la clase ListaUsuarios");
		System.out.println("\nLa información de la lista de usuarios debería mostrarse de este modo:\n");
		
		System.out.println("Hay un total de 3 usuarios.");
		System.out.println("ID: 1: Armando Guerra");
		System.out.println("---> Tiene el siguiente título en préstamo:");
		System.out.println("* Cumbres borrascosas, escrito por Emily Bronte.");
		System.out.println("ID: 2: Kepa Sarasola");
		System.out.println("---> No tiene libros en préstamo.");
		System.out.println("ID: 3: Lola Mento");
		System.out.println("---> Tiene los siguientes 2 títulos en préstamo:");
		System.out.println("* Sentido y sensibilidad, escrito por Jane Austen.");
		System.out.println("* El hobbit, escrito por JRR Tolkien.");
		
		System.out.println("\nY tu programa lo muestra de este modo:");
		ListaUsuarios.getListaUsuarios().imprimir();
		System.out.println("\n===============================================================");
		
		ListaUsuarios.getListaUsuarios().eliminarUsuario(u1);
		ListaUsuarios.getListaUsuarios().eliminarUsuario(u2);
		ListaUsuarios.getListaUsuarios().eliminarUsuario(u3);
		assertEquals(0,ListaUsuarios.getListaUsuarios().getTamano());	
						
		//fail("Mira los mensajes que se muestran en la consola del sistema, y si todo ha ido bien elimina o comenta este fail");
		//Funciona.
	}
				
}

