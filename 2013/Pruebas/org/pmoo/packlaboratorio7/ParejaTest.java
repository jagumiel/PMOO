package org.pmoo.packlaboratorio7;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.pmoo.packlaboratorio7.Hombre;
import org.pmoo.packlaboratorio7.Mujer;
import org.pmoo.packlaboratorio7.Pareja;

public class ParejaTest {
	Hombre h1,h2,h3,h4,h5;
	Mujer m1,m2;
	Pareja p1,p2;
	@Before
	public void setUp() throws Exception {
		h1 = new Hombre("123R","Patxi","Sanchez",16);
		h2 = new Hombre("345Q","Esteban","Co",18);
		h3 = new Hombre("378L","Jon","Coma",17);
		h4 = new Hombre("345Q","Toni","Garra",23);
		h5 = new Hombre("345Q","Ramon","Soria",15);
		m1 = new Mujer("1456V","Marciana","Fernandez",18);
		m2 = new Mujer("567T","Maria","Lopez",16);
		p1 = new Pareja(h1,m1);
		p2 = new Pareja(m2,h2);
	
	}

	@After
	public void tearDown() throws Exception {
		h1 = null;
		h2 = null;
		h3 = null;
		h4 = null;
		h5 = null;
		m1 = null;
		m2 = null;
		p1 = null;
		p2 = null;
	}
	@Test
	public void testPareja() 
	{
		assertNotNull(p1);
		assertEquals(p1.getEl().getDNI(),h1.getDNI());
		assertEquals(p1.getElla().getDNI(),m1.getDNI());
		assertNull(new Pareja(h1,h2).getEl());
		assertNull(new Pareja(h1,h2).getElla());
	}
	@Test
	public void testGetEl() 
	{
		assertEquals(p2.getEl().getDNI(),h2.getDNI());
	}
	@Test
	public void testGetElla() 
	{
		assertEquals(p2.getElla().getDNI(),m2.getDNI());
	}
	@Test
	public void testEsta() 
	{
		assertTrue(p1.esta(h1));
		assertFalse(p1.esta(m2));
	}
	@Test
	public void testSetEl()
	{
		assertEquals(p1.getEl().getDNI(),h1.getDNI());
		p1.setEl(h2);
		assertEquals(p1.getEl().getDNI(),h2.getDNI());
		p1.setElla(m2);
		assertEquals(p1.getElla().getDNI(),m2.getDNI());
	}

}
