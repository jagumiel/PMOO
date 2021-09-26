package org.pmoo.packlaboratorio3;

import junit.framework.TestCase;

public class FraccionTest extends TestCase 
{
	Fraccion fraccion1;
	Fraccion fraccion2;
	Fraccion fraccion3;
	Fraccion fraccion4;
	Fraccion fraccion5;
	Fraccion fraccion6;
	Fraccion fraccion7;
	Fraccion fraccion8;
	Fraccion fraccion9;
	

	protected void setUp() throws Exception 
	{
	super.setUp();
	fraccion1 = new Fraccion(5,2);
	fraccion2 = new Fraccion(2,7);
	fraccion3 = new Fraccion(-7,3);
	fraccion4 = new Fraccion(-7,-3);
	fraccion5 = new Fraccion(12,12);
	fraccion6 = new Fraccion(1,0);
	fraccion7 = new Fraccion(1,1);
	fraccion8 = new Fraccion(8,-4);
	fraccion9 = new Fraccion(2,4);
	}

	protected void tearDown() throws Exception 
	{
	fraccion1=null;
	fraccion2=null;
	fraccion3=null;	
	fraccion4=null;
	fraccion5=null;
	fraccion6=null;	
	fraccion7=null;
	fraccion8=null;
	fraccion9=null;	
	}

	public void testSetNumerador()
	{
		fraccion1.setNumerador(15);
		assertEquals(fraccion1.getNumerador(),15);
	}
	
	public void testGetNumerador()
	{
	assertEquals(fraccion1.getNumerador(), 5);
	assertEquals(fraccion2.getNumerador(), 2);
	assertEquals(fraccion3.getNumerador(), -7);
	assertEquals(fraccion4.getNumerador(), -7);
	assertEquals(fraccion5.getNumerador(), 12);
	assertEquals(fraccion6.getNumerador(), 1);
	assertEquals(fraccion7.getNumerador(), 1);
	assertEquals(fraccion8.getNumerador(), 8);
	assertEquals(fraccion9.getNumerador(), 2);
	}
	
	public void testSetDenominador()
	{
		fraccion1.setDenominador(1);
		assertEquals(fraccion1.getDenominador(),1);
	}
	
	public void testGetDenominador()
	{
	assertEquals(fraccion1.getDenominador(), 2);
	assertEquals(fraccion2.getDenominador(), 7);
	assertEquals(fraccion3.getDenominador(), 3);
	assertEquals(fraccion4.getDenominador(), -3);
	assertEquals(fraccion5.getDenominador(), 12);
	assertEquals(fraccion6.getDenominador(), 0);
	assertEquals(fraccion7.getDenominador(), 1);
	assertEquals(fraccion8.getDenominador(), -4);
	assertEquals(fraccion9.getDenominador(), 4);
	}
	
