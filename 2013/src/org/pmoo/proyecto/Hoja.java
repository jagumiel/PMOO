package org.pmoo.proyecto;

public class Hoja extends Carta{

	public Hoja(String pNombre, int pNivel) {
		super(pNombre, pNivel);
		this.actualizarNivel(pNivel);
		this.setVidaActual(getVidaMaxima());
	}
	
	public void actualizarNivel(int pNuevoNivel)
	{
		this.setAtaque(pNuevoNivel*3);
		this.setDefensa(pNuevoNivel*5);
		this.setVelocidad(pNuevoNivel*2);
		this.setVidaMaxima(40+pNuevoNivel*4);
		this.setNivel(pNuevoNivel);
		
		if (this.getNombre()=="Celtic")
		{
			this.setVidaMaxima(20+40+pNuevoNivel*2);
			this.setAtaque(10+pNuevoNivel*7);
			this.setDefensa(10+pNuevoNivel*3);
			this.setVelocidad(10+pNuevoNivel*5);
		}
	}
	
	public String getTipo(){
		return "Hoja";
	}
}
