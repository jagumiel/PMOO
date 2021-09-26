package org.pmoo.packlaboratorio7;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.pmoo.packlaboratorio7.Hombre;
import org.pmoo.packlaboratorio7.ListaAlumnosCurso;
import org.pmoo.packlaboratorio7.ListaParejas;
import org.pmoo.packlaboratorio7.Mujer;
import org.pmoo.packlaboratorio7.Pareja;

public class ListaAlumnosCursoTest {
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
		ListaAlumnosCurso.getListaAlumnosCurso().resetear();
		ListaParejas.getListaParejas().resetear();
	}

	@Test
	public void testGetListaAlumnosCurso() {
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(h1);
		assertEquals(ListaAlumnosCurso.getListaAlumnosCurso().buscarAlumnoPorDNI("123R").getApellido(),"Sanchez");
	
	}

	@Test
	public void testAnadirAlumnoCurso() {
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(m1);
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(h3);
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(h1);
		assertEquals(ListaAlumnosCurso.getListaAlumnosCurso().buscarAlumnoPorDNI("123R").getApellido(),"Sanchez");
	
	}

	@Test
	public void testResetear() {
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(m1);
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(h3);
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(h1);
		ListaAlumnosCurso.getListaAlumnosCurso().resetear();
		assertFalse(ListaAlumnosCurso.getListaAlumnosCurso().hayAlumnosSinPareja());
	
	}

	@Test
	public void testBuscarAlumnoPorDNI() {
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(m1);
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(h3);
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(h1);
		assertEquals(ListaAlumnosCurso.getListaAlumnosCurso().buscarAlumnoPorDNI("123R").getApellido(),"Sanchez");
		assertNull(ListaAlumnosCurso.getListaAlumnosCurso().buscarAlumnoPorDNI("567T"));
	
	}

	@Test
	public void testHayAlumnosSinPareja() {
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(m1);
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(h3);
		ListaParejas.getListaParejas().anadirOrdenadoPareja(new Pareja(m1,h3));
		assertFalse(ListaAlumnosCurso.getListaAlumnosCurso().hayAlumnosSinPareja());
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(h1);
		assertTrue(ListaAlumnosCurso.getListaAlumnosCurso().hayAlumnosSinPareja());
	
	}

}
