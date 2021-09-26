package org.pmoo.packexamen;

import java.util.*;
import java.util.ArrayList;

public class Quincena 
{
	ArrayList<Dia> lista;
	
	public Quincena()
	{
		this.lista= new ArrayList<Dia>();
	}
	
	public ArrayList<Dia> getLista()
	{
		return this.lista;
	}
	public Iterator<Dia> getIterador()
	{
		return this.getLista().iterator();
	}
	public double calcularHoras()
	{
		Dia unDia=null;
		Iterator<Dia> itr=this.getIterador();
		double suma=0.0;
		while(itr.hasNext())
		{
			unDia=itr.next();
			suma= suma + (unDia.horaSalida-unDia.horaEntrada);
		}
		return suma;
	}
}
