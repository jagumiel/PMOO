package org.pmoo.packlaboratorio7;

import junit.framework.TestCase;

public class ListaAlumnosCursoTest extends TestCase 
{
	Mujer m1;
	Mujer m2;
	Hombre h1;
	Hombre h2;
	Pareja bailarines1;

	protected void setUp()
	{
		m1=new Mujer("4321", "María", "Gonzalez", 20);
		m2=new Mujer("3241", "Eduarda", "Ramirez", 25);
		h1=new Hombre("9876", "Pablo", "Picasso", 19);
		h2=new Hombre("1234", "Paco", "Fernandez", 21);
		bailarines1=new Pareja(h1, m1);
	}

	protected void tearDown()
	{
		m1=null;
		m2=null;
		h1=null;
		h2=null;
		bailarines1=null;
	}
	
	public void testGetListaAlumnosCurso()
	{
		assertNotNull(ListaAlumnosCurso.getListaAlumnosCurso());
	}
	
	public void testAnadirAlumnoCurso()
	{
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(h2);
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(m1);
		assertEquals(ListaAlumnosCurso.getListaAlumnosCurso().buscarAlumnoPorDNI("1234"),h2);
	}
	
	public void testResetear()
	{
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(h2);
		assertNotNull(ListaAlumnosCurso.getListaAlumnosCurso().buscarAlumnoPorDNI("1234"));
		ListaAlumnosCurso.getListaAlumnosCurso().resetear();
		assertNull(ListaAlumnosCurso.getListaAlumnosCurso().buscarAlumnoPorDNI("1234"));
	}
	
	public void testBuscarAlumnoPorId()
	{
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(h2);
		assertEquals(ListaAlumnosCurso.getListaAlumnosCurso().buscarAlumnoPorDNI("1234"),h2);
	}
	
	public void testHayAlumnosSinPareja()
	{
		ListaAlumnosCurso.getListaAlumnosCurso().resetear();
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(h1);
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(m1);
		assertFalse(ListaAlumnosCurso.getListaAlumnosCurso().hayAlumnosSinPareja());
		ListaAlumnosCurso.getListaAlumnosCurso().resetear();
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(h2);
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(h1);
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(m1);
		assertTrue(ListaAlumnosCurso.getListaAlumnosCurso().hayAlumnosSinPareja());
	}

}
