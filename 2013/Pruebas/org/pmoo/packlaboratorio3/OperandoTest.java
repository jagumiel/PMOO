package org.pmoo.packlaboratorio3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class OperandoTest
{

	private Operando op1;
	private Operando op2;
	private Operando op3;
	
	@Before
	public void setUp() throws Exception
	{
		op1=new Operando(8);
		op2=new Operando(5);
		op3=new Operando(0);
	}

	@After
	public void tearDown() throws Exception
	{
		op1=null;
		op2=null;
		op3=null;
	}

	@Test
	public void testOperando() 
	{
		assertEquals(op1.getValor(),8);
	}

	@Test
	public void testSetValor()
	{
		op1.setValor(5);
		assertEquals(op1.getValor(),5);
	}

	@Test
	public void testSumar() 
	{
		op1.setValor(10);
		op2.setValor(5);
		op3=op1.sumar(op2);
		assertEquals(op3.getValor(),15);
		
		op1.setValor(-10);
		op3=op1.sumar(op2);
		assertEquals(op3.getValor(),-5);
		
		op1.setValor(10);
		op2.setValor(-5);
		op3=op1.sumar(op2);
		assertEquals(op3.getValor(),5);
	}

	@Test
	public void testRestar() 
	{
		op1.setValor(10);
		op2.setValor(5);
		op3=op1.restar(op2);
		assertEquals(op3.getValor(),5);
		
		op1.setValor(-10);
		op3=op1.restar(op2);
		assertEquals(op3.getValor(),-15);
		
		op1.setValor(10);
		op2.setValor(-5);
		op3=op1.restar(op2);
		assertEquals(op3.getValor(),15);
	}

	@Test
	public void testMultiplicar()
	{
		op1.setValor(10);
		op2.setValor(5);
		op3=op1.multiplicar(op2);
		assertEquals(op3.getValor(),50);
		
		op1.setValor(-10);
		op3=op1.multiplicar(op2);
		assertEquals(op3.getValor(),-50);
		
		op1.setValor(10);
		op2.setValor(-5);
		op3=op1.multiplicar(op2);
		assertEquals(op3.getValor(),-50);
	}

	@Test
	public void testDividir() 
	{
		op1.setValor(10);
		op2.setValor(5);
		op3=op1.dividir(op2);
		assertEquals(op3.getValor(),2);
		
		op1.setValor(-10);
		op3=op1.dividir(op2);
		assertEquals(op3.getValor(),-2);
		
		op1.setValor(10);
		op2.setValor(-5);
		op3=op1.dividir(op2);
		assertEquals(op3.getValor(),-2);
	}

	@Test
	public void testGetResto() 
	{
		op1.setValor(10);
		op2.setValor(5);
		op3=op1.getResto(op2);
		assertEquals(op3.getValor(),0);
		
		op1.setValor(-10);
		op3=op1.getResto(op2);
		assertEquals(op3.getValor(),0);
		
		op1.setValor(10);
		op2.setValor(3);
		op3=op1.getResto(op2);
		assertEquals(op3.getValor(),1);
	}

}
