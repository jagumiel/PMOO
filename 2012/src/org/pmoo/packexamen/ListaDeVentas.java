package org.pmoo.packexamen;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaDeVentas
{
	private ArrayList<Venta> lista;
	
	public ListaDeVentas()
	{
	 this.lista= new ArrayList<Venta>();
	}
	
	public ArrayList<Venta> getLista()
	{
		return this.lista;
	}
	
	public Iterator<Venta> getIterador()
	{
		return this.getLista().iterator();
	}
	
	public double calcularVentas()
	{
		Venta unaVenta=null;
		Iterator<Venta> itr= this.getIterador();
		double suma=0.0;
		while(itr.hasNext())
		{	unaVenta=itr.next();
			suma= suma + (unaVenta.precio*unaVenta.cantidad);
		}
		
		return suma;
	}
}
