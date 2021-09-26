package org.pmoo.packlaboratorio7;

import junit.framework.TestCase;

public class ListaAlumnosTest extends TestCase
{
	Mujer m1;
	Mujer m2;
	Hombre h1;
	Hombre h2;
	ListaAlumnos lista;
	
	protected void setUp()
	{
		m1=new Mujer("4321", "María", "Gonzalez", 20);
		m2=new Mujer("3241", "Eduarda", "Ramirez", 25);
		h1=new Hombre("9876", "Pablo", "Picasso", 19);
		h2=new Hombre("1234", "Paco", "Fernandez", 21);
		
		lista=new ListaAlumnos();
	}

	protected void tearDown()
	{
		m1=null;
		m2=null;
		h1=null;
		h2=null;
		lista=null;
	}

	public void testListaAlumnos()
	{
		assertNotNull(lista);
	}
	
	public void testAnadirAlumno()
	{
		lista.anadirAlumno(h1);
		assertEquals(lista.getTamano(),1);
		lista.anadirAlumno(m1);
		assertEquals(lista.getTamano(),2);
	}

	public void testRetirarAlumno()
	{
		lista.anadirAlumno(h1);
		lista.anadirAlumno(m1);
		assertEquals(lista.getTamano(),2);
		lista.retirarAlumno(h1);
		assertEquals(lista.getTamano(),1);
		lista.retirarAlumno(m1);
		assertEquals(lista.getTamano(),0);
	}
	
	public void testGetTamano()
	{
		lista.anadirAlumno(h1);
		lista.anadirAlumno(m1);
		assertEquals(lista.getTamano(),2);
	}
	
	public void testGetAlumnoEnPos()
	{
		//TODO
	}
	
	public void testEsta()
	{
		lista.anadirAlumno(h1);
		assertTrue(lista.esta(h1));
		assertFalse(lista.esta(h2));
	}
	
}
