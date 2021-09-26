package org.pmoo.packlaboratorio7;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.pmoo.packlaboratorio7.Hombre;
import org.pmoo.packlaboratorio7.ListaAlumnos;
import org.pmoo.packlaboratorio7.Mujer;

public class MujerTest {
	Hombre h1,h2,h3,h4,h5;
	Mujer m1,m2,m3;
	ListaAlumnos l1;
	@Before
	public void setUp() throws Exception {
		h1 = new Hombre("123R","Patxi","Sanchez",16);
		h2 = new Hombre("345Q","Esteban","Co",18);
		h3 = new Hombre("378L","Jon","Coma",17);
		h4 = new Hombre("345Q","Toni","Garra",23);
		h5 = new Hombre("345Q","Ramon","Soria",15);
		m1 = new Mujer("1456V","Marciana","Fernandez",18);
		m2 = new Mujer("567T","Maria","Lopez",16);
		m3 = new Mujer("645L","Estefania","Garcia",26);
		l1 = new ListaAlumnos();
	
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
		m3 = null;
		l1 = null;
	}

	@Test
	public void testMujer() {
		assertNotNull(m1);
		assertEquals(m1.getApellido(),"Fernandez");
		assertEquals(m1.getNombre(),"Marciana");
		assertEquals(m1.getEdad(),18);
		assertEquals(m1.getDNI(),"1456V");
	
	}

	@Test
	public void testEmparejar() {
		l1.anadirAlumno(h1);
		l1.anadirAlumno(h3);
		l1.anadirAlumno(h2);
		l1.anadirAlumno(h4);
		l1.anadirAlumno(h5);
		m1.anadirPreferencia(h3);
		m1.anadirPreferencia(h5);
		h5.anadirPreferencia(m1);
		h1 = m1.emparejar(l1);
		assertNotNull(h1);
		//assertEquals(h1.getDNI(),h5.getDNI());
		m2.anadirPreferencia(h2);
		m2.anadirPreferencia(h4);
		h1 = m2.emparejar(l1);
		assertNull(h1);
		l1.anadirAlumno(m1);
		assertNull(m3.emparejar(l1));
	}

	@Test
	public void testAnadirPreferencias() {
		m1.anadirPreferencia(h1);
		assertEquals(m1.getListaPreferencias().getTamano(),1);
		m1.anadirPreferencia(m2);
		assertEquals(m1.getListaPreferencias().getTamano(),1);
	
	}

}
