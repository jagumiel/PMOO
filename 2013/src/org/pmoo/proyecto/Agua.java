package org.pmoo.proyecto;

public class Agua extends Carta{

	public Agua(String pNombre, int pNivel) 
	{
		super(pNombre, pNivel);
		this.actualizarNivel(pNivel);
		this.setVidaActual(getVidaMaxima());
	}
	
	
	public void actualizarNivel(int pNuevoNivel)
	{
		this.setAtaque(pNuevoNivel*2);
		this.setDefensa(pNuevoNivel*4);
		this.setVelocidad(pNuevoNivel*3);
		this.setVidaMaxima(50+pNuevoNivel*5);
		this.setNivel(pNuevoNivel);
		
		if (this.getNombre()=="Wettyk")
		{
			this.setVidaMaxima(20+40+pNuevoNivel*2);
			this.setAtaque(10+pNuevoNivel*8);
			this.setDefensa(10+pNuevoNivel*3);
			this.setVelocidad(10+pNuevoNivel*8);
		}
	}
	
	public String getTipo(){
		return "Agua";
	}
}
