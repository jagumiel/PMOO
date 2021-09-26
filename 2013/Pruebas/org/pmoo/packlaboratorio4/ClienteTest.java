package org.pmoo.packlaboratorio4;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ClienteTest {
	Cliente cliente1;
	@Before
	public void setUp() throws Exception
	{
		cliente1=new Cliente(1234,"Mikel","0000",2500.0,true);
	}
	@After
	public void tearDown() throws Exception
	{
		cliente1=null;
	}
	@Test
	public void testCliente()
	{
		assertEquals(cliente1.tieneMismoId(1234),true);
		assertEquals(cliente1.obtenerSaldo("0000"),2500,0);
		assertFalse(cliente1.obtenerSaldo("0000")==100.0);
		assertTrue(cliente1.getEsPreferente());
	}
	@Test
	public void testGetEsPreferente() 
	{
		assertTrue(cliente1.getEsPreferente());
	}
	@Test
	public void testTieneMismoId() 
	{
		assertTrue(cliente1.tieneMismoId(1234));
		assertFalse(cliente1.tieneMismoId(144));
	}
	@Test
	public void testObtenerSaldo() 
	{
		assertFalse(cliente1.obtenerSaldo("0010")==2500.0);
		assertFalse(cliente1.obtenerSaldo("0000")==200.0);
	}
	@Test
	public void testActualizarSaldo()
	{
		cliente1.actualizarSaldo("0001", 300.0);
		assertFalse(cliente1.obtenerSaldo("0000")!=2500.0);
		cliente1.actualizarSaldo("0000", 0.0);
		assertFalse(cliente1.obtenerSaldo("0000")!=2500.0);
		cliente1.actualizarSaldo("0000", -234);
		assertFalse(cliente1.obtenerSaldo("0000")!=2500.0);
		cliente1.actualizarSaldo("0000",500.0);
		assertTrue(cliente1.obtenerSaldo("0000")==2000.0);
	}
}