package org.pmoo.packlaboratorio3;

import junit.framework.TestCase;

public class OperandoTest extends TestCase {

	Operando op1;
	Operando op2;
	Operando op3;

	protected void setUp() throws Exception
	
	{
	super.setUp();
	op1 = new Operando(5);
	op2 = new Operando(1);
	op3 = new Operando(0);
	}

	protected void tearDown() throws Exception 
	{
	op1=null;
	op2=null;
	op3=null;
	}

	public void testSumar()
		{
		op3= op1.sumar(op2);
		assertEquals(op3.getValor(),6);
		op1.setValor(-4);
		op2.setValor(2);
		op3= op1.sumar(op2);
		assertEquals(op3.getValor(),-2);
		op1.setValor(4);
		op2.setValor(-2);
		op3= op1.sumar(op2);
		assertEquals(op3.getValor(),2);
		op1.setValor(-4);
		op2.setValor(-2);
		op3= op1.sumar(op2);
		assertEquals(op3.getValor(),-6);
		}
	
	public void testRestar()
	{
	op3 = op1.restar(op2);
	assertEquals(op3.getValor(),4);
	op1.setValor(-4);
	op2.setValor(2);
	op3= op1.restar(op2);
	assertEquals(op3.getValor(),-6);
	op1.setValor(4);
	op2.setValor(-2);
	op3= op1.restar(op2);
	assertEquals(op3.getValor(),6);
	op1.setValor(-4);
	op2.setValor(-2);
	op3= op1.restar(op2);
	assertEquals(op3.getValor(),-2);
	}
	
	public void testMultiplicar()
	{
		op3 = op1.multiplicar(op2);
		assertEquals(op3.getValor(),5);
		op1.setValor(-4);
		op2.setValor(2);
		op3= op1.multiplicar(op2);
		assertEquals(op3.getValor(),-8);
		op1.setValor(4);
		op2.setValor(-2);
		op3= op1.multiplicar(op2);
		assertEquals(op3.getValor(),-8);
		op1.setValor(-4);
		op2.setValor(-2);
		op3= op1.multiplicar(op2);
		assertEquals(op3.getValor(),8);
		}
	
	public void testDividir()
	{
		op3 = op1.dividir(op2);
		assertEquals(op3.getValor(),5);
		op1.setValor(-4);
		op2.setValor(2);
		op3= op1.dividir(op2);
		assertEquals(op3.getValor(),-2);
		op1.setValor(4);
		op2.setValor(-2);
		op3= op1.dividir(op2);
		assertEquals(op3.getValor(),-2);
		op1.setValor(-4);
		op2.setValor(-2);
		op3= op1.dividir(op2);
		assertEquals(op3.getValor(),2);
		
	}
	
	public void testgetResto()
	{
		op3 = op1.getResto(op2);
		assertEquals(op3.getValor(),0);
		op1.setValor(-5);
		op2.setValor(2);
		op3= op1.getResto(op2);
		assertEquals(op3.getValor(),-1);			
	}
	
	
	
	
	
	
	
	
}
