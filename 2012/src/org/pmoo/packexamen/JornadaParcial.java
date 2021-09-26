package org.pmoo.packexamen;

public class JornadaParcial extends ConHorario
{   
	 
	public JornadaParcial(String pDatosPersonales, int pAntiguedad, String pId,Quincena pListaDias)
	{
		super(pDatosPersonales,pAntiguedad,pId,pListaDias);
	}
	
	
	public double calcularNomina()
	{  
		return (super.CalcularHoras() * 34.56);
	}
	
	/*
	 	public void imprimirNomina()
		{
			super.imprimirNomina();
		}
	*/

}
