package org.pmoo.proyecto;

public class CasillaElite extends Casilla {

	private PersonajeDelMapa elite1;
	private PersonajeDelMapa elite2;
	private PersonajeDelMapa elite3;
	
	public CasillaElite(PersonajeDelMapa pEntrenador, PersonajeDelMapa pElite1, PersonajeDelMapa pElite2, PersonajeDelMapa pElite3){
		super(pEntrenador);
		this.elite1=pElite1;
		this.elite2=pElite2;
		this.elite3=pElite3;
	}
	
	
	
	public PersonajeDelMapa getElite1() {
		return elite1;
	}

	public PersonajeDelMapa getElite2() {
		return elite2;
	}

	public PersonajeDelMapa getElite3() {
		return elite3;
	}
	
	public void lucharConElite(){
		System.out.println("Te vas a enfrentar a la elite: "+this.getElite1().getNombre()+
				" cuya carta es: "+this.getElite1().getSuCarta().getNombre()+" que " +
						"esta al nivel "+this.getElite1().getSuCarta().getNivel());
		boolean vaGanando = true;
		
		vaGanando = Jugador.getJugador().combatirCon(this.getElite1().getSuCarta());
			if (vaGanando){
				System.out.println("Te vas a enfrentar al elite: "+this.getElite2().getNombre()+
						"cuya carta es: "+this.getElite2().getSuCarta().getNombre()+" que " +
								"esta al nivel "+this.getElite2().getSuCarta().getNivel());
				vaGanando = Jugador.getJugador().combatirCon(this.getElite2().getSuCarta());
			}
			if(vaGanando){
				System.out.println("Te vas a enfrentar al elite: "+this.getElite3().getNombre()+
						"cuya carta es: "+this.getElite3().getSuCarta().getNombre()+" que " +
								"esta al nivel "+this.getElite3().getSuCarta().getNivel());
				vaGanando = Jugador.getJugador().combatirCon(this.getElite3().getSuCarta());
			if((vaGanando)&&(!(Jugador.getJugador().getCoordenada().getPosCol()==5))){ //Si ha ganado a todos los Elites avanza de divisi�n
				Coordenada miCoordenada = new Coordenada(Jugador.getJugador().getCoordenada().getPosCol()+1,0);
				Jugador.getJugador().setCoordenada(miCoordenada);
				this.escribirContrasena();
			}
		}
	}
	
	public void escribirContrasena(){
			int contrasena = (Jugador.getJugador().getListaCartas().elegirCarta().getNivel())+((Jugador.getJugador().getCoordenada().getPosCol())*100);
			System.out.println("Enhorabuena! Has obtenido la siguiente contrasena: "+contrasena);
			System.out.println("Podras utilizarla la proxima vez que inicies el juego.");
	}
	
}
