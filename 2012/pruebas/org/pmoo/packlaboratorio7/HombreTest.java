package org.pmoo.packlaboratorio7;

import junit.framework.TestCase;

public class HombreTest extends TestCase 
{
	Mujer m1;
	Mujer m2;
	Hombre h1;
	Hombre h2;
	
	protected void setUp()
	{
		m1=new Mujer("4321", "María", "Gonzalez", 20);
		m2=new Mujer("3241", "Eduarda", "Ramirez", 25);
		h1=new Hombre("9876", "Pablo", "Picasso", 19);
		h2=new Hombre("1234", "Paco", "Fernandez", 21);
	}

	protected void tearDown() throws Exception 
	{
		m1=null;
		m2=null;
		h1=null;
		h2=null;
	}

	public void testHombre()
	{
		assertTrue(h1 instanceof Alumno);
	}
	
	public void testAceptar()
	{
		h1.anadirPreferencia(m2);
		assertFalse(h1.aceptar(m1));
		assertEquals(h1.aceptar(m2),true);
	}
	
	public void testAnadirPreferencias()
	{
		h1.anadirPreferencia(h2);
		System.out.print(h1.getListaPreferencias());
		//Comprobar el mensaje.
		h1.anadirPreferencia(m1);
		assertNotNull(h1.getListaPreferencias());
		assertEquals(h1.getListaPreferencias().getTamano(),1);
	}
}
