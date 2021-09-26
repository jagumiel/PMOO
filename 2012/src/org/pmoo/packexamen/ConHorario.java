package org.pmoo.packexamen;

public abstract class ConHorario extends Empleado
{
	private Quincena listaDias;
	
	public ConHorario(String pDatosPersonales, int pAntiguedad, String pId,Quincena pListaDias)
	{
		super(pDatosPersonales,pAntiguedad,pId);
		this.listaDias=pListaDias;
	}
	
	protected Quincena getListaDias()
	{
		return this.listaDias;
	}
	
	protected double CalcularHoras()
	{
		return this.getListaDias().calcularHoras();
	}
}
