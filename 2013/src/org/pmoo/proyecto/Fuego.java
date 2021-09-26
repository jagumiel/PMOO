package org.pmoo.proyecto;

public class Fuego extends Carta {

	public Fuego(String pNombre, int pNivel)
	{
		//para todas las clases herederas de carta 
		super(pNombre, pNivel);
		this.actualizarNivel(pNivel);
		this.setVidaActual(getVidaMaxima());
	}

	public void actualizarNivel(int pNuevoNivel)
	{
		this.setAtaque(pNuevoNivel*4);
		this.setDefensa(pNuevoNivel*3);
		this.setVelocidad(pNuevoNivel*5);
		this.setVidaMaxima(20+pNuevoNivel*2);
		this.setNivel(pNuevoNivel);
		
		if (this.getNombre()=="Heaton")
		{
			this.setVidaMaxima(20+40+pNuevoNivel*2);
			this.setAtaque(10+pNuevoNivel*10);
			this.setDefensa(10+pNuevoNivel*3);
			this.setVelocidad(10+pNuevoNivel*6);
		}

	}
	
	public String getTipo(){
		return "Fuego";
	}
}
