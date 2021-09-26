package org.pmoo.packlaboratorio3;

public class Fraccion implements IFraccion
{
//declaro
	private int numerador;
	private int denominador;
	
	
	public Fraccion (int pNumerador, int pDenominador){
		//inicializa
		this.numerador = pNumerador;
		this.denominador = pDenominador;
		}
		
	public int getNumerador() {
		//
		return this.numerador;
		}

	public void setNumerador(int pNumerador){
		//
		this.numerador=pNumerador;
		}

	public int getDenominador() 
		{
		return this.denominador;
		}

	public void setDenominador(int pDenominador) 
		{
		this.denominador=pDenominador;
		}

	public void simplificar() 
	{	
		boolean chivato=false;
		int Den=Math.abs(this.getDenominador());
		int Num=Math.abs(this.getNumerador());
		
		int menor=Num;
		if (Den<Num)
		{	menor=Den; 	}
		
		int i=menor;
		
		//si la fraccion contiene algun cero
		if ((Num==0)||(Den==0))
		{System.out.println("las fracciones que contienen cero dan error");}
		
		else
		{	
			while ((i>1)&&(chivato==false))
			{	
				if ((Num % i!=0)||(Den % i!=0))
				{	i=i-1;	}
				else
				{chivato=true;}
			}
			
		
		if(chivato==true)
		{	Den=Den/i; Num=Num/i;	}
		
		}
		
		if((this.getNumerador()>=0 && this.getDenominador()>=0)||(this.getNumerador()<=0 && this.getDenominador()<=0))
		{	this.setNumerador(Num); this.setDenominador(Den);	}
		else
		{	this.setNumerador(-Num); this.setDenominador(Den);	}
		
		
	}

	
	public Fraccion sumar(Fraccion pFraccion)
	{
		Fraccion pFraccion3 = new Fraccion (0,0);
				
		if(this.getNumerador()==0||this.getDenominador()==0)
		{	
			if (pFraccion.getNumerador()==0||pFraccion.getDenominador()==0)
			{	pFraccion3.simplificar(); return pFraccion3;}
			else
			{	pFraccion.simplificar(); return pFraccion;}
		}
		
		else if (pFraccion.getNumerador()==0||pFraccion.getDenominador()==0)
		{	this.simplificar(); return this;}	
		
		
		
		if (pFraccion.getDenominador()!=this.getDenominador())
		{
			pFraccion3.numerador=(pFraccion.getNumerador()*this.getDenominador()) + (this.getNumerador()*pFraccion.getDenominador());
			pFraccion3.denominador=pFraccion.getDenominador()*this.getDenominador();
		}
		else
		{	
			pFraccion3.numerador=pFraccion.getNumerador()+this.getNumerador();
			pFraccion3.denominador=this.getDenominador();
		}
		
		pFraccion3.simplificar();

		return pFraccion3;
		
	}

	public Fraccion restar(Fraccion pFraccion)
	{
		
		Fraccion pFraccion3 = new Fraccion (0,0);
		
		if(this.getNumerador()==0||this.getDenominador()==0)
		{	
			if (pFraccion.getNumerador()==0||pFraccion.getDenominador()==0)
			{	pFraccion3.simplificar(); return pFraccion3;}
			else
			{	pFraccion.simplificar(); return pFraccion;}
		}
		
		else if (pFraccion.getNumerador()==0||pFraccion.getDenominador()==0)
		{	 this.simplificar(); return this;}	
		
	
		if (this.getDenominador()!=pFraccion.getDenominador())
		{
			pFraccion3.numerador=(this.getNumerador()*pFraccion.getDenominador()) - (pFraccion.getNumerador()*this.getDenominador());
			pFraccion3.denominador=this.getDenominador()*pFraccion.getDenominador();
		}
		else
		{
			pFraccion3.numerador=this.getNumerador()-pFraccion.getNumerador();
			pFraccion3.denominador=this.getDenominador();
		}
		
		pFraccion3.simplificar();
		return pFraccion3;
		
	}



	public Fraccion multiplicar(Fraccion pFraccion)
	{
		
		Fraccion pFraccion3 = new Fraccion (0,0);
		
		if(this.getNumerador()==0||this.getDenominador()==0)
		{	
			if (pFraccion.getNumerador()==0||pFraccion.getDenominador()==0)
			{	pFraccion3.simplificar(); return pFraccion3;}
			else
			{	pFraccion.simplificar(); return pFraccion;}
		}
		
		else if (pFraccion.getNumerador()==0||pFraccion.getDenominador()==0)
		{	 this.simplificar(); return this;}	
		
		pFraccion3.numerador=this.getNumerador()*pFraccion.getNumerador();
		pFraccion3.denominador=this.getDenominador()*pFraccion.getDenominador();
		
		pFraccion3.simplificar();
		return pFraccion3;
	}
		

	public Fraccion dividir(Fraccion pFraccion)
	{
		
		Fraccion pFraccion3 = new Fraccion (0,0);
		
		if(this.getNumerador()==0||this.getDenominador()==0)
		{	
			if (pFraccion.getNumerador()==0||pFraccion.getDenominador()==0)
			{	pFraccion3.simplificar(); return pFraccion3;}
			else
			{	pFraccion.simplificar(); return pFraccion;}
		}
		
		else if (pFraccion.getNumerador()==0||pFraccion.getDenominador()==0)
		{	 this.simplificar(); return this;}	
		
		pFraccion3.numerador=this.getNumerador()*pFraccion.getDenominador();
		pFraccion3.denominador=this.getDenominador()*pFraccion.getNumerador();
	
		pFraccion3.simplificar();
		return pFraccion3;
	}


	public boolean esIgualQue(Fraccion pFraccion)
	{
		boolean condicion=false;
		if (this.getNumerador()==pFraccion.getNumerador() && this.getDenominador()==pFraccion.getDenominador())
			{
			condicion = true;
			}
		return condicion;
	}

	public boolean esMayorQue(Fraccion pFraccion) 
	{
		double a;
		double b;
		boolean condicion=false;
		a= this.getNumerador()/this.getDenominador();
		b= pFraccion.getNumerador()/pFraccion.getDenominador();

		if (a>b)
			{
			condicion=true;
			}
		return condicion;
	}


	public boolean esMenorQue(Fraccion pFraccion) 
	{
		double a;
		double b;
		boolean condicion=false;
		a= this.getNumerador()/this.getDenominador();
		b= pFraccion.getNumerador()/pFraccion.getDenominador();

		if (a<b)
			{
			condicion=true;
			}
		return condicion;
	}


	public boolean esMayorOIgualQue(Fraccion pFraccion) 
	{
		double a;
		double b;
		boolean condicion=false;
		a= this.getNumerador()/this.getDenominador();
		b= pFraccion.getNumerador()/pFraccion.getDenominador();

		if (a>=b)
			{
			condicion=true;
			}
		return condicion;
	}

	public boolean esMenorOIgualQue(Fraccion pFraccion) 
	{
		double a;
		double b;
		boolean condicion=false;
		a= this.getNumerador()/this.getDenominador();
		b= pFraccion.getNumerador()/pFraccion.getDenominador();
	
		if (a<=b)
			{
			condicion=true;
			}
		return condicion;
	}
}