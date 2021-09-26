package org.pmoo.packlaboratorio3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FraccionTest
{
	Fraccion fraccion1;
	Fraccion fraccion2;
	Fraccion fraccion3;
	Fraccion fraccion4;
	@Before
	public void setUp() throws Exception 
	{	fraccion1 = new Fraccion(2,4);
	fraccion2 = new Fraccion(4,2);
	fraccion3 = new Fraccion(-7,3);
	fraccion4 = new Fraccion(-3,-7);
	}

	@After
	public void tearDown() throws Exception 
	{fraccion1=null;
	fraccion2=null;
	fraccion3=null;	
	fraccion4=null;
	}

	@Test
	public void testFraccion() 
	{
	assertEquals (fraccion1.getNumerador(),2);
	assertEquals (fraccion1.getDenominador(),4);
	assertEquals (fraccion2.getNumerador(),4);
	assertEquals (fraccion2.getDenominador(),2);
	assertEquals (fraccion3.getNumerador(),-7);
	assertEquals (fraccion3.getDenominador(),3);
	assertEquals (fraccion4.getNumerador(),-3);
	assertEquals (fraccion4.getDenominador(),-7);
	}
	
	@Test
	public void testGetNumerador() 
	{
		assertEquals(fraccion1.getNumerador(), 2);
		assertEquals(fraccion2.getNumerador(), 4);
		assertEquals(fraccion3.getNumerador(), -7);
		assertEquals(fraccion4.getNumerador(), -3);
	}

	@Test
	public void testSetNumerador() 
	{
		fraccion1.setNumerador(15);
		assertEquals(fraccion1.getNumerador(),15);
	}

	@Test
	public void testGetDenominador()
	{
		assertEquals(fraccion1.getDenominador(), 4);
		assertEquals(fraccion2.getDenominador(), 2);
		assertEquals(fraccion3.getDenominador(), 3);
		assertEquals(fraccion4.getDenominador(), -7);
	}

	@Test
	public void testSetDenominador() 
	{
		fraccion1.setDenominador(1);
		assertEquals(fraccion1.getDenominador(),1);
	}

	@Test
	public void testSimplificar() 
	{
		
		fraccion1.setNumerador(10);
		fraccion1.setDenominador(20);
		fraccion1.simplificar();
		assertEquals(fraccion1.getNumerador(), 1);
		assertEquals(fraccion1.getDenominador(), 2);
		
		fraccion1.setNumerador(-10);
		fraccion1.setDenominador(20);
		fraccion1.simplificar();
		assertEquals(fraccion1.getNumerador(), -1);
		assertEquals(fraccion1.getDenominador(), 2);
		
		fraccion1.setNumerador(10);
		fraccion1.setDenominador(-20);
		fraccion1.simplificar();
		assertEquals(fraccion1.getNumerador(), -1);
		assertEquals(fraccion1.getDenominador(), 2);
		
		fraccion1.setNumerador(-10);
		fraccion1.setDenominador(-20);
		fraccion1.simplificar();
		assertEquals(fraccion1.getNumerador(), 1);
		assertEquals(fraccion1.getDenominador(), 2);
		
	}

	@Test
	public void testSumar()
	{
		
		fraccion1.setNumerador(20);
		fraccion1.setDenominador(8);
		fraccion2.setNumerador(4);
		fraccion2.setDenominador(2);
		
		Fraccion resultado1=new Fraccion (0,0);
		
		resultado1=fraccion1.sumar(fraccion2);
		assertEquals(resultado1.getNumerador(),9);
		assertEquals(resultado1.getDenominador(), 2);
		
		fraccion1.setNumerador(20);
		fraccion1.setDenominador(8);
		fraccion2.setNumerador(0);
		fraccion2.setDenominador(2);
		
		resultado1=fraccion1.sumar(fraccion2);
		assertEquals(resultado1.getNumerador(),5);
		assertEquals(resultado1.getDenominador(), 2);
	}

	@Test
	public void testRestar() 
	{
		fraccion1.setNumerador(20);
		fraccion1.setDenominador(8);
		fraccion2.setNumerador(4);
		fraccion2.setDenominador(2);
		
		Fraccion resultado1=new Fraccion (0,0);
		
		resultado1=fraccion1.restar(fraccion2);
		assertEquals(resultado1.getNumerador(),1);
		assertEquals(resultado1.getDenominador(), 2);
	}

	@Test
	public void testMultiplicar()
	{
		fraccion1.setNumerador(20);
		fraccion1.setDenominador(8);
		fraccion2.setNumerador(4);
		fraccion2.setDenominador(2);
	
		Fraccion resultado1=new Fraccion (0,0);
	
		resultado1=fraccion1.multiplicar(fraccion2);
		assertEquals(resultado1.getNumerador(),5);
		assertEquals(resultado1.getDenominador(), 1);
	}

	@Test
	public void testDividir()
	{
		fraccion1.setNumerador(20);
		fraccion1.setDenominador(8);
		fraccion2.setNumerador(4);
		fraccion2.setDenominador(2);
	
		Fraccion resultado1=new Fraccion (0,0);
	
		resultado1=fraccion1.dividir(fraccion2);
		assertEquals(resultado1.getNumerador(),5);
		assertEquals(resultado1.getDenominador(), 4);
	}

	@Test
	public void testEsIgualQue() 
	{
		fraccion1.setNumerador(20);
		fraccion1.setDenominador(8);
		fraccion2.setNumerador(4);
		fraccion2.setDenominador(2);
		
		assertFalse(fraccion1.esIgualQue(fraccion2));
		
		fraccion2.setNumerador(20);
		fraccion2.setDenominador(8);
		
		assertTrue(fraccion1.esIgualQue(fraccion2));
	}

	@Test
	public void testEsMayorQue() 
	{
		fraccion2.setNumerador(10);
		fraccion2.setDenominador(2);
		
		assertFalse(fraccion1.esMayorQue(fraccion2));
		
		assertTrue(fraccion2.esMayorQue(fraccion1));
	}

	@Test
	public void testEsMenorQue()
	{
		
		assertTrue(fraccion1.esMenorQue(fraccion2));
		
		assertFalse(fraccion2.esMenorQue(fraccion1));
	}

	@Test
	public void testEsMayorOIgualQue()
	{
		fraccion1.setNumerador(20);
		fraccion1.setDenominador(8);
		fraccion2.setNumerador(10);
		fraccion2.setDenominador(2);
		
			assertFalse(fraccion1.esMayorOIgualQue(fraccion2));
			
		fraccion1.setNumerador(20);
		fraccion1.setDenominador(8);
		fraccion2.setNumerador(10);
		fraccion2.setDenominador(4);
			assertTrue(fraccion2.esMayorOIgualQue(fraccion1));
	}

	@Test
	public void testEsMenorOIgualQue() 
	{	
		assertTrue(fraccion1.esMenorOIgualQue(fraccion2));
		
		fraccion1.setNumerador(20);
		fraccion1.setDenominador(8);
		fraccion2.setNumerador(15);
		fraccion2.setDenominador(2);
		assertFalse(fraccion2.esMenorOIgualQue(fraccion1));
	}

}