package org.pmoo.packexamen;

public class Representantes extends Empleado
{
	double salarioBase;
	ListaDeVentas listado;
	public Representantes(String pDatosPersonales, int pAntiguedad, String pId,int pSalarioBase, ListaDeVentas pListado)
	{
		super(pDatosPersonales,pAntiguedad,pId);
		this.salarioBase=pSalarioBase;
		this.listado=pListado;

	}

	public double calcularNomina()
	{
		if(listado.calcularVentas()>50000.0)
		{
			return salarioBase+(0.02*listado.calcularVentas());
		}
		else
		{
			return salarioBase;
		}
	}  
}
