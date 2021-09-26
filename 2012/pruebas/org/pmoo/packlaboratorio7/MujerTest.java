package org.pmoo.packlaboratorio7;

import junit.framework.TestCase;

public class MujerTest extends TestCase 
{
	Mujer m1;
	Mujer m2;
	Hombre h1;
	Hombre h2;
	ListaAlumnos listaDisponibles;


	protected void setUp()
	{
		m1=new Mujer("4321", "María", "Gonzalez", 20);
		m2=new Mujer("3241", "Eduarda", "Ramirez", 25);
		h1=new Hombre("9876", "Pablo", "Picasso", 19);
		h2=new Hombre("1234", "Paco", "Fernandez", 21);
		
		listaDisponibles=new ListaAlumnos();
		listaDisponibles.anadirAlumno(m2);
		listaDisponibles.anadirAlumno(h1);

	}

	protected void tearDown()
	{
		m1=null;
		m2=null;
		h1=null;
		h2=null;
		listaDisponibles=null;
	}

	public void testMujer()
	{
		assertTrue(m1 instanceof Alumno);
	}
	
	public void testEmparejar()
	{
		listaDisponibles=new ListaAlumnos();
		listaDisponibles.anadirAlumno(m2);
		listaDisponibles.anadirAlumno(h1);
		m1.anadirPreferencia(m2);
		assertEquals(m1.emparejar(listaDisponibles),null);
		
		listaDisponibles=new ListaAlumnos();
		listaDisponibles.anadirAlumno(h2);
		listaDisponibles.anadirAlumno(h1);
		m1.anadirPreferencia(h2);
		assertEquals(m1.emparejar(listaDisponibles),h2);
		
	}
	
	public void testAnadirPreferencia()
	{
		m1.anadirPreferencia(m2);
		System.out.print(m1.getListaPreferencias());
		//Comprobar el mensaje.
		m1.anadirPreferencia(h1);
		assertNotNull(m1.getListaPreferencias());
		assertEquals(m1.getListaPreferencias().getTamano(),1);
	}
	
}
