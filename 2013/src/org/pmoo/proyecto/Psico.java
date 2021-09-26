package org.pmoo.proyecto;

public class Psico extends Carta{

	public Psico(String pNombre, int pNivel) {
		super(pNombre, pNivel);
		this.actualizarNivel(pNivel);
		this.setVidaActual(getVidaMaxima());
	}
	
	public void actualizarNivel(int pNuevoNivel)
	{
		this.setAtaque(pNuevoNivel*3);
		this.setDefensa(pNuevoNivel*3);
		this.setVelocidad(pNuevoNivel*3);
		this.setVidaMaxima(0+pNuevoNivel*3);
		this.setNivel(pNuevoNivel);
		
		if (this.getNombre()=="Mageek")
		{
			this.setVidaMaxima(20+40+pNuevoNivel*2);
			this.setAtaque(10+pNuevoNivel*7);
			this.setDefensa(10+pNuevoNivel*3);
			this.setVelocidad(10+pNuevoNivel*7);
		}
	}
	
	public String getTipo(){
		return "Psico";
	}
}
