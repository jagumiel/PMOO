package org.pmoo.packlaboratorio7;

import junit.framework.TestCase;

public class ParejaTest extends TestCase 
{

	Pareja bailarines1;
	Pareja bailarines2;
	Mujer m1;
	Mujer m2;
	Hombre h1;
	Hombre h2;
	
	protected void setUp()
	{
		bailarines1=new Pareja(h1, m1);
		bailarines1=new Pareja(h2, m2);
		m1=new Mujer("4321", "María", "Gonzalez", 20);
		m2=new Mujer("3241", "Eduarda", "Ramirez", 25);
		h1=new Hombre("9876", "Pablo", "Picasso", 19);
		h2=new Hombre("1234", "Paco", "Fernandez", 21);
	}

	protected void tearDown()
	{
		bailarines1=null;
		bailarines1=null;
		m1=null;
		m2=null;
		h1=null;
		h2=null;
	}
	
	public void testPareja()
	{
		//TODO
	}
	
	public void testGetElla()
	{
		assertEquals(bailarines1.getElla(),m1);
		assertEquals(bailarines2.getElla(),m2);
	}
	
	public void testGetEl()
	{
		assertEquals(bailarines1.getEl(),h1);
		assertEquals(bailarines2.getEl(),h2);
	}
	
	public void testEsta()
	{
		assertTrue(bailarines1.esta(h1));
		assertTrue(bailarines1.esta(m1));
		assertFalse(bailarines1.esta(h2));
		assertFalse(bailarines1.esta(m2));
	}

}
