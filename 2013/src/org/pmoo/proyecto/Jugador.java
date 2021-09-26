package org.pmoo.proyecto;


public class Jugador 
{
	private static Jugador miJugador=new Jugador(null, null, null);
	private String nombre;
	private Coordenada coordenadas;
	private ListaCartas listaCartasJug;
	
	private Jugador(String pNombre, Carta pMiCarta, Coordenada pCoordenadas)
	{
		this.nombre=pNombre;
		this.listaCartasJug=new ListaCartas();
		this.coordenadas=pCoordenadas;
	}

	public static Jugador getJugador()
	{
		return miJugador;
	}
	
	public String getNombre() {
		return nombre;
	}

	private void setNombre(String pNombre) {
		this.nombre = pNombre;
	}

	public ListaCartas getListaCartas()
	{
		return listaCartasJug;
	}
	
	public void iniciarJugador()
	{
		String nombreJugador;
		String eleccion;
		Carta laCarta=null;
		boolean correcto=false;
		
		System.out.println("Introduce tu nombre.");
		nombreJugador= Juego.getMiJuego().pedirString();
		miJugador.setNombre(nombreJugador);
		
		System.out.println("Hola "+nombreJugador +". Elige a tu companero de aventuras, ira contigo durante todo el viaje.");
		System.out.println("Puedes elegir entre Heaton, Wettyk, Celtic y Mageek.");
		
		while(!correcto)
		{
			correcto=true;
			eleccion=Juego.getMiJuego().pedirString();
			if (eleccion.equalsIgnoreCase("Heaton"))
			{
				laCarta=new Fuego("Heaton", 5);//Fuego
			}
			else if (eleccion.equalsIgnoreCase("Wettyk"))
			{
				laCarta=new Agua("Wettyk", 5);//Agua
			}
			else if (eleccion.equalsIgnoreCase("Celtic"))
			{
				laCarta=new Hoja("Celtic", 5);
			}
			else if(eleccion.equalsIgnoreCase("Mageek"))
			{
				laCarta=new Psico("Mageek", 5);
			}
			else 
			{
				correcto=false;
				System.out.println("No se ha podido leer el nombre de tu compa�ero");
				System.out.println("vuelve a escribirlo");
			}
		}
		miJugador.getListaCartas().anadirCarta(laCarta);
		Juego.getMiJuego().pedirContrasena();
		
	}
	
	public boolean combatirCon (Carta pCartaRival)
	{
		
		Carta auxCartaJugador= Jugador.getJugador().getListaCartas().elegirCarta();
		
		Combate miCombate = new Combate(auxCartaJugador,pCartaRival);
		boolean haGanado = miCombate.simularCombate();
		
		if(haGanado)
		{
			auxCartaJugador.actualizarNivel(auxCartaJugador.getNivel()+1);
			System.out.println("Enhorabuena!! has ganado");
		}
		else
		{
			if(auxCartaJugador.getNivel()>1)
			{
			auxCartaJugador.actualizarNivel(auxCartaJugador.getNivel()-1);
			}
			System.out.println("Lo siento, has perdido el combate.");
		}
		
		return haGanado;
	}
	


	
	public void avanzar()
	{
		Coordenada miCoordenada;
		miCoordenada=this.coordenadas;
		int col=miCoordenada.getPosCol();
		int fil=miCoordenada.getPosFil();
		Casilla pCasilla = Mapa.getMapa().getCasilla(col, fil);
		
		if((pCasilla instanceof CasillaLider)&&(!((CasillaLider) pCasilla).getHaGanadoALider())){
			System.out.println("Has de ganar al lider para poder avanzar");
		}else{
			try{
				Coordenada nuevaCoordenada = new Coordenada(col,fil+1);
				this.setCoordenada(nuevaCoordenada);
				Juego.getMiJuego().escribirNarracion();
			}
			catch(Exception e){
				
			}
		}
	}
	
	public void retroceder()
	{
			Coordenada miCoordenada;
			miCoordenada=this.coordenadas;
			int col=miCoordenada.getPosCol();
			int fil=miCoordenada.getPosFil();
			if (fil>0)
			{
				miCoordenada=new Coordenada(col,fil-1); //no podra retroceder si se encuentra en 0.
				this.coordenadas=miCoordenada;
			}
			try{
				Coordenada nuevaCoordenada = new Coordenada(col,fil-1);
				this.setCoordenada(nuevaCoordenada);
				Juego.getMiJuego().escribirNarracion();
			}
			catch(Exception e){		
			}
			/*else
			{
				System.out.println("No puedes retroceder");  //Seria interesante controlarlo con una excepci�n
			}*/
	}
	

	public Coordenada getCoordenada()
	{
		return this.coordenadas;
	}
	
	public int convertirCoordenada()
	{
		Coordenada pCoordenada=this.getCoordenada();
		int conver=((pCoordenada.getPosFil()*10)+pCoordenada.getPosCol());
		return conver;
	}
	
	public void setCoordenada(Coordenada pCoordenada)
	{
		coordenadas=pCoordenada;
	}
	
	public void imprimirCoordenadas()
	{
		System.out.println("Estas en la fila "+this.getCoordenada().getPosFil());
		System.out.println("Estas en la columna  "+this.getCoordenada().getPosCol());
	}
	
	public void resetear()
	{
		Coordenada pCoordenada=new Coordenada(0, 0);
		this.nombre=null;
		this.getListaCartas().resetear();
		this.coordenadas=pCoordenada;
		//Esto nos es util para las JUnits.
	}

}
