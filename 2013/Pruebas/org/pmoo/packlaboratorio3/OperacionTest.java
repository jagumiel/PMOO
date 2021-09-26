package org.pmoo.packlaboratorio3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.pmoo.packlaboratorio3.Operacion.Operador;


public class OperacionTest {
	
	private Operacion operacion1;

	@Before
	public void setUp() throws Exception 
	{
		operacion1= new Operacion(5,8);
	}

	@After
	public void tearDown() throws Exception 
	{
		operacion1=null;
	}

	@Test
	public void testOperacion() 
	{
		assertEquals(operacion1.getOperando1(),5);
		assertEquals(operacion1.getOperando2(),8);
		assertEquals(operacion1.getOperador(),null);
	}


	@Test
	public void testSetOperando1() 
	{
		operacion1.setOperando1(90);
		assertEquals(operacion1.getOperando1(),90);
	}

	@Test
	public void testSetOperando2()
	{
		operacion1.setOperando2(70);
		assertEquals(operacion1.getOperando2(),70);
	}

	@Test
	public void testSetOperador() 
	{
		operacion1.setOperador(Operador.RESTA);
		assertEquals(operacion1.getOperador(),Operador.RESTA);
	}

	@Test
	public void testObtenerResultado() 
	{
		
		operacion1.setOperando1(10);
		operacion1.setOperando2(5);
		
		assertEquals(operacion1.obtenerResultado(Operador.SUMA),15);
		assertEquals(operacion1.obtenerResultado(Operador.RESTA),5);
		assertEquals(operacion1.obtenerResultado(Operador.PRODUCTO),50);
		assertEquals(operacion1.obtenerResultado(Operador.COCIENTE),2);
		assertEquals(operacion1.obtenerResultado(Operador.RESTO),0);
	}

}
