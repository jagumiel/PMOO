package org.pmoo.proyecto;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CombateTest 
{
	
	Fuego cartaFuego1;
	Fuego cartaFuego2;
	Agua cartaAgua1;
	Agua cartaAgua2;
	Hoja cartaHoja1;
	Hoja cartaHoja2;
	Psico cartaPsico1;
	Psico cartaPsico2;
	
	@Before
	public void setUp() throws Exception 
	{
		this.cartaFuego1=new Fuego("Antorcha",10);
		this.cartaFuego2=new Fuego("Tea",5);
		this.cartaAgua1=new Agua("Ola",10);
		this.cartaAgua2=new Agua("Tsunami",80);
		this.cartaHoja1=new Hoja("Rama",20);
		this.cartaHoja2=new Hoja("Raiz",50);
		this.cartaPsico1=new Psico("Migraña",40);
		this.cartaPsico2=new Psico("Alzeimer",4);
		
	}

	@After
	public void tearDown() throws Exception 
	{
		this.cartaFuego1=null;
		this.cartaFuego2=null;
		this.cartaAgua1=null;
		this.cartaAgua2=null;
		this.cartaHoja1=null;
		this.cartaHoja2=null;
		this.cartaPsico1=null;
		this.cartaPsico2=null;
	}

	@Test
	public void testCombate() 
	{
		Combate lucha=new Combate(cartaFuego1,cartaFuego2);
		
	}

	@Test
	public void testGetCarta1() 
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetCarta2() {
		fail("Not yet implemented");
	}

	@Test
	public void testSimularCombate() {
		fail("Not yet implemented");
	}

}
