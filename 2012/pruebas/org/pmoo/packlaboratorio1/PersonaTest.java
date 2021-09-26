package org.pmoo.packlaboratorio1;

import junit.framework.TestCase;

public class PersonaTest extends TestCase

{
	Persona p1; 
	Persona p2; 
	protected void setUp() throws Exception
	{
		super.setUp();
		p1 = new Persona();
		p2 = new Persona();
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
		p1 = null;
		p2 = null;
	}

	public void testPersona() 
	{			
		assertEquals(p1.getNombreCompleto(), "Nombre desconocido");
		assertEquals(p1.getEdad(),0);
		assertEquals(p1.getIdPersona(),0);
		assertEquals(p1.getGrupoSanguineo(),"sangre");
		assertEquals(p1.getNacionalidad(),"Pais");
	}

	public void testSetIdPersona() 
	{
		p1.setIdPersona(987544);
		assertEquals(p1.getIdPersona(),987544);
	}

	public void testSetGrupoSanguineo() 
	{
		p1.setGrupoSanguineo("0-");
		assertEquals(p1.getGrupoSanguineo(),"0-");
		
		p1.setGrupoSanguineo("0+");
		assertEquals(p1.getGrupoSanguineo(),"0+");

		p1.setGrupoSanguineo("A+");
		assertEquals(p1.getGrupoSanguineo(),"A+");

		p1.setGrupoSanguineo("A-");
		assertEquals(p1.getGrupoSanguineo(),"A-");

		p1.setGrupoSanguineo("B-");
		assertEquals(p1.getGrupoSanguineo(),"B-");

		p1.setGrupoSanguineo("B+");
		assertEquals(p1.getGrupoSanguineo(),"B+");

		p1.setGrupoSanguineo("AB+");
		assertEquals(p1.getGrupoSanguineo(),"AB+");

		p1.setGrupoSanguineo("AB-");
		assertEquals(p1.getGrupoSanguineo(),"AB-");

		
	}

	public void testSetNacionalidad()
	{
		p1.setNacionalidad("UK");
		assertEquals(p1.getNacionalidad(),"UK");

		p1.setNacionalidad("USA");
		assertEquals(p1.getNacionalidad(),"USA");


		p1.setNacionalidad("Etiopía");
		assertEquals(p1.getNacionalidad(),"Etiopía");

		
		p1.setNacionalidad("Australia");
		assertEquals(p1.getNacionalidad(),"Australia");


	}


	public void testSetNombreCompleto() 
	{
		p1.setNombreCompleto("Melocotón Demigrante");
		assertEquals(p1.getNombreCompleto(),"Melocotón Demigrante");
	}


	public void testSetEdad()
	{
		p1.setEdad(19);
		assertEquals(p1.getEdad(),19);
	}

	public void testTieneMismoId() 
	{
		p1.setIdPersona(47850);
		p2.setIdPersona(47850);
		assertTrue(p1.tieneMismoId(p2));
		assertTrue(p2.tieneMismoId(p1));
		
		p2.setIdPersona(47885);
		p1.setIdPersona(47850);
		assertFalse(p1.tieneMismoId(p2));
		assertFalse(p2.tieneMismoId(p1));
	}

