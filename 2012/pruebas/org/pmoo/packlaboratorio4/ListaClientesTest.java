package org.pmoo.packlaboratorio4;

import junit.framework.TestCase;

public class ListaClientesTest extends TestCase 
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
		ListaClientes.getListaClientes().resetear();
	}
	
	public void testGetListaClientes()
	{
		assertNotNull(ListaClientes.getListaClientes());
	}
	
	public void testBuscarClientePorId()
	{
		ListaClientes.getListaClientes().anadirCliente(c1);
		assertEquals(ListaClientes.getListaClientes().buscarClientePorId(1),c1);
	}

	public void testAnadirCliente ()
	{
		ListaClientes.getListaClientes().anadirCliente(c1);
		assertEquals(ListaClientes.getListaClientes().buscarClientePorId(c1.getIdentificador()),c1);
	}
	
	public void testResetear()
	{
		ListaClientes.getListaClientes().anadirCliente(c1);
		ListaClientes.getListaClientes().resetear();
		assertNull(ListaClientes.getListaClientes().buscarClientePorId(1));

	}
	
}
