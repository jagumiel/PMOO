package org.pmoo.packlaboratorio4;
import java.util.ArrayList;		
import java.util.Iterator;
public class ListaOperaciones 
{	
	private ArrayList<Operacion> lista;
	private static ListaOperaciones miListaOperaciones = new ListaOperaciones();
	private ListaOperaciones()
	{ 	
		this.lista= new ArrayList<Operacion>();
	}
	public static ListaOperaciones getListaOperaciones()
	{	
		return miListaOperaciones;
	}
  	// otros metodos
 	private Iterator<Operacion> getIterador()
 	{	
 		return this.lista.iterator();
 	}
 	
 	public int cantidadOperaciones()
 	{	
 		return this.lista.size();
 	}
 	public void anadirOperacion(int pIdOperacion, int pIdCliente, String pClaveTecleada, double pCantidad)
 	{	
 		Operacion X=(this.buscarOperacionPorId(pIdOperacion));
 		if (X==null)
		{
 			X= new Operacion(pIdOperacion, pIdCliente,pClaveTecleada,pCantidad);
 			this.lista.add(X);
		}
 		else 
 		{	System.out.println("No se puede esta añadido");}
 		
 	}
	public Operacion buscarOperacionPorId(int pId)
 	{	
 		Operacion unaOperacion;
		Iterator<Operacion> itr = ListaOperaciones.getListaOperaciones().getIterador();
			while (itr.hasNext())
			{
				unaOperacion=itr.next(); 
				if(unaOperacion.tieneMismoId(pId))
				{return unaOperacion;}
			}
		return null;
 	}

 	public void realizarOperaciones()
 	{
 		Operacion unaOperacion;
		Iterator<Operacion> itr = ListaOperaciones.getListaOperaciones().getIterador();
		while(itr.hasNext())
		{
			unaOperacion=itr.next();
			unaOperacion.realizarOperacion();
		}
 	}
 	
 	public void resetear()
 	{	this.lista.clear();
 	
 	}
}	