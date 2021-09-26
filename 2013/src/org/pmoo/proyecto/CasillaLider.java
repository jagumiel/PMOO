package org.pmoo.proyecto;

public class CasillaLider extends Casilla{

	private PersonajeDelMapa lider;
	private boolean haGanadoALider;
	private int vecesDerrotado;
	
	public CasillaLider(PersonajeDelMapa pEntrenador, PersonajeDelMapa pLider){
		super(pEntrenador);
		this.lider = pLider;
		this.vecesDerrotado=0;
	}


	public PersonajeDelMapa getLider(){
		return this.lider;
	}
	
	
	public boolean getHaGanadoALider(){
		return this.haGanadoALider;
	}
	
	private void setHaGanadoALider(boolean pHaGanadoALider){
		this.haGanadoALider = pHaGanadoALider;
	}
	
	public int getVecesDerrotado()
	{
		return this.vecesDerrotado;
	}
	
	public void lucharConLider()
	{
		if (this.getVecesDerrotado()<=3)
		{
			boolean haGanado = Jugador.getJugador().combatirCon(this.getLider().getSuCarta());
			if(haGanado)
			{
				this.setHaGanadoALider(true);
				this.vecesDerrotado=this.getVecesDerrotado()+1;
				int numReg=this.getLider().getRegala();
				if(numReg>0)
				{
					Mapa.getMapa().entregarCarta(numReg);
				}
			}
		}
		else
		{
			System.out.println("Ya has humillado al lider demasiadas veces, lo unico que quiere es que le dejes tranquilo.");
		}
	}
}

