package org.pmoo.proyecto;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CasillaLiderTest
{
	PersonajeDelMapa lider;
	Fuego cartaFuego1;
	
	PersonajeDelMapa entrenador;
	Agua cartaAgua1;
	
	CasillaLider casilla;
	
	@Before
	public void setUp() throws Exception
	{
		this.cartaFuego1=new Fuego("Antorcha",1);
		this.lider=new PersonajeDelMapa("Pudge",this.cartaFuego1);
		
		this.cartaAgua1=new Agua("Ola",1);
		this.entrenador=new PersonajeDelMapa("Morphlin",this.cartaAgua1);
		
		this.casilla=new CasillaLider(this.entrenador,this.lider);
	}
	@After
	public void tearDown() throws Exception 
	{
		this.casilla=null;
		this.cartaAgua1=null;
		this.cartaFuego1=null;
		this.entrenador=null;
		this.lider=null;
	}
	@Test
	public void testCasillaLider() 
	{
		assertEquals(this.lider,this.casilla.getLider());
		assertEquals(this.casilla.getVecesDerrotado(),0);
	}
	@Test
	public void testLucharConLider() 
	{
		assertEquals(0,this.casilla.getVecesDerrotado());
		assertEquals(this.casilla.getHaGanadoALider(),false);
	}

}
