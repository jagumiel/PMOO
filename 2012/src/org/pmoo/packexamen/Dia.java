package org.pmoo.packexamen;

public class Dia
{
	double horaEntrada;
	double horaSalida;
	public Dia(int pHoraEntrada, int pHoraSalida)
	{
		this.horaEntrada=pHoraEntrada;
		this.horaSalida=pHoraSalida;
	}
	
	public double getHoraEntrada()
	{
		return this.horaEntrada;
	}
	
	public double getHoraSalida()
	{
		return this.horaSalida;
	}
	
	public void setHoraEntrada(int pHoraEntrada)
	{
		this.horaEntrada=pHoraEntrada;
	}
	
	public void setHoraSalida(int pHoraSalida)
	{
		this.horaSalida=pHoraSalida;
	}
}
