package org.pmoo.packlaboratorio1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.pmoo.packlaboratorio1.Persona;

public class PersonaTest {
	private Persona persona1;
	private Persona persona2;
	
	@Before
	public void setUp() throws Exception 
	{
		persona1 = new Persona();
		persona2 = new Persona();
	}

	@After
	public void tearDown() throws Exception 
	{
		persona1=null;
		persona2=null;
	}

	@Test
	public void testPersona() 
	{
		assertEquals(persona1.getNombreCompleto(),("desconocido"));
		assertEquals(persona1.getEdad(),0);
		assertEquals(persona1.getIdPersona(),0);
		assertEquals(persona1.getGrupoSanguineo(),("desconocido"));
		assertEquals(persona1.getNacionalidad(),("desconocido"));
	}


	@Test
	public void testSetNombreCompleto() 
	{
		persona1.setNombreCompleto("Kunta Kinte");
		assertEquals(persona1.getNombreCompleto(),("Kunta Kinte"));
	}


	@Test
	public void testSetEdad()
	{
		persona1.setEdad(20);
		assertEquals(persona1.getEdad(),20);
	}


	@Test
	public void testSetIdPersona()
	{
		persona1.setIdPersona(45665663);
		assertEquals(persona1.getIdPersona(),45665663);
		
	}


	@Test
	public void testSetGrupoSanguineo() 
	{
		persona1.setGrupoSanguineo("AB-");
		assertEquals(persona1.getGrupoSanguineo(),("AB-"));
	}


	@Test
	public void testSetNacionalidad()
	{
		persona1.setNacionalidad("Euskalduna");
		assertEquals(persona1.getNacionalidad(),("Euskalduna"));
	}

	@Test
	public void testTieneMismoId() 
	{
		persona1.setIdPersona(9119221);
		persona2.setIdPersona(9119221);
		assertTrue(persona1.tieneMismoId(persona2));
		persona2.setIdPersona(9119222);
		assertFalse(persona1.tieneMismoId(persona2));
	}

	@Test
	public void testPuedeConducir()
	{
		persona1.setEdad(14);
		persona1.setNacionalidad("Etiopia");
		assertTrue(persona1.puedeConducir());
		persona1.setNacionalidad("USA");
		assertFalse(persona1.puedeConducir());
		persona1.setEdad(16);
		assertTrue(persona1.puedeConducir());
		persona1.setNacionalidad("Australia");
		assertTrue(persona1.puedeConducir());
		persona1.setNacionalidad("Reino Unido");
		assertFalse(persona1.puedeConducir());
		persona1.setEdad(17);
		assertTrue(persona1.puedeConducir());
		persona1.setEdad(18);
		persona1.setNacionalidad("Japon");
		assertTrue(persona1.puedeConducir());
	}

	@Test
	public void testGetInicialNombre() 
	{
		persona1.setNombreCompleto("Kunta Kinte");
		assertEquals(persona1.getInicialNombre(),('K'));
	}

	@Test
	public void testGetInicialApellido() 
	{
		persona1.setNombreCompleto("Kunta Tinte");
		assertEquals(persona1.getInicialApellido(),('T'));
	}

	@Test
	public void testPuedeDonarleSangre() 
	{
		persona1.setGrupoSanguineo("0-");
		
		persona2.setGrupoSanguineo("0-");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("0+");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("A-");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("A+");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("B-");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("B+");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("AB-");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("AB+");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		
		persona1.setGrupoSanguineo("0+");
		
		persona2.setGrupoSanguineo("0-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("0+");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("A-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("A+");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("B-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("B+");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("AB-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("AB+");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		
		persona1.setGrupoSanguineo("A-");
		
		persona2.setGrupoSanguineo("0-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("0+");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("A-");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("A+");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("B-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("B+");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("AB-");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("AB+");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		
		persona1.setGrupoSanguineo("A+");
		
		persona2.setGrupoSanguineo("0-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("0+");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("A-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("A+");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("B-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("B+");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("AB-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("AB+");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		
		persona1.setGrupoSanguineo("B-");
		
		persona2.setGrupoSanguineo("0-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("0+");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("A-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("A+");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("B-");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("B+");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("AB-");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("AB+");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		
		persona1.setGrupoSanguineo("B+");
		
		persona2.setGrupoSanguineo("0-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("0+");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("A-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("A+");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("B-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("B+");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("AB-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("AB+");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		
		persona1.setGrupoSanguineo("AB-");
		
		persona2.setGrupoSanguineo("0-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("0+");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("A-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("A+");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("B-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("B+");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("AB-");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("AB+");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		
		persona1.setGrupoSanguineo("AB+");
		
		persona2.setGrupoSanguineo("0-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("0+");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("A-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("A+");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("B-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("B+");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("AB-");
		assertFalse(persona1.puedeDonarleSangre(persona2));
		persona2.setGrupoSanguineo("AB+");
		assertTrue(persona1.puedeDonarleSangre(persona2));
		
	}
	
}