	public void testPuedeConducir()
	{
		p1.setEdad(25);

		p1.setNacionalidad("UK");
		assertTrue(p1.puedeConducir());
		p1.setNacionalidad("USA");
		assertTrue(p1.puedeConducir());
		p1.setNacionalidad("Australia");
		assertTrue(p1.puedeConducir());
		p1.setNacionalidad("Etiopía");
		assertTrue(p1.puedeConducir());


		p1.setEdad(18);
		
		p1.setNacionalidad("UK");
		assertTrue(p1.puedeConducir());
		p1.setNacionalidad("USA");
		assertTrue(p1.puedeConducir());
		p1.setNacionalidad("Jamaica");
		assertTrue(p1.puedeConducir());
		p1.setNacionalidad("Australia");
		assertTrue(p1.puedeConducir());
		p1.setNacionalidad("Etiopía");
		assertTrue(p1.puedeConducir());

		
		
		p1.setEdad(17);
		
		p1.setNacionalidad("UK");
		assertTrue(p1.puedeConducir());
		p1.setNacionalidad("Australia");
		assertTrue(p1.puedeConducir());
		p1.setNacionalidad("Etiopía");
		assertTrue(p1.puedeConducir());
		p1.setNacionalidad("USA");
		assertTrue(p1.puedeConducir());

		p1.setEdad(16);
		
		p1.setNacionalidad("UK");
		assertFalse(p1.puedeConducir());
		p1.setNacionalidad("USA");
		assertTrue(p1.puedeConducir());
		p1.setNacionalidad("Australia");
		assertTrue(p1.puedeConducir());
		p1.setNacionalidad("Etiopía");	
		assertTrue(p1.puedeConducir());
		
		p1.setEdad(14);
		
		p1.setNacionalidad("UK");
		assertFalse(p1.puedeConducir());
		p1.setNacionalidad("USA");
		assertFalse(p1.puedeConducir());
		p1.setNacionalidad("Australia");
		assertFalse(p1.puedeConducir());
		p1.setNacionalidad("Etiopía");
		assertTrue(p1.puedeConducir());

		
		p1.setEdad(12);
		
		p1.setNacionalidad("USA");
		assertFalse(p1.puedeConducir());
		p1.setNacionalidad("Australia");
		assertFalse(p1.puedeConducir());
		p1.setNacionalidad("Etiopía");
		assertFalse(p1.puedeConducir());
		p1.setNacionalidad("UK");		
		assertFalse(p1.puedeConducir());

		}

	public void testPuedeDonarSangre() 
	{
			
		p1.setGrupoSanguineo("0+");
		
		p2.setGrupoSanguineo("0+");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("0-");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("A+");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("A-");	
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("B+");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("B-");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("AB+");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("AB-");
		assertFalse(p1.puedeDonarSangre(p2));
		
		
		
		p1.setGrupoSanguineo("0-");
		
		p2.setGrupoSanguineo("0+");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("0-");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("A+");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("A-");	
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("B+");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("B-");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("AB+");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("AB-");
		assertTrue(p1.puedeDonarSangre(p2));
		
		
		
		p1.setGrupoSanguineo("A+");
		
		p2.setGrupoSanguineo("0+");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("0-");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("A+");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("A-");	
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("B+");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("B-");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("AB+");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("AB-");
		assertFalse(p1.puedeDonarSangre(p2));
		

		
		p1.setGrupoSanguineo("A-");
		
		p2.setGrupoSanguineo("0+");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("0-");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("A+");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("A-");	
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("B+");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("B-");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("AB+");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("AB-");
		assertTrue(p1.puedeDonarSangre(p2));
		
		
		
		p1.setGrupoSanguineo("B+");
		
		p2.setGrupoSanguineo("0+");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("0-");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("A+");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("A-");	
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("B+");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("B-");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("AB+");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("AB-");
		assertFalse(p1.puedeDonarSangre(p2));
		
		
		
		p1.setGrupoSanguineo("B-");
		
		p2.setGrupoSanguineo("0+");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("0-");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("A+");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("A-");	
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("B+");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("B-");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("AB+");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("AB-");
		assertTrue(p1.puedeDonarSangre(p2));
		
		
		
		p1.setGrupoSanguineo("AB+");
		
		p2.setGrupoSanguineo("0+");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("0-");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("A+");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("A-");	
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("B+");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("B-");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("AB+");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("AB-");
		assertFalse(p1.puedeDonarSangre(p2));
		
		
		
		p1.setGrupoSanguineo("AB-");
		
		p2.setGrupoSanguineo("0+");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("0-");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("A+");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("A-");	
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("B+");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("B-");
		assertFalse(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("AB+");
		assertTrue(p1.puedeDonarSangre(p2));
		p2.setGrupoSanguineo("AB-");
		assertTrue(p1.puedeDonarSangre(p2));
	}
	
	public void testGetInicialNombre ()
	{
		p1.setNombreCompleto("Johny Melavo");
		assertEquals(p1.getInicialNombre(),'J');
		
		p1.setNombreCompleto("Adam West");
		assertEquals(p1.getInicialNombre(),'A');
	}
	
	public void testGetInicialApellido ()
	{
		p1.setNombreCompleto("Alice Cooper");
		assertEquals(p1.getInicialApellido(),'C');
		
		p1.setNombreCompleto("Pedro de Guzmán");
		assertEquals(p1.getInicialApellido(),'G');
	}

}
