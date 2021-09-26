package org.pmoo.packlaboratorio7;

import junit.framework.TestCase;

public class ListaParejasTest extends TestCase 
{
	Mujer m1;
	Mujer m2;
	Hombre h1;
	Hombre h2;
	Pareja bailarines1;

	protected void setUp()
	{
		m1=new Mujer("4321", "María", "Gonzalez", 20);
		m2=new Mujer("3241", "Eduarda", "Ramirez", 25);
		h1=new Hombre("9876", "Pablo", "Picasso", 19);
		h2=new Hombre("1234", "Paco", "Fernandez", 21);
		bailarines1=new Pareja(h1, m1);
	}

	protected void tearDown()
	{
		m1=null;
		m2=null;
		h1=null;
		h2=null;
		bailarines1=null;
	}
	
	public void testGetListaParejas()
	{
		assertNotNull(ListaParejas.getListaParejas());
	}
	
	public void testAnadirOrdenadoPareja()
	{
		ListaParejas.getListaParejas().anadirOrdenadoPareja(bailarines1);
		assertEquals(ListaParejas.getListaParejas().lista.size(),1);
	}
	
	public void testObtenerParejaDe()
	{
		ListaParejas.getListaParejas().anadirOrdenadoPareja(bailarines1);
		assertSame(ListaParejas.getListaParejas().obtenerParejaDe(h1),m1);
		assertSame(ListaParejas.getListaParejas().obtenerParejaDe(m1),h1);
	}
	
	
	public void testReajustar()
	{
		//TODO
	}
	
	public void testResetear()
	{
		ListaParejas.getListaParejas().anadirOrdenadoPareja(bailarines1);
		assertNotNull(ListaParejas.getListaParejas());
		ListaParejas.getListaParejas().resetear();
		assertEquals(ListaParejas.getListaParejas().lista.size(),0);
	}

}