	public void testSimplificar()
	{
	Fraccion resultado1;
    resultado1 = new Fraccion(5,2);
    Fraccion fraccionB;
    fraccionB= new Fraccion (fraccion1.getNumerador(),fraccion1.getDenominador());
	fraccionB= fraccionB.simplificar();
	assertEquals(resultado1.getNumerador(), fraccionB.getNumerador());
	assertEquals(resultado1.getDenominador(), fraccionB.getDenominador());
	fraccionB=null;
	
	Fraccion resultado2;
    resultado2 = new Fraccion(2,7);
    fraccionB= new Fraccion (fraccion2.getNumerador(),fraccion2.getDenominador());
	fraccionB= fraccionB.simplificar();
	assertEquals(resultado2.getNumerador(), fraccionB.getNumerador());
	assertEquals(resultado2.getDenominador(), fraccionB.getDenominador());
	fraccionB=null;
	
	Fraccion resultado3;
    resultado3 = new Fraccion(-7,3);
    fraccionB= new Fraccion (fraccion3.getNumerador(),fraccion3.getDenominador());
	fraccionB= fraccionB.simplificar();
	assertEquals(resultado3.getNumerador(), fraccionB.getNumerador());
	assertEquals(resultado3.getDenominador(), fraccionB.getDenominador());
	fraccionB=null;
	
	Fraccion resultado4;
    resultado4 = new Fraccion(7,3);
    fraccionB= new Fraccion (fraccion4.getNumerador(),fraccion4.getDenominador());
	fraccionB= fraccionB.simplificar();
	assertEquals(resultado4.getNumerador(), fraccionB.getNumerador());
	assertEquals(resultado4.getDenominador(), fraccionB.getDenominador());
	fraccionB=null;
	
	Fraccion resultado5;
    resultado5 = new Fraccion(1,1);
    fraccionB= new Fraccion (fraccion5.getNumerador(),fraccion5.getDenominador());
	fraccionB= fraccionB.simplificar();
	assertEquals(resultado5.getNumerador(), fraccionB.getNumerador());
	assertEquals(resultado5.getDenominador(), fraccionB.getDenominador());
	fraccionB=null;
	
	
	Fraccion resultado7;
    resultado7 = new Fraccion(1,1);
    fraccionB= new Fraccion (fraccion7.getNumerador(),fraccion7.getDenominador());
	fraccionB= fraccionB.simplificar();
	assertEquals(resultado7.getNumerador(), fraccionB.getNumerador());
	assertEquals(resultado7.getDenominador(), fraccionB.getDenominador());
	fraccionB=null;
	
	Fraccion resultado8;
    resultado8 = new Fraccion(-2,1);
    fraccionB= new Fraccion (fraccion8.getNumerador(),fraccion8.getDenominador());
	fraccionB= fraccionB.simplificar();
	assertEquals(resultado8.getNumerador(), fraccionB.getNumerador());
	assertEquals(resultado8.getDenominador(), fraccionB.getDenominador());
	fraccionB=null;
	
	Fraccion resultado9;
    resultado9 = new Fraccion(1,2);
    fraccionB= new Fraccion (fraccion9.getNumerador(),fraccion9.getDenominador());
	fraccionB= fraccionB.simplificar();
	assertEquals(resultado9.getNumerador(), fraccionB.getNumerador());
	assertEquals(resultado9.getDenominador(), fraccionB.getDenominador());
	fraccionB=null;
	}
	
	
	public void testSumar()
	{
		Fraccion resultado1;
		resultado1=new Fraccion (39,14);
		Fraccion fraccionB;
		fraccionB=(fraccion1.sumar(fraccion2));
		assertEquals(resultado1.getNumerador(), fraccionB.getNumerador());
		assertEquals(resultado1.getDenominador(), fraccionB.getDenominador());
		fraccionB=null;
		
		Fraccion resultado2;
		resultado2=new Fraccion (1,6);
		fraccionB=(fraccion1.sumar(fraccion3));
		assertEquals(resultado2.getNumerador(), fraccionB.getNumerador());
		assertEquals(resultado2.getDenominador(), fraccionB.getDenominador());
		fraccionB=null;
		
		Fraccion resultado3;
		resultado3=new Fraccion (-3,2);
		fraccionB=(fraccion8.sumar(fraccion9));
		assertEquals(resultado3.getNumerador(), fraccionB.getNumerador());
		assertEquals(resultado3.getDenominador(), fraccionB.getDenominador());
		fraccionB=null;
	}
	
	public void testRestar()
	{

		Fraccion resultado1;
		resultado1=new Fraccion (31,14);
		Fraccion fraccionB;
		fraccionB=(fraccion1.restar(fraccion2));
		assertEquals(resultado1.getNumerador(), fraccionB.getNumerador());
		assertEquals(resultado1.getDenominador(), fraccionB.getDenominador());
		fraccionB=null;
		
		Fraccion resultado2;
		resultado2=new Fraccion (29,6);
		fraccionB=(fraccion1.restar(fraccion3));
		assertEquals(resultado2.getNumerador(), fraccionB.getNumerador());
		assertEquals(resultado2.getDenominador(), fraccionB.getDenominador());
		fraccionB=null;
		
		Fraccion resultado3;
		resultado3=new Fraccion (-5,2);
		fraccionB=(fraccion8.restar(fraccion9));
		assertEquals(resultado3.getNumerador(), fraccionB.getNumerador());
		assertEquals(resultado3.getDenominador(), fraccionB.getDenominador());
		fraccionB=null;
	}
	
