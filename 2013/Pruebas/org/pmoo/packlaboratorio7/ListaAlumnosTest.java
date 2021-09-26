package org.pmoo.packlaboratorio7;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.pmoo.packlaboratorio7.Hombre;
import org.pmoo.packlaboratorio7.ListaAlumnos;
import org.pmoo.packlaboratorio7.Mujer;

public class ListaAlumnosTest 
{
	Hombre h1,h2,h3,h4,h5;
	Mujer m1,m2;
	ListaAlumnos l;
	
	@Before
	public void setUp() throws Exception {
		h1 = new Hombre("123R","Patxi","Sanchez",16);
		h2 = new Hombre("345Q","Esteban","Co",18);
		h3 = new Hombre("378L","Jon","Coma",17);
		h4 = new Hombre("345Q","Toni","Garra",23);
		h5 = new Hombre("399P","Ramon","Soria",15);
		m1 = new Mujer("1456V","Marciana","Fernandez",18);
		m2 = new Mujer("567T","Maria","Lopez",16);
		l = new ListaAlumnos();
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
		l = null;
	}

	@Test
	public void testListaAlumnos() {
		assertNotNull(l);
	}

	@Test
	public void testAnadirAlumno() {
		l.anadirAlumno(h1);
		assertEquals(l.getTamano(),1);
	}

	@Test
	public void testRetirarAlumno() {
		l.anadirAlumno(h1);
		assertEquals(l.getTamano(),1);
		l.retirarAlumno(h1);
		assertEquals(l.getTamano(),0);
	}

	@Test
	public void testGetTamano() {
		l.anadirAlumno(h1);
		l.anadirAlumno(h2);
		l.anadirAlumno(h3);
		assertEquals(l.getTamano(),3);
	
	}

	@Test
	public void testGetAlumnoEnPos() {
		l.anadirAlumno(h1);
		l.anadirAlumno(h2);
		l.anadirAlumno(h3);
		assertEquals(l.getAlumnoEnPos(2).getDNI(),"378L");
		assertNull(l.getAlumnoEnPos(5));
	}

	@Test
	public void testEsta() {
		l.anadirAlumno(h1);
		l.anadirAlumno(h2);
		l.anadirAlumno(h3);
		assertTrue(l.esta(h3));
		assertFalse(l.esta(m1));
	}

}
