package org.pmoo.proyecto;

import java.util.Scanner;

public class Juego {
	
	private static Juego miJuego=new Juego();
	private boolean terminarPrograma=false;
	
	public Juego()
	{
	}

	public static void main(String args[])
	{
		Juego.getMiJuego().jugar();
	}
	
	private void jugar(){
		this.iniciarJuego();
		while (!terminarPrograma)//Sabemos que es un loop infinito hasta que el usuario quiera salir
		{
			System.out.println();
			System.out.println();
			System.out.println();
			int fila = Jugador.getJugador().getCoordenada().getPosFil();
			int columna = Jugador.getJugador().getCoordenada().getPosCol();
			Casilla casillaActual = Mapa.getMapa().getCasilla(columna,fila);
			this.contadorPartidas();
			terminarPrograma = this.imprimirOpciones(casillaActual);
		} 
	}
	private void iniciarJuego()
	{
		Jugador.getJugador().iniciarJugador();
		Mapa.getMapa().iniciarMapa();
		Mapa.getMapa().iniciarCartasRegalo();
		ListaNarraciones.getListaNarraciones().inicializarLista();
		this.escribirNarracion();//Aqui se escribe la primera narracion del juego, y las dem�s se escriben al avanzar
	}
	
	public void pedirContrasena(){ 
		String pPassIntroducida;
		
		System.out.println("Introduzca una clave para cargar la partida y pulse enter.");
		System.out.println("Si no dispone de clave, pulse enter para continuar.");
		pPassIntroducida = this.pedirString();
		int pass = 0;
		try{
			pass = Integer.parseInt(pPassIntroducida);
		}
		catch(Exception e){
			//No hacer nada porque la contraseña sera incorrecta
		}
		if(this.comprobarContrasena(pass))
		{
			Coordenada micoordenada= new Coordenada(pass/100,0);
			Jugador.getJugador().setCoordenada(micoordenada);
			int nivelEscenario;
			int nivelCarta;
			nivelCarta=pass%100;
			nivelEscenario=pass/100;
			Coordenada nuevaCoordenada=new Coordenada(nivelEscenario, 0);//primero alto, luego ancho.
			Jugador.getJugador().setCoordenada(nuevaCoordenada); 
			Jugador.getJugador().getListaCartas().elegirCarta().setNivel(nivelCarta);
			Jugador.getJugador().getListaCartas().elegirCarta().actualizarNivel(nivelCarta);
		}
		else
		{
			Coordenada nuevaCoordenada=new Coordenada(0, 0);//primero alto, luego ancho.
			Jugador.getJugador().setCoordenada(nuevaCoordenada);
		}
	}
	
	
	public boolean comprobarContrasena(int pContrasena)
	{
		if(pContrasena>=005 && pContrasena<=499)
		{
			System.out.println("La clave es correcta");
			System.out.println();
			return true;
		}
		else
		{
			System.out.println("La clave es incorrecta");
			return false;
		}
	}
	
	
	public void escribirNarracion(){
		int pCoordenada=Jugador.getJugador().convertirCoordenada();
		Narracion auxNarracion = ListaNarraciones.getListaNarraciones().buscarNarracionPorId(pCoordenada);
		auxNarracion.imprimirTexto();
	}



	public static Juego getMiJuego() {
		return miJuego;
	}
	
	private boolean imprimirOpciones(Casilla pCasilla){
		boolean todoCorrecto = false; 
		boolean terminarJuego = false;
		int eleccion = 0;
		
		while(!todoCorrecto)
		{	
			todoCorrecto = true;
			
			System.out.println("*************************************************");
			System.out.println("* Te encuentras en "+((Jugador.getJugador().getCoordenada().getPosCol())+1)+
					" division, en la casilla "+((Jugador.getJugador().getCoordenada().getPosFil())+1)+" *");
			System.out.println("*************************************************");
			Jugador.getJugador().getListaCartas().imprimirCartas();
			System.out.println("******************");
			System.out.println();
			System.out.println();
			
			try
			{
				Thread.sleep(2000);
			}
			catch(InterruptedException ex)
			{
				Thread.currentThread().interrupt();
			}
			
			System.out.println("Pulsa 1 para salir\nPulsa 2 para Recuperar la vida de la Carta\n" +
					"Pulsa 3 para luchar con el entrenador");
			pCasilla.getEntrenador().imprimirInfoPersonaje();
			System.out.println("Pulsa 4 para retroceder");
			if(!(pCasilla instanceof CasillaElite)){
				System.out.println("Pulsa 5 para avanzar");
				if(pCasilla instanceof CasillaLider){
					System.out.println("Pulsa 6 para luchar con el lider");
					((CasillaLider) pCasilla).getLider().imprimirInfoPersonaje();
				}
			}else{
				System.out.println("Pulsa 5 para luchar con la elite");
				((CasillaElite) pCasilla).getElite1().imprimirInfoPersonaje();
				((CasillaElite) pCasilla).getElite2().imprimirInfoPersonaje();
				((CasillaElite) pCasilla).getElite3().imprimirInfoPersonaje();
			}
			System.out.println();
			System.out.println();
		
			String auxEleccion = this.pedirString();
			try{
				eleccion = Integer.parseInt(auxEleccion);
			}
			catch(Exception e){
				//No hacer nada porque eleccion ser� 0 y por tanto se repetir� el loop
			}
				
				
			switch(eleccion){
			case 1: System.out.println("El juego ha finalizado.");
					terminarJuego = true;
					break;
			case 2: Jugador.getJugador().getListaCartas().elegirCarta().recuperarVida();
					break;
			case 3: pCasilla.lucharConEntrenador();
					break;
			case 4: Jugador.getJugador().retroceder();
					break;
			case 5: if(!(pCasilla instanceof CasillaElite)){
						Jugador.getJugador().avanzar();
					}else{
						((CasillaElite) pCasilla).lucharConElite();
					}
					break;
			case 6: if(pCasilla instanceof CasillaLider){
						((CasillaLider) pCasilla).lucharConLider();
					}else{
						System.out.println("La opcion marcada no existe");
						todoCorrecto = false;
					}
					break;
			default: System.out.println("La opcion marcada no existe");
						todoCorrecto = false;
			}
		}
		return terminarJuego;
	}
	
	
	public int contadorPartidas()
	{
		int contador=1;
		Coordenada pCoordenada=new Coordenada(4,6);
		if(Jugador.getJugador().getCoordenada()==pCoordenada)
		{
			contador=contador+1;
		}
		return contador;
	}
	
	
	public String pedirString(){
		Scanner sc = new Scanner(System.in);
		String rdo = sc.nextLine();
		return rdo;
		//NO CERRAR EL ESCANER
	}
}