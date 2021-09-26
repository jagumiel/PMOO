package org.pmoo.packlaboratorio3;

public class Operacion
{
	enum Operador{SUMA,RESTA,PRODUCTO,COCIENTE,RESTO};
	
	private int operando1;
	private int operando2;
	private  Operador operador;
	
	
	public Operacion(int poperando1, int poperando2) 
	{
		super();
		this.operando1 = poperando1;
		this.operando2 = poperando2;
		this.operador = null;
	}


	public int getOperando1() {
		return operando1;
	}


	public void setOperando1(int operando1) {
		this.operando1 = operando1;
	}


	public int getOperando2() {
		return operando2;
	}


	public void setOperando2(int operando2) {
		this.operando2 = operando2;
	}


	public Operador getOperador() {
		return operador;
	}


	public void setOperador(Operador operador) {
		this.operador = operador;
	}
	
	public int obtenerResultado(Operador pOperador)
	{
		int resultado=0;
		
		if (pOperador==Operador.SUMA)
		{
			resultado=operando1+operando2;
		}
		else if (pOperador==Operador.RESTA)		
		{
			resultado=operando1-operando2;
		}
		else if (pOperador==Operador.PRODUCTO)
		{
			resultado=operando1*operando2;
		}
		else if (pOperador==Operador.COCIENTE)
		{
			resultado=operando1/operando2;
		}
		else if (pOperador==Operador.RESTO)
		{
			resultado=operando1%operando2;
		}
		
		return resultado;
	}
	
}
