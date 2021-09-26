package org.pmoo.packlaboratorio4;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ListaClientesTest {
	ListaClientes li;
	@Before
	public void setUp() throws Exception 
	{
		li=ListaClientes.getListaClientes();
		li.anadirCliente(10,"Mikel","0010",2500.0,true);
		li.anadirCliente(12,"Josu","0012",3500.0,false);
		li.anadirCliente(14,"Mikel","0014",5500.0,true);
	}
	@After
	public void tearDown() throws Exception 
	{
		li.resetear();
	}
	@Test
	public void testGetListaClientes()
	{	
		ListaClientes I;
		I=ListaClientes.getListaClientes();
		assertEquals(I,li);
	}
	@Test
	public void testCantidadClientes()
	{
		assertEquals(li.cantidadClientes(),3);
	}
	@Test
	public void testAnadirCliente()
	{
		li.anadirCliente(10,"Mikel","0010",2500.0,true);
		assertEquals(li.cantidadClientes(),3);
		li.anadirCliente(15,"Mikel","0010",2500.0,true);
		assertEquals(li.cantidadClientes(),4);
	}
	@Test
	public void testBuscarClientePorId() 
	{
		assertNotNull(li.buscarClientePorId(10));
		assertNull(li.buscarClientePorId(17));
	}
	@Test
	public void testResetear()
	{
		li.resetear();
		assertNull(li.buscarClientePorId(10));
		assertNull(li.buscarClientePorId(12));
		assertNull(li.buscarClientePorId(14));
	}
}