	public void testMultiplicar()
	{
		Fraccion resultado1;
		resultado1=new Fraccion (5,7);
		Fraccion fraccionB;
		fraccionB=(fraccion1.multiplicar(fraccion2));
		assertEquals(resultado1.getNumerador(), fraccionB.getNumerador());
		assertEquals(resultado1.getDenominador(), fraccionB.getDenominador());
		fraccionB=null;
		
		Fraccion resultado2;
		resultado2=new Fraccion (-35,6);
		fraccionB=(fraccion1.multiplicar(fraccion3));
		assertEquals(resultado2.getNumerador(), fraccionB.getNumerador());
		assertEquals(resultado2.getDenominador(), fraccionB.getDenominador());
		fraccionB=null;
		
		Fraccion resultado3;
		resultado3=new Fraccion (-1,1);
		fraccionB=(fraccion8.multiplicar(fraccion9));
		assertEquals(resultado3.getNumerador(), fraccionB.getNumerador());
		assertEquals(resultado3.getDenominador(), fraccionB.getDenominador());
		fraccionB=null;
	}
	
	public void testDividir()
	{
		Fraccion resultado1;
		resultado1=new Fraccion (35,4);
		Fraccion fraccionB;
		fraccionB=(fraccion1.dividir(fraccion2));
		assertEquals(resultado1.getNumerador(), fraccionB.getNumerador());
		assertEquals(resultado1.getDenominador(), fraccionB.getDenominador());
		fraccionB=null;
		
		Fraccion resultado2;
		resultado2=new Fraccion (-15,14);
		fraccionB=(fraccion1.dividir(fraccion3));
		assertEquals(resultado2.getNumerador(), fraccionB.getNumerador());
		assertEquals(resultado2.getDenominador(), fraccionB.getDenominador());
		fraccionB=null;
		
		Fraccion resultado3;
		resultado3=new Fraccion (-4,1);
		fraccionB=(fraccion8.dividir(fraccion9));
		assertEquals(resultado3.getNumerador(), fraccionB.getNumerador());
		assertEquals(resultado3.getDenominador(), fraccionB.getDenominador());
		fraccionB=null;
	}
	
	public void testEsIgualQue()
	{
		assertFalse(fraccion1.esIgualQue(fraccion2));
		
		Fraccion fraccionB;
		fraccionB=new Fraccion(5,2);
		assertTrue(fraccion1.esIgualQue(fraccionB));
	}
	
	public void testEsMayorQue()
	{
		assertTrue(fraccion1.esMayorQue(fraccion2));
		
		assertFalse(fraccion2.esMayorQue(fraccion1));
	}
	
	public void testEsMenorQue()
	{
		assertTrue(fraccion2.esMenorQue(fraccion1));
		
		assertFalse(fraccion1.esMenorQue(fraccion2));
	}
	
	public void testEsMayorOIgualQue()
	{
		assertTrue(fraccion1.esMayorOIgualQue(fraccion2));
		
		Fraccion fraccionB;
		fraccionB=new Fraccion(5,2);
		assertTrue(fraccion1.esMayorOIgualQue(fraccionB));
		
		assertFalse(fraccion2.esMayorOIgualQue(fraccion1));
	}
	
	public void testEsMenorOIgualQue()
	{
		assertTrue(fraccion2.esMenorOIgualQue(fraccion1));
		
		Fraccion fraccionB;
		fraccionB=new Fraccion(5,2);
		assertTrue(fraccion1.esMenorOIgualQue(fraccionB));
		
		assertFalse(fraccion1.esMenorOIgualQue(fraccion2));
	}
	
}
