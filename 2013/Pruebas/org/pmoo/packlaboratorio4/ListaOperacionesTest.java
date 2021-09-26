package org.pmoo.packlaboratorio4;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ListaOperacionesTest
{
	@Before
	public void setUp() throws Exception 
	{
		ListaClientes.getListaClientes().anadirCliente(10,"Mikel","0010",2500.0,true);
		ListaClientes.getListaClientes().anadirCliente(12,"Josu","0012",3500.0,false);
		ListaClientes.getListaClientes().anadirCliente(14,"Ander","0014",5500.0,true);
		ListaOperaciones.getListaOperaciones().anadirOperacion(1,10,"0010",1000);
		ListaOperaciones.getListaOperaciones().anadirOperacion(2,12,"0012",0);
		ListaOperaciones.getListaOperaciones().anadirOperacion(3,14,"0014",-1000);
	}
	@After
	public void tearDown() throws Exception 
	{
		ListaClientes.getListaClientes().resetear();
		ListaOperaciones.getListaOperaciones().resetear();
	}
	@Test
	public void testGetListaOperaciones() 
	{
		assertNotNull(ListaOperaciones.getListaOperaciones());
	}
	@Test
	public void testCantidadOperaciones() 
	{
		assertEquals(ListaOperaciones.getListaOperaciones().cantidadOperaciones(),3);
	}
	@Test
	public void testAnadirOperacion()
	{
		ListaOperaciones.getListaOperaciones().anadirOperacion(4,10,"0010",500);
		assertEquals(ListaOperaciones.getListaOperaciones().cantidadOperaciones(),4);
	}
	@Test
	public void testBuscarOperacionPorId() 
	{
		assertNotNull(ListaOperaciones.getListaOperaciones().buscarOperacionPorId(3));
	}
	@Test
	public void testRealizarOperaciones() 
	{
		ListaOperaciones.getListaOperaciones().realizarOperaciones();
		assertEquals(ListaClientes.getListaClientes().buscarClientePorId(10).obtenerSaldo("0010"),1500,0);
		assertEquals(ListaClientes.getListaClientes().buscarClientePorId(12).obtenerSaldo("0012"),3500,0);
		assertEquals(ListaClientes.getListaClientes().buscarClientePorId(14).obtenerSaldo("0014"),5500,0);
	}
	@Test
	public void testResetear() 
	{
		ListaOperaciones.getListaOperaciones().resetear();
		assertNotNull(ListaOperaciones.getListaOperaciones());
	}
}