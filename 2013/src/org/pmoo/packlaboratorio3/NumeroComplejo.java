package org.pmoo.packlaboratorio3;


public class NumeroComplejo implements IComplejo 
{
	private double parteReal;
	private double parteImaginaria;
	
	public NumeroComplejo(double pR, double pI)
	{
		this.parteReal = pR;
		this.parteImaginaria = pI;
	}

	public double getParteReal() {
		return parteReal;
	}

	public void setParteReal(double parteReal) {
		this.parteReal = parteReal;
	}

	public double getParteImaginaria() {
		return parteImaginaria;
	}

	public void setParteImaginaria(double parteImaginaria) {
		this.parteImaginaria = parteImaginaria;
	}
	
	public double getAngulo()
	{
		double angRad=0;
		double angDeg=0;
		
		angRad=Math.atan2(this.getParteImaginaria(),this.getParteReal());
		angDeg=Math.toDegrees(angRad);
		
		return angDeg;
	}
	
	public double getModulo()
	{
		double mod=0;
		
		mod=Math.hypot(this.getParteReal(), this.getParteImaginaria());
		
		return mod;
	}
	
	public IComplejo sumar(IComplejo pNumComp)
	{
	
		NumeroComplejo resultado=new NumeroComplejo(this.getParteReal()+pNumComp.getParteReal(),this.getParteImaginaria()+pNumComp.getParteImaginaria());
		return resultado;
	}
	
	public IComplejo multiplicar(IComplejo pNumComp)
	{
		double nuevaPR=this.getParteReal()*pNumComp.getParteReal()-this.getParteImaginaria()*pNumComp.getParteImaginaria();
		double nuevaPI=this.getParteReal()*pNumComp.getParteImaginaria()+pNumComp.getParteReal()*this.getParteImaginaria();
		NumeroComplejo resultado=new NumeroComplejo(nuevaPR,nuevaPI);
		return resultado;
	}

	public boolean esIgual(IComplejo pNumComp)
	{
		boolean igual=false;
		
		if ((this.getParteReal()==pNumComp.getParteReal())&&(this.getParteImaginaria()==pNumComp.getParteImaginaria()))
		{	igual=true; 	}
		
		return igual;
	}
}