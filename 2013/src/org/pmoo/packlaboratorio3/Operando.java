package org.pmoo.packlaboratorio3;

public class Operando
{

	private int valor;
	
	public Operando(int pvalor)
	{
		this.valor = pvalor;
	}


	public int getValor()
	{
		return valor;
	}


	public void setValor(int pvalor) 
	{
		this.valor = pvalor;
	}
	
	public Operando sumar(Operando pOperando)
	{
		Operando resultado=new Operando(this.getValor()+pOperando.getValor());
		
		return resultado;		
		
	}
	
	public Operando restar(Operando pOperando)
	{
		Operando resultado=new Operando(this.getValor()-pOperando.getValor());
		
		return resultado;		
		
	}
	
	public Operando multiplicar(Operando pOperando)
	{
		Operando resultado=new Operando(this.getValor()*pOperando.getValor());
		
		return resultado;		
		
	}
	
	public Operando dividir(Operando pOperando)
	{
		Operando resultado=new Operando(this.getValor()/pOperando.getValor());
		
		return resultado;		
		
	}
	
	public Operando getResto(Operando pOperando)
	{
		Operando resultado=new Operando(this.getValor()%pOperando.getValor());
		
		return resultado;		
		
	}
}
