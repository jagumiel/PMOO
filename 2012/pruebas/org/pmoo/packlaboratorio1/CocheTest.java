package org.pmoo.packlaboratorio1;

import junit.framework.TestCase;

public class CocheTest extends TestCase 
{
	private Coche c1;

	protected void setUp()
	{
		c1 = new Coche();
	}

	protected void tearDown()
	{
		c1 = null;
	}
	
	public void testSetMatricula()
	{
		c1.setMatricula("BI3956BP");
		assertEquals ("BI3956BP", c1.getMatricula());
	}
	
	public void testSetMarcaModelo()
	{
		c1.setMarcaModelo("Dodge Viper");
		assertEquals ("Dodge Viper", c1.getMarcaModelo());
	}
	
	public void testSetPropietario()
	{
		Persona p1=new Persona();
		c1.setPropietario(p1);
		assertEquals (p1, c1.getPropietario());
	}

}
