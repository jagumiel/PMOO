package org.pmoo.packlaboratorio4;
public class Cliente
{
   // atributos
	private int identificador;
	private String nombre;
	private String clave;
	private double saldo;
	private boolean preferente;
	// constructora
	public Cliente(int pId, String pNombre, String pClave,
		   double pSaldo, boolean pPref)
   {
	   this.identificador=pId;
	   this.nombre=pNombre;
	   this.clave=pClave;
	   this.saldo=pSaldo;
	   this.preferente=pPref;
   }
   // getters y setters 
   private int getIdCliente()
   {
	   return this.identificador;
   }
   private String getNombre()
   {
	   return this.nombre;
   }
   private String getClave()
   {
	   return this.clave;
   }
   private double getSaldo()
   {
	   return this.saldo;
   }
   private void setSaldo(double pSaldo)
   {
	   this.saldo=pSaldo;
   }
   public boolean getEsPreferente()
   {
	   return this.preferente;
   }
   // otros métodos  
   public boolean tieneMismoId(int pId)
   {
	   if(this.getIdCliente()==pId)
	   {	return true;	}
	   else
	   {	return false;	}
   }
   public double obtenerSaldo(String pClaveTecleada)
   {
	   if (this.comprobarClave(pClaveTecleada))
	   {	return this.getSaldo();}
	   else
	   {	return 0.0;		}
   }
   private boolean comprobarClave(String pClave)
   {if(this.getClave()==pClave)
	   {	return true;	}
	   else
	   {	return false;	}
   }
   public void actualizarSaldo(String pClaveTecleada, double pCantidad)
   {	if(!this.comprobarClave(pClaveTecleada))
	   {	System.out.println(this.getNombre()+" no se ha realizado la operación, la clave no es valida");	}
	   else
	   {   
		   double nuevaCant=pCantidad;
		   if(!this.getEsPreferente())
		   {	nuevaCant=pCantidad*0.999;}
		   if(nuevaCant<0)
		   {	System.out.print(this.getNombre()+" no se ha realizado la operación, la cantidad introducida es menor que cero");	}
		   else if(nuevaCant>this.getSaldo())
		   {	System.out.print(this.getNombre()+" no se ha realizado la operación, la cantidad introducida es mayor a su saldo");}
		   else
		   {
			   this.setSaldo(getSaldo()-nuevaCant);
			   System.out.print(this.getNombre()+" la operación se ha realizado correctamente, su saldo es de"+this.getSaldo()+"euros");
		   }
	   }
   }
}