package org.pmoo.packlaboratorio7;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlumnoTest {

	Hombre el1;
	Mujer ella1,ella2;
	
	@Before
	public void setUp() throws Exception {

		el1 = new Hombre("123456A","Andres","Amor",28);
		ella1 = new Mujer("123457B","Barbara","Boato",48);
		ella2 = new Mujer("123458C","Carmen","Copa",56);
	}

	@After
	public void tearDown() throws Exception {
		el1 = null;
		ella1 = null;
		ella2 = null;
	}

	@Test
	public void testAlumno() {
		assertNotNull(el1);
		assertEquals(el1.getDNI(),"123456A");
		assertEquals(el1.getNombre(),"Andres");
		assertEquals(el1.getApellido(),"Amor");
		assertEquals(el1.getEdad(),28);
	}

	@Test
	public void testGetListaPreferencias() {
		el1.anadirPreferencia(ella1);
		el1.anadirPreferencia(ella2);
		assertEquals(el1.getListaPreferencias().getTamano(),2);
	}

	@Test
	public void testGetNombre() {
		assertEquals(ella1.getNombre(),"Barbara");
		assertNotSame(ella1.getNombre(),"Mirian");
		assertEquals(ella2.getNombre(),"Carmen");
		assertNotSame(ella2.getNombre(),"Mirian");
	}

	@Test
	public void testGetApellido() {
		assertEquals(ella1.getApellido(),"Boato");
		assertNotSame(ella1.getApellido(),"Higo");
		assertEquals(ella2.getApellido(),"Copa");
		assertNotSame(ella2.getApellido(),"Higo");
	}

	@Test
	public void testGetEdad() {
		assertEquals(ella1.getEdad(),48);
		assertNotSame(ella1.getEdad(),12);
		assertEquals(ella2.getEdad(),56);
		assertNotSame(ella2.getEdad(),12);
	}

	@Test
	public void testGetDNI() {
		assertEquals(ella1.getDNI(),"123457B");
		assertNotSame(ella1.getDNI(),"123457A");
		assertEquals(ella2.getDNI(),"123458C");
		assertNotSame(ella2.getDNI(),"123457A");
	}

	@Test
	public void testAnadirPreferencia() {
		el1.anadirPreferencia(ella1);
		assertEquals(el1.getListaPreferencias().getTamano(),1);
		el1.anadirPreferencia(ella2);
	}

}
