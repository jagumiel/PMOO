package org.pmoo.packlaboratorio4;


import junit.framework.TestCase;

public class OperacionTest extends TestCase 
{

	Operacion op1;
	Operacion op2;
	Operacion op3;
	Cliente c1;
	Cliente c2;
	Cliente c3;

	protected void setUp() throws Exception
	{
		super.setUp();
		op1 = new Operacion(01, 0563, "2489", 300.0);
		c1 = new Cliente(0563, "Francisco", "2489", 1000.0, true);
		ListaClientes.getListaClientes().anadirCliente(c1);
		op2 = new Operacion(02, 0567, "5381", 500.0);
		c2 = new Cliente(0567, "default", "5381", 1000.0, false);
		ListaClientes.getListaClientes().anadirCliente(c2);
		op3 = new Operacion(03, 0565, "1234", 300.0);
		c3=new Cliente(0565, "NotAvailable", "1234", 100.0, true);
		ListaClientes.getListaClientes().anadirCliente(c3);
	}

	protected void tearDown() throws Exception 
	{
		super.tearDown();
		op1=null;
		op2=null;
		op3=null;
		c1=null;
		c2=null;
		c3=null;
		ListaClientes.getListaClientes().resetear();
		}
	
	public void testGetIdOperacion()
	{
		op1.getIdOperacion();
		assertEquals(op1.getIdOperacion(),01);
	}
	
	public void testGetIdCliente()
	{
		op1.getIdCliente();
		assertEquals(op1.getIdCliente(),0563);
	}
	
	public void testRealizarOperacion()
	{
		assertEquals(op1.getIdCliente(),c1.getIdentificador());
		assertTrue(c1.comprobarClave("2489"));
		op1.realizarOperacion();
		assertEquals(700.0, c1.getSaldo());
		
		assertEquals(op1.getIdCliente(),c1.getIdentificador());
		assertFalse(c1.comprobarClave("-2489"));
		op1.realizarOperacion();
		assertEquals(400.0, c1.getSaldo());
		
		assertEquals(op2.getIdCliente(),c2.getIdentificador());
		assertFalse(c2.comprobarClave("2489"));
		op2.realizarOperacion();
		assertEquals(499.50, c2.getSaldo());
		
		assertNotSame(op1.getIdCliente(),c2.getIdentificador());
		assertTrue(c2.comprobarClave("5381"));
		op1.realizarOperacion();
		assertEquals(500.0, c2.getSaldo());
		
		assertEquals(op3.getIdCliente(),c3.getIdentificador());
		assertTrue(c3.comprobarClave("1234"));
		op3.realizarOperacion();
		assertEquals(100.0, c3.getSaldo());
		
		
	}
}
