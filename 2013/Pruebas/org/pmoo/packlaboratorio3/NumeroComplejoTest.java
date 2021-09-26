package org.pmoo.packlaboratorio3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class NumeroComplejoTest {
	
	private NumeroComplejo num1;
	private NumeroComplejo num2;
	private IComplejo num3;

	@Before
	public void setUp() throws Exception 
	{
		num1=new NumeroComplejo(1,-1);
		num2=new NumeroComplejo(2,2);
		num3=new NumeroComplejo(1,3);
	}

	@After
	public void tearDown() throws Exception
	{
		num1=null;
		num2=null;
		num3=null;
	}

	@Test
	public void testNumeroComplejo() 
	{
		assertEquals(num1.getParteReal(),1,0);
		assertEquals(num1.getParteImaginaria(),-1,0);
	}


	@Test
	public void testSetParteReal()
	{
		num1.setParteReal(5);
		assertEquals(num1.getParteReal(),5,0);
	}

	@Test
	public void testSetParteImaginaria() 
	{
		num1.setParteImaginaria(2);
		assertEquals(num1.getParteImaginaria(),2,0);
	}

	@Test
	public void testGetAngulo() 
	{
		num1.setParteReal(1);
		num1.setParteImaginaria(1);
		num2.setParteReal(1);
		num2.setParteImaginaria(-1);
		assertEquals(num1.getAngulo(),45,0);
		assertEquals(num2.getAngulo(),-45,0);
	}

	@Test
	public void testGetModulo() 
	{
		num1.setParteReal(1);
		num1.setParteImaginaria(0);
		
		assertEquals(num1.getModulo(),1,0);

	}

	@Test
	public void testSumar() 
	{
		num1.setParteReal(1);
		num1.setParteImaginaria(1);
		
		num2.setParteReal(1);
		num2.setParteImaginaria(2);
		
		num3=num1.sumar(num2);
		assertEquals(num3.getParteReal(),2,0);
		assertEquals(num3.getParteImaginaria(),3,0);
	}

	@Test
	public void testMultiplicar() 
	{

		num3=num1.multiplicar(num2);
		assertEquals(num3.getParteReal(),4,0);
		assertEquals(num3.getParteImaginaria(),0,0);
	}

	@Test
	public void testEsIgual() 
	{
		num1.setParteReal(1);
		num1.setParteImaginaria(1);
		num2.setParteReal(1);
		num2.setParteImaginaria(1);
		
		assertTrue(num1.esIgual(num2));
		
		num2.setParteReal(1);
		num2.setParteImaginaria(3);
		
		assertFalse(num1.esIgual(num2));
	}

}
