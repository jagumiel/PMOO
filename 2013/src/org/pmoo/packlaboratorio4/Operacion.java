package org.pmoo.packlaboratorio4;

public class Operacion
{
// atributos
	private int idOperacion;
	private int idCliente;
	private String claveTecleada;
	private double cantidad;
// constructora
	public Operacion(int pIdOper, int pIdCliente, String pClaveTecleada, double pCant)
	{	
		this.idOperacion=pIdOper;
	   	this.idCliente=pIdCliente;
	   	this.claveTecleada=pClaveTecleada;
	   	this.cantidad=pCant;
  	}
// getters y setters
   private int getIdOperacion()
   {
	   return this.idOperacion;
   }
   private int getIdCliente()
   {
	   return this.idCliente;
   }
   private String getClaveTecleada()
   {
	   return this.claveTecleada;
   }
   private double getCantidad()
   {
	   return this.cantidad;
   }
// otros métodos
   public boolean tieneMismoId(int pIdOperacion)
   {
	   if(this.getIdOperacion()==pIdOperacion)
	   {	return true;	}
	   else
	   {	return false;	}
   }
   public void realizarOperacion ()
   {
		if (ListaClientes.getListaClientes().buscarClientePorId(this.getIdCliente()) == null)
		{
			System.out.print("El cliente al que intenta acceder no existe");
		}
		else  
		{	ListaClientes.getListaClientes().buscarClientePorId(this.getIdCliente()).actualizarSaldo(this.getClaveTecleada(), this.getCantidad());	}
   }
}
