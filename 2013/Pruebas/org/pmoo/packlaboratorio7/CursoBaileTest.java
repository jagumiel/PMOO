package org.pmoo.packlaboratorio7;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CursoBaileTest {

	Hombre el1,el2,el3,el4,el5;
	Mujer ella1,ella2,ella3;
	Pareja pareja1,pareja2,pareja3;
	
	@Before
	public void setUp() throws Exception {
		el1 = new Hombre("123456A","Andres","Amor",28);
	el2 = new Hombre("123459D","David","Drun",18);
	el3 = new Hombre("123460E","Edorta","Enlas",27);
	//el4 = new Hombre("123461F","Fermin","Forz",14);
	//el5 = new Hombre("123462G","Goitz","Galbez",32);
	ella1 = new Mujer("123457B","Barbara","Boato",48);
	ella2 = new Mujer("123458C","Carmen","Copa",56);
	ella3 = new Mujer("123463H","Hortensia","Hoz",24);
	pareja1 = new Pareja(el1,ella1);
	pareja2 = new Pareja(el2,ella2);
	pareja3 = new Pareja(el3,ella3);
	}

	@After
	public void tearDown() throws Exception {
		el1 = null;
		el2 = null;
		el3 = null;
		//el4 = null;
		//el5 = null;
		ella1 = null;
		ella2 = null;
		ella3 = null;
		pareja1 = null;
		pareja2 = null;
		pareja3 = null;
		ListaParejas.getListaParejas().resetear();
		ListaAlumnosCurso.getListaAlumnosCurso().resetear();
	}

	@Test
	public void testGetCursoBaile() {
		CursoBaile.getCursoBaile().darDeAltaAlumno("123457B", "Barbara", "Boato", 48, 'm');
		assertEquals(ListaAlumnosCurso.getListaAlumnosCurso().buscarAlumnoPorDNI("123457B").getApellido(),"Boato");
		assertNull(ListaAlumnosCurso.getListaAlumnosCurso().buscarAlumnoPorDNI("000000"));
	}

	@Test
	public void testDarDeAltaPareja() {

		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(el1);
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(ella1);
		CursoBaile.getCursoBaile().darDeAltaPareja("123456A", "123457B");
		assertEquals(ListaParejas.getListaParejas().obtenerParejaDe(el1).getDNI(),"123457B");
		assertNotNull(ListaParejas.getListaParejas().obtenerParejaDe(el1).getDNI());
	}

	@Test
	public void testDarDeAltaAlumno() {
		assertNull(ListaAlumnosCurso.getListaAlumnosCurso().buscarAlumnoPorDNI(el1.getDNI()));
		CursoBaile.getCursoBaile().darDeAltaAlumno("123456A", "Andres", "Amor", 16, 'H');
		assertEquals(ListaAlumnosCurso.getListaAlumnosCurso().buscarAlumnoPorDNI(el1.getDNI()).getApellido(),el1.getApellido());
	}

	@Test
	public void testAnadirPreferencia() {
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(el1);
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(ella1);
		CursoBaile.getCursoBaile().anadirPreferencia("123456A", "123457B");
		assertTrue(ListaAlumnosCurso.getListaAlumnosCurso().buscarAlumnoPorDNI(el1.getDNI()).getListaPreferencias().esta(ella1));
	}

	@Test
	public void testEmpezarCurso() {
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(el1);
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(ella1);
		CursoBaile.getCursoBaile().darDeAltaPareja("123456A", "123457B");
		CursoBaile.getCursoBaile().empezarCurso();
		assertNull(ListaAlumnosCurso.getListaAlumnosCurso().buscarAlumnoPorDNI(el1.getDNI()));
		assertNull(ListaParejas.getListaParejas().obtenerParejaDe(el1));
	}

	@Test
	public void testAjustarParejasSegunPreferencias() {
		pareja1.getEl().anadirPreferencia(ella2);
		pareja1.getElla().anadirPreferencia(el2);
		pareja2.getEl().anadirPreferencia(ella1);
		pareja2.getElla().anadirPreferencia(el1);
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(pareja1.getEl());
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(pareja1.getElla());
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(pareja2.getEl());
		ListaAlumnosCurso.getListaAlumnosCurso().anadirAlumnoCurso(pareja2.getElla());
		ListaParejas.getListaParejas().anadirOrdenadoPareja(pareja1);
		ListaParejas.getListaParejas().anadirOrdenadoPareja(pareja2);
		assertEquals(ListaParejas.getListaParejas().obtenerParejaDe(el1).getDNI(),ella1.getDNI());
		assertEquals(ListaParejas.getListaParejas().obtenerParejaDe(el2).getDNI(),ella2.getDNI());
		CursoBaile.getCursoBaile().ajustarParejasSegunPreferencias();
		assertEquals(ListaParejas.getListaParejas().obtenerParejaDe(el2).getDNI(),ella1.getDNI());
		assertEquals(ListaParejas.getListaParejas().obtenerParejaDe(el1).getDNI(),ella2.getDNI());
	}

}
