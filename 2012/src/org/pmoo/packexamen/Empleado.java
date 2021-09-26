package org.pmoo.packexamen;

public abstract class Empleado
{
	protected String datosPersonales;
	protected int antiguedad;
	protected String id;
	public Empleado(String pDatosPersonales, int pAntiguedad, String pId)
	{
		this.datosPersonales=pDatosPersonales;
		this.antiguedad=pAntiguedad;
		this.id=pId;
	}
	
	public void imprimirNomina()
	{
		System.out.println("Su nomina es de" + this.calcularNomina() +"€");
	}
	protected abstract double calcularNomina();
}
