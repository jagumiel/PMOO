package org.pmoo.packlaboratorio7;

import junit.framework.TestCase;

public class CursoBaileTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGetCursoBaile()
	{
		assertNotNull(CursoBaile.getCursoBaile());
	}

	public void testDarDeAltaPareja()
	{
		//TODO
	}
	
	public void testDarDeAltaAlumno()
	{
		//TODO
	}
	
	public void testAnadirPreferencia()
	{
		//TODO
	}
	
	public void testEmpezarCurso()
	{
		CursoBaile.getCursoBaile().empezarCurso();
		assertNotNull(CursoBaile.getCursoBaile());
	}
	
	public void testAjustarParejasSegunPreferencias()
	{
		//TODO
	}
}
