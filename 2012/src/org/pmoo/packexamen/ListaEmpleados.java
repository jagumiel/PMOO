package org.pmoo.packexamen;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaEmpleados 
{
	private ArrayList<Empleado> lista;
	private static ListaEmpleados miListaEmpleados= new ListaEmpleados();


	private ListaEmpleados()
	{
		this.lista=new ArrayList<Empleado>();
	}

	public static ListaEmpleados getMiListaEmpleados()
	{
		return miListaEmpleados;
	}
	
	public ArrayList<Empleado> getLista()
	{
		return this.lista;
	}
	public Iterator<Empleado> getIterador()
	{
		return this.getLista().iterator();
	}
	
	private void imprimirTodasLasNominas()
	{
		Empleado unEmpleado=null;
		Iterator<Empleado> itr= this.getIterador();
		
		while(itr.hasNext())
		{
			unEmpleado=itr.next();
			unEmpleado.imprimirNomina();
	    }
	}
	
	private void calcularTodasLasNominas()
	{
		Empleado unEmpleado=null;
		Iterator<Empleado> itr= this.getIterador();
		
		while(itr.hasNext())
		{
			unEmpleado=itr.next();
			unEmpleado.calcularNomina();
		}
	}
}