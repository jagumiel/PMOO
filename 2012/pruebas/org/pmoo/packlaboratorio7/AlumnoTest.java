package org.pmoo.packlaboratorio7;

import junit.framework.TestCase;

public class AlumnoTest extends TestCase 
{
	Hombre alumno1;
	Mujer alumno2;
	Hombre alumno3;
	Mujer alumno4;

	protected void setUp() 
	{
		alumno1=new Hombre("1234", "Paco", "Fernandez", 21);
		alumno2=new Mujer("4321", "María", "Gonzalez", 20);
		alumno3=new Hombre("9876", "Pablo", "Picasso", 19);
	}

	protected void tearDown()
	{
		alumno1=null;
		alumno2=null;
		alumno3=null;
	}
	
	public void testAlumno()
	{
		alumno4=new Mujer("3241", "Eduarda", "Ramirez", 25);
		assertTrue(alumno4 instanceof Alumno);
	}
	
	public void testGetNombre()
	{
		assertEquals(alumno1.getNombre(),"Paco");
		assertEquals(alumno2.getNombre(),"María");
	}
	
	public void testGetApellido()
	{
		assertEquals(alumno1.getApellido(),"Fernandez");
		assertEquals(alumno2.getApellido(),"Gonzalez");
	}
	
	public void testGetEdad()
	{
		assertEquals(alumno1.getEdad(),21);
		assertEquals(alumno2.getEdad(),20);
	}
	
	public void testGetDNI()
	{
		assertEquals(alumno1.getDNI(),"1234");
		assertEquals(alumno2.getDNI(),"4321");
	}
	
	public void testAnadirPreferencia()
	{
		alumno1.anadirPreferencia(alumno3);
		System.out.print(alumno1.getListaPreferencias());
		//Comprobar el mensaje.
		alumno1.anadirPreferencia(alumno2);
		assertNotNull(alumno1.getListaPreferencias());
	}
	
	public void testGetListaPreferencias()
	{
		alumno1.anadirPreferencia(alumno2);
		assertNotNull(alumno1.getListaPreferencias());
		assertEquals(alumno1.getListaPreferencias().getTamano(),1);
	}

}
