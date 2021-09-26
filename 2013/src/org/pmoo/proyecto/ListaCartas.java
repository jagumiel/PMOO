package org.pmoo.proyecto;

import java.util.*;

public class ListaCartas 
{
	private ArrayList<Carta> lista;
	
	public ListaCartas()
	{
		this.lista=new ArrayList<Carta>();
	}
	private ArrayList<Carta> getLista()
	{
		return this.lista;
	}
	
	private Iterator<Carta> getIterador()
	{
		return this.getLista().iterator();
	}
	public void anadirCarta(Carta pCarta)
	{
		this.getLista().add(pCarta);
	}
	public void eliminarCarta(Carta pCarta)
	{
		this.getLista().remove(pCarta);
	}
	
	private int getTamano()
	{
		return this.getLista().size();
	}
	public void resetear()
	{
		this.getLista().clear();
	}
	public int pedirInt()
	{
		Scanner sc = new Scanner(System.in);
		int rdo = sc.nextInt();
		return rdo;
		//NO CERRAR EL ESCANER
	}
	public boolean esta(Carta pCarta)
	{
		boolean esta=false;
		Carta unCarta;
		Iterator<Carta> itr=this.getIterador();
		while(itr.hasNext()&&!esta)
		{
			unCarta=itr.next();
			if(unCarta==pCarta)
			{
				esta=true;
			}
		}
		return esta;
	}
	public Carta buscarCartaPorId(int pId,int pIntentos)
	{
		Carta aux=null;
		boolean enc=false;
		int i=0;
		Iterator<Carta> itr= this.getIterador();
		while(itr.hasNext()&&!enc)
		{
			aux=itr.next();
			if(i==pId)
			{
				enc=true;
			}
			i=i+1;
		}
		if(!enc&&pIntentos>0)
		{
			pIntentos=pIntentos-1;
			aux=null;
			System.out.println("No se ha encontrado la carta requerida, introduzca su numreo otra vez");
			
			this.buscarCartaPorId(pId,pIntentos);
		}
		return aux;
	}
	public Carta elegirCarta()
	{
		Carta unCarta;
		
		if(this.getTamano()==1)
		{
			unCarta=this.buscarCartaPorId(0,5);
		}
		else
		{

			System.out.println("Elige una de las siguientes cartas usando su id");
			this.imprimirCartas();
			int auxEleccion = this.pedirInt();;
			unCarta=this.buscarCartaPorId(auxEleccion,5);
		}
		
		return unCarta;
	}
	public void imprimirCartas()
	{
		Carta unCarta;
		int i=0;
		Iterator<Carta> itr= this.getIterador();
		while(itr.hasNext())
		{
			System.out.println("**   ID:"+i+"   **");
			i=i+1;
			unCarta=itr.next();
			unCarta.imprimirNivelYAtributos();
		}
	}

}
