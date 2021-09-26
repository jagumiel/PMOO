package org.pmoo.packlaboratorio4;

import junit.framework.TestCase;


public class ListaOperacionesTest extends TestCase 
{
	private Operacion op1, op2,op3, op4;
	private Cliente c1, c2;

	protected void setUp() throws Exception 
	{
		super.setUp();
		op1 = new Operacion(01, 0563, "2489", 300.0);
		op3 = new Operacion(03, 0563, "2489", 400.0);
		op2 = new Operacion(02, 0567, "5381", 500.0);
		op4 = new Operacion(04, 0567, "5381", 100.0);
		c1 = new Cliente(0563, "Francisco", "2489", 1000.0, true);
		c2 = new Cliente(0567, "default", "5381", 1200.0, false);
		ListaOperaciones.getListaOperaciones().anadirOperacion(op1);
		ListaOperaciones.getListaOperaciones().anadirOperacion(op2);
		ListaOperaciones.getListaOperaciones().anadirOperacion(op3);
		ListaOperaciones.getListaOperaciones().anadirOperacion(op4);
		ListaClientes.getListaClientes().anadirCliente(c1);
		ListaClientes.getListaClientes().anadirCliente(c2);

				
	}

	protected void tearDown() throws Exception 
	{
		super.tearDown();
		op1=null;
		op2=null;
		op3=null;
		op4=null;
		c1=null;
		c1=null;
		ListaOperaciones.getListaOperaciones().resetear();
		ListaClientes.getListaClientes().resetear();
	}
	
	public void testGetListaOperaciones()
	{
		ListaOperaciones.getListaOperaciones().anadirOperacion(op1);
		assertNotNull(ListaOperaciones.getListaOperaciones());
	}

	public void testAnadirOperacion()
	{
		ListaOperaciones.getListaOperaciones().anadirOperacion(op2);
		assertNotNull(ListaOperaciones.getListaOperaciones());
	}
	
	public void testRealizarOperaciones()
	{
		ListaOperaciones.getListaOperaciones().realizarOperaciones();
		assertEquals(300.0, c1.getSaldo());
		assertEquals(600.0, c2.getSaldo());	}
	
	public void testResetear()
	{
		ListaOperaciones.getListaOperaciones().resetear();
		assertNotNull (ListaOperaciones.getListaOperaciones());
	}
}
