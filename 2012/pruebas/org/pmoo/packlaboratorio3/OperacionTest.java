package org.pmoo.packlaboratorio3;

import org.pmoo.packlaboratorio3.Operacion.Operador;

import junit.framework.TestCase;

public class OperacionTest extends TestCase 

{
	Operacion op1,op2,op3,op4,op5;
	
	protected void setUp()
	{
		op1 = new Operacion (0,1,Operador.SUMA);
		op2 = new Operacion (-1,-1, Operador.RESTA);
		op3 = new Operacion (3,-2,Operador.PRODUCTO);
		op4 = new Operacion (6,2,Operador.COCIENTE);
		op5 = new Operacion (10,9,Operador.RESTO);
	}

	protected void tearDown() 
	{
		op1=null;
	}
	public void testObtenerResultados()
	{
		assertEquals(op1.obtenerResultado(),1);
		assertEquals(op2.obtenerResultado(),0);
		assertEquals(op3.obtenerResultado(),-6);
		assertEquals(op4.obtenerResultado(),3);
		assertEquals(op5.obtenerResultado(),1);		
	}
}