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

public class ListaParejasTest {
	Hombre h1,h2,h3,h4,h5;
	Mujer m1,m2,m3;
	Pareja p1,p2,p3,p4;
	@Before
	public void setUp() throws Exception {
		h1 = new Hombre("123R","Patxi","Sanchez",16);
		h2 = new Hombre("345Q","Esteban","Co",18);
		h3 = new Hombre("378L","Jon","Coma",17);
		h4 = new Hombre("345Q","Toni","Garra",23);
		h5 = new Hombre("345Q","Ramon","Soria",15);
		m1 = new Mujer("1456V","Marciana","Fernandez",18);
		m2 = new Mujer("567T","Maria","Lopez",16);
		m3 = new Mujer("765G","Susana","Rojas",12);
		p1 = new Pareja(h1,m1);
		p2 = new Pareja(m2,h2);
		p3 = new Pareja(h3,m3);
		p4 = new Pareja(h4,h3);
		ListaParejas.getListaParejas().anadirOrdenadoPareja(p1);
	
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
		p1 = null;
		p2 = null;
		p3 = null;
		p4 = null;
		ListaParejas.getListaParejas().resetear();
		ListaAlumnosCurso.getListaAlumnosCurso().resetear();
	
	}

	@Test
	public void testListaParejas()
	{
		assertEquals(ListaParejas.getListaParejas().obtenerParejaDe(h1),m1);
	}

	@Test
	public void testGetListaParejas() {
		ListaParejas.getListaParejas().anadirOrdenadoPareja(p1);
		ListaParejas.getListaParejas().anadirOrdenadoPareja(p2);
		assertEquals(ListaParejas.getListaParejas().obtenerParejaDe(h2).getDNI(),m2.getDNI());
		assertNull(ListaParejas.getListaParejas().obtenerParejaDe(h3));
	
	}

	@Test
	public void testAnadirOrdenadoPareja() {
		ListaParejas.getListaParejas().anadirOrdenadoPareja(p1);
		ListaParejas.getListaParejas().anadirOrdenadoPareja(p2);
		assertEquals(ListaParejas.getListaParejas().obtenerParejaDe(h2).getDNI(),m2.getDNI());
	
	}

	@Test
	public void testObtenerPareja() {
		ListaParejas.getListaParejas().anadirOrdenadoPareja(p1);
		ListaParejas.getListaParejas().anadirOrdenadoPareja(p2);
		assertEquals(ListaParejas.getListaParejas().obtenerParejaDe(h2).getDNI(),m2.getDNI());
		assertNull(ListaParejas.getListaParejas().obtenerParejaDe(h5));
	
	}

	@Test
	public void testReajustarParejas() {
		p1.getEl().anadirPreferencia(m2);
		p1.getElla().anadirPreferencia(h2);
		p2.getEl().anadirPreferencia(m1);
		p2.getElla().anadirPreferencia(h1);
		ListaParejas.getListaParejas().anadirOrdenadoPareja(p1);
		ListaParejas.getListaParejas().anadirOrdenadoPareja(p2);
		assertEquals(ListaParejas.getListaParejas().obtenerParejaDe(h1).getDNI(),m1.getDNI());
		ListaParejas.getListaParejas().reajustarParejas();
		assertEquals(ListaParejas.getListaParejas().obtenerParejaDe(h2).getDNI(),m1.getDNI());
		assertEquals(ListaParejas.getListaParejas().obtenerParejaDe(h1).getDNI(),m2.getDNI());
		ListaParejas.getListaParejas().anadirOrdenadoPareja(p3);
		assertEquals(ListaParejas.getListaParejas().obtenerParejaDe(h3).getDNI(),m3.getDNI());
		ListaParejas.getListaParejas().reajustarParejas();
		assertEquals(ListaParejas.getListaParejas().obtenerParejaDe(h2).getDNI(),m1.getDNI());
		assertEquals(ListaParejas.getListaParejas().obtenerParejaDe(h1).getDNI(),m2.getDNI());
		assertEquals(ListaParejas.getListaParejas().obtenerParejaDe(h3).getDNI(),m3.getDNI());
	
	}

	@Test
	public void testResetear() {
		ListaParejas.getListaParejas().anadirOrdenadoPareja(p1);
		ListaParejas.getListaParejas().anadirOrdenadoPareja(p2);
		assertEquals(ListaParejas.getListaParejas().obtenerParejaDe(h1).getDNI(),m1.getDNI());
		ListaParejas.getListaParejas().resetear();
		assertNull(ListaParejas.getListaParejas().obtenerParejaDe(h1));
	
	}

}
