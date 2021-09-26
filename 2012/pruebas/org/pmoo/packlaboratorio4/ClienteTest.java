package org.pmoo.packlaboratorio4;

import org.pmoo.packlaboratorio4.Cliente;

import junit.framework.TestCase;

public class ClienteTest extends TestCase 
{

	private Cliente c1;
	protected void setUp() throws Exception
	{
		super.setUp();
		c1 = new Cliente(0001, "Fernando", "4906", 1000.0, true);
	}

	protected void tearDown() throws Exception 
	{
		super.tearDown();
		c1=null;
	}
	
	public void testGetSaldo()
	{
		c1.getSaldo();
		assertEquals(c1.getSaldo(),1000.0);
	}
	
	public void testActualizarSaldo()
	{
		c1.actualizarSaldo(400.0);
		assertEquals (c1.getSaldo(),600.0);
	}
	
	public void testGetNombre()
	{
		c1.getNombre();
		assertEquals (c1.getNombre(),"Fernando");
	}
	
	public void testComprobarClave()
	{
		c1.comprobarClave("4906");
		assertTrue (c1.comprobarClave("4906"));
	}
	
	public void testGetEsPreferente()
	{
		c1.getEsPreferente();
		assertTrue (c1.getEsPreferente());
	}

}
