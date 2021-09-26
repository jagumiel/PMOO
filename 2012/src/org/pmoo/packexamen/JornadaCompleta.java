package org.pmoo.packexamen;

public class JornadaCompleta extends ConHorario 
{	double salarioBase;

	public JornadaCompleta(String pDatosPersonales, int pAntiguedad, String pId,Quincena pListaDias,double pSalarioBase)
	{
		super(pDatosPersonales,pAntiguedad,pId,pListaDias);
		this.salarioBase=pSalarioBase;
		
	}
	
	public double calcularNomina()
	{
		if(this.CalcularHoras()<=80.0)
		{
			return this.salarioBase;
		}
		else
		{
			return (this.CalcularHoras()-80.0)*(1.5*(salarioBase/80))+salarioBase;
		}
	}
	
}
