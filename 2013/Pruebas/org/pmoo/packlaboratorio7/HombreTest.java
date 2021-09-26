package org.pmoo.packlaboratorio7;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.pmoo.packlaboratorio7.Hombre;
import org.pmoo.packlaboratorio7.Mujer;

public class HombreTest {

	Hombre h1,h2,h3,h4,h5;
	Mujer m1,m2;
	@Before
	public void setUp() throws Exception {
		h1 = new Hombre("123R","Patxi","Sanchez",16);
		h2 = new Hombre("345Q","Esteban","Co",18);
		h3 = new Hombre("378L","Jon","Coma",17);
		h4 = new Hombre("345Q","Toni","Garra",23);
		h5 = new Hombre("345Q","Ramon","Soria",15);
		m1 = new Mujer("1456V","Marciana","Fernandez",18);
		m2 = new Mujer("567T","Maria","Lopez",16);
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
	}

	@Test
	public void testAceptar() {
		h1.anadirPreferencia(m1);
		assertTrue(h1.aceptar(m1));
		assertFalse(h1.aceptar(m2));
	}

	@Test
	public void testAnadirPreferente() {
		h1.anadirPreferencia(m1);
		assertEquals(h1.getListaPreferencias().getTamano(),1);
		assertNotSame(h1.getListaPreferencias().getTamano(),2);
		h1.anadirPreferencia(m2);
		assertEquals(h1.getListaPreferencias().getTamano(),2);
		assertNotSame(h1.getListaPreferencias().getTamano(),3);

	}

	@Test
	public void testAlumno() {
		assertEquals(h1.getNombre(),"Patxi");
		assertEquals(h1.getApellido(),"Sanchez");
		assertEquals(h1.getDNI(),"123R");
		assertEquals(h1.getEdad(),16);
		assertNotNull(h1);
		assertNotSame(h1.getNombre(),"Pedro");
		assertNotSame(h1.getApellido(),"Jimenez");
		assertNotSame(h1.getDNI(),"123A");
		assertNotSame(h1.getEdad(),13);
	}


}
