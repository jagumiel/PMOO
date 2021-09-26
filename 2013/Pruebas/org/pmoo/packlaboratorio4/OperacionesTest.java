package org.pmoo.packlaboratorio4;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class OperacionesTest {
	Operacion op1;
	Operacion op2;
	Operacion op3;
	Operacion op4;
	Operacion op5;
	@Before
	public void setUp() throws Exception 
	{
		op1 = new Operacion(1000,10,"0010",1000);
		ListaClientes.getListaClientes().anadirCliente(10,"Mikel","0010",2500.0,true);
		op2 = new Operacion(2000,12,"0012",0);
		ListaClientes.getListaClientes().anadirCliente(12,"Josu","0012",3500.0,false);
		op3 = new Operacion(3000,14,"0014",-1000);
		ListaClientes.getListaClientes().anadirCliente(14,"Ander","0014",5500.0,true);
	}
	@After
	public void tearDown() throws Exception
	{
		op1=null;
		op2=null;
		op3=null;
		ListaClientes.getListaClientes().resetear();
	}
	@Test
	public void testOperacion() 
	{		
		assertEquals(op1.tieneMismoId(1000),true);
		assertFalse(op1.tieneMismoId(2000));
		op1.realizarOperacion();
		assertTrue(ListaClientes.getListaClientes().buscarClientePorId(10).obtenerSaldo("0010")==1500.0);
	}
	@Test
	public void testTieneMismoId() 
	{
		assertEquals(op1.tieneMismoId(1000),true);
		assertFalse(op1.tieneMismoId(2000));
	}
	@Test
	public void testRealizarOperacion()
	{
		op1.realizarOperacion();
		assertTrue(ListaClientes.getListaClientes().buscarClientePorId(10).obtenerSaldo("0010")==1500.0);
		op2.realizarOperacion();
		assertTrue(ListaClientes.getListaClientes().buscarClientePorId(12).obtenerSaldo("0012")==3500.0);
		op3.realizarOperacion();
		assertEquals(ListaClientes.getListaClientes().buscarClientePorId(14).obtenerSaldo("0014"),5500,0);
		op4 = new Operacion(4000,10,"0017",100);
		assertEquals(ListaClientes.getListaClientes().buscarClientePorId(10).obtenerSaldo("0010"),1500,0);	
		op5 = new Operacion(5000,17,"0012",50);
		assertEquals(ListaClientes.getListaClientes().buscarClientePorId(12).obtenerSaldo("0012"),3500,0);	
	}
}