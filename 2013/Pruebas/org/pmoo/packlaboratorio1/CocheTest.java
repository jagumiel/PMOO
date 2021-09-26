package org.pmoo.packlaboratorio1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CocheTest
{

	private Coche coche1;
	@Before
	public void setUp() throws Exception
	{
	coche1=new Coche(("Ford Focus"), ("4455BI"));
	}

	@After
	public void tearDown() throws Exception 
	{
		coche1=null;
	}

	@Test
	public void testCoche()
	{
		assertEquals(coche1.getMarcaModelo(),("Ford Focus"));
		assertEquals(coche1.getMatricula(),("4455BI"));
		assertEquals(coche1.getPropietario(),null);
	}


	@Test
	public void testSetMarcaModelo()
	{
		coche1.setMarcaModelo("Peugeote 206");
		assertEquals ("Peugeote 206", coche1.getMarcaModelo());
	}
		

	@Test
	public void testSetMatricula()
	{
		coche1.setMatricula("VI0868W");
		assertEquals ("VI0868W", coche1.getMatricula());
	}


	@Test
	public void testSetPropietario() 
	{
		Persona p1=new Persona();
		coche1.setPropietario(p1);
		assertEquals (p1, coche1.getPropietario());
	}

}
