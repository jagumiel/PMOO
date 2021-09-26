package org.pmoo.packlaboratorio4;
import java.util.*;
public class ListaClientes
{	// atributos
	private ArrayList<Cliente> lista;
	private static ListaClientes miListaClientes = new ListaClientes();
	// constructora
	private ListaClientes()
	{ 	
		this.lista= new ArrayList<Cliente>();
	}
	// getters y setters
	public static ListaClientes getListaClientes()
	{	
		return miListaClientes;
	}
	// otros metodos
  	private Iterator<Cliente> getIterador()
 	{	
  		return this.lista.iterator();
 	}
  	public int cantidadClientes()
 	{	
  		return this.lista.size();
 	}
 	public void anadirCliente(int pIdCliente, String pNombre, String pClave, double pSaldo, boolean pEsPreferente)
 	{
 		Cliente cliente1=new Cliente(pIdCliente,pNombre,pClave,pSaldo,pEsPreferente);
 		if(this.buscarClientePorId(pIdCliente)!=null)
 		{	System.out.print("Ya existe un cliente con ese identificador");	}
 		else
 		{	this.lista.add(cliente1);	}
 	}
 	public Cliente buscarClientePorId(int pId)
	{	
 		Cliente uncliente = null;
 		Iterator<Cliente> itr = ListaClientes.getListaClientes().getIterador();
		while (itr.hasNext())
		{	uncliente=itr.next(); 
			if(uncliente.tieneMismoId(pId))
			{	return uncliente;	}
			else
			{	uncliente=null;	}
		}
		return uncliente;
 	}
  	public void resetear()
 	{	
  		this.lista.clear();
 	}
}	