package org.pmoo.proyecto;

public class Casilla {
	private PersonajeDelMapa entrenador;
	
	public Casilla(PersonajeDelMapa pEntrenador)
	{
		this.entrenador=pEntrenador;
	}
	
	public PersonajeDelMapa getEntrenador()
	{
		return this.entrenador;
	}
	
	public void lucharConEntrenador()
	{
		if(this.getEntrenador().getVecesDerrotado()>3)
		{
			System.out.println("Has derrotado a "+this.getEntrenador().getNombre()+" demasiadas veces y " +
					"ya no quiere volver a luchar contigo.");
		}
		else
		{
			System.out.println("Te vas a enfrentar a: "+this.getEntrenador().getNombre()+
					" cuya carta es: "+this.getEntrenador().getSuCarta().getNombre()+" que " +
							"esta al nivel "+this.getEntrenador().getSuCarta().getNivel());
			boolean haGanado=Jugador.getJugador().combatirCon(this.getEntrenador().getSuCarta());
			if(haGanado)
			{
				this.getEntrenador().sumarVecesDerrotado();
			}
		}
	}
}