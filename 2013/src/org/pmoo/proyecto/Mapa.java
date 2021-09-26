package org.pmoo.proyecto;

public class Mapa 
{
	private Casilla matriz[][];
	private static int alto=5; //5 divisiones
	private static int ancho=7; //7 casillas por division
	private static Mapa miMapa=new Mapa();
	private ListaCartas cartasRegalo;
	
	private Mapa()
	{
		this.matriz= new Casilla[getAlto()][getAncho()];
		this.cartasRegalo=new ListaCartas();
	}
	public ListaCartas getCartasRegalo()
	{
		return this.cartasRegalo;
	}
	
	private int getAncho() 
	{
		return ancho;
	}

	private int getAlto() {
		return alto;
	}
	
	public static Mapa getMapa(){
		return miMapa;
	}
	
	
	public Casilla getCasilla(int pAlto,int pAncho)
	{
		Casilla pCasilla=null;
		if((pAlto<getAlto())&&(pAncho<getAncho()))
		{
			pCasilla=getMapa().matriz[pAlto][pAncho];
		}
		return pCasilla;
	}
	
	public void aniadirCasilla(Casilla pCasilla,int pAlto,int pAncho)
	{
		getMapa().matriz[pAlto][pAncho]=pCasilla;
	}

	
	public void entregarCarta(int pId)
	{
		Carta unCarta;
		unCarta=this.getCartasRegalo().buscarCartaPorId(pId,5);
		if(!Jugador.getJugador().getListaCartas().esta(unCarta))
		{
			Jugador.getJugador().getListaCartas().anadirCarta(unCarta);
			try
			{
				Thread.sleep(1500);
			}
			catch(InterruptedException ex)
			{
				Thread.currentThread().interrupt();
			}
			
			System.out.println("El lider te ha entregado la carta "+unCarta.getNombre());
		}
	}
	 void iniciarCartasRegalo()
	{
		//nivel 1	
		Carta cartaRegalo0 = new Fuego("Tomahawk", 9);
		Carta cartaRegalo1 = new Hoja("Carnivor", 20);
		Carta cartaRegalo2 = new Agua("Goteras", 27);
		Carta cartaRegalo3 = new Psico("Psicopat", 35);
		Carta cartaRegalo4 = new Hoja("Hemp", 40);

		this.getCartasRegalo().anadirCarta(cartaRegalo0);
		this.getCartasRegalo().anadirCarta(cartaRegalo1);
		this.getCartasRegalo().anadirCarta(cartaRegalo2);
		this.getCartasRegalo().anadirCarta(cartaRegalo3);
		this.getCartasRegalo().anadirCarta(cartaRegalo4);
		
		
		
	}
	public void iniciarMapa()
	{
		//TODO igualarlo, que todos tienen el mismo nivel
		//Nivel 1
		Carta cartaDelPersonaje00 = new Psico("Moonik", 3/*Juego.getMiJuego().contadorPartidas()+195*/);
		PersonajeDelMapa entrenador00 = new PersonajeDelMapa("Bielseek", cartaDelPersonaje00);//0
		Casilla pCasilla00= new Casilla(entrenador00);
		this.aniadirCasilla(pCasilla00, 0, 0);
		
		
		Carta cartaDelPersonaje01a = new Fuego("Heatster", 4);
		PersonajeDelMapa entrenador01 = new PersonajeDelMapa("Miami", cartaDelPersonaje01a);//1
		Carta cartaDelPersonaje01b = new Agua("Indiana", 6);
		PersonajeDelMapa lider01 = new PersonajeDelMapa("Pacer", cartaDelPersonaje01b);//2
	    CasillaLider pCasillaLider01 = new CasillaLider(entrenador01,lider01);
		this.aniadirCasilla(pCasillaLider01, 0,1);
		
		Carta cartaDelPersonaje02 = new Hoja("Wolve",7);
		PersonajeDelMapa entrenador02 = new PersonajeDelMapa("Sotta",cartaDelPersonaje02);//3
		Casilla pCasilla02 = new Casilla(entrenador02);
		this.aniadirCasilla(pCasilla02, 0,2);
		
		Carta cartaDelPersonaje03 = new Agua("Aquarius",7);
		PersonajeDelMapa entrenador03 = new PersonajeDelMapa("Aquaman",cartaDelPersonaje03);//4
		Casilla pCasilla03 = new Casilla(entrenador03);
		this.aniadirCasilla(pCasilla03, 0,3);
		
		
		Carta cartaDelPersonaje04 = new Psico("Freud",8);
		PersonajeDelMapa entrenador04 = new PersonajeDelMapa("Doc",cartaDelPersonaje04);//5
		Carta carta00 = new Hoja("Absynth", 9);
		PersonajeDelMapa lider00 = new PersonajeDelMapa("Chuck", carta00);//6
		lider00.setRegala(1);//*****************************************************************regala carta
		CasillaLider pCasillaLider04 = new CasillaLider(entrenador04,lider00);
		this.aniadirCasilla(pCasillaLider04, 0,4);
		
		

		Carta cartaDelPersonaje05 = new Fuego("Charmer",13);
		PersonajeDelMapa entrenador05 = new PersonajeDelMapa("Ares",cartaDelPersonaje05);//7
		Carta cartaDelLider01 = new Agua("Nemo",14);
		PersonajeDelMapa lider000 = new PersonajeDelMapa("Bishop", cartaDelLider01);//8
		Casilla pCasillaLider05 = new CasillaLider(entrenador05,lider000);
		this.aniadirCasilla(pCasillaLider05, 0,5);
		
		Carta cartaDelPersonaje06 = new Fuego("Smoky",14);
		PersonajeDelMapa entrenador06 = new PersonajeDelMapa("Red Warrior",cartaDelPersonaje06);//9
		Carta cartaElite06a = new Agua("Ahoy",16);
		PersonajeDelMapa elite06a = new PersonajeDelMapa("BarbaRoja",cartaElite06a);//10
		Carta cartaElite06b = new Psico("Hypnoteek",17);
		PersonajeDelMapa elite06b = new PersonajeDelMapa("The Dude",cartaElite06b);//11
		Carta cartaElite06c = new Hoja("Mearry",20);
		PersonajeDelMapa elite06c = new PersonajeDelMapa("Willy",cartaElite06c);//12
	    CasillaElite pCasillaElite06 = new CasillaElite(entrenador06,elite06a, elite06b, elite06c);
		this.aniadirCasilla(pCasillaElite06, 0,6);
		
		//Nivel 2
		Carta cartaDelPersonaje10 = new Psico("Stooner", 23);
		PersonajeDelMapa entrenador10 = new PersonajeDelMapa("Yoda", cartaDelPersonaje10);//13
		Casilla pCasilla10= new Casilla(entrenador10);
		this.aniadirCasilla(pCasilla10, 1,0);

		Carta cartaDelPersonaje11a = new Fuego("FireBird", 23);
		PersonajeDelMapa entrenador11 = new PersonajeDelMapa("Lynyrd", cartaDelPersonaje11a);//14
		Carta cartaDelPersonaje11b = new Agua("Tsoonamy", 28);
		PersonajeDelMapa lider11 = new PersonajeDelMapa("Nemo", cartaDelPersonaje11b);//15
		lider11.setRegala(2); //*****************************************************************regala carta
	    CasillaLider pCasillaLider11 = new CasillaLider(entrenador11,lider11);
		this.aniadirCasilla(pCasillaLider11, 1,1);
		
		Carta cartaDelPersonaje12 = new Fuego("Bero",28);
		PersonajeDelMapa entrenador12 = new PersonajeDelMapa("Titus",cartaDelPersonaje12);//16
		Casilla pCasilla12 = new Casilla(entrenador12);
		this.aniadirCasilla(pCasilla12, 1,2);
		
		Carta cartaDelPersonaje13a = new Hoja("Treeping",33);
		PersonajeDelMapa entrenador13 = new PersonajeDelMapa("Ar Bolero",cartaDelPersonaje13a);//17
		Carta cartaDelPersonaje13b = new Fuego("Rager", 37);
		PersonajeDelMapa lider13 = new PersonajeDelMapa("Flaming Moe", cartaDelPersonaje13b);//18
		CasillaLider pCasillaLider13 = new CasillaLider(entrenador13, lider13);
		this.aniadirCasilla(pCasillaLider13, 1,3);
		
		Carta cartaDelPersonaje14 = new Psico("Weezard",37);
		PersonajeDelMapa entrenador14 = new PersonajeDelMapa("Spuk",cartaDelPersonaje14);//19
		Casilla pCasilla14 = new Casilla(entrenador14);
		this.aniadirCasilla(pCasilla14, 1,4);
		
		Carta cartaDelPersonaje15a = new Agua("Boiler",40);
		PersonajeDelMapa entrenador15 = new PersonajeDelMapa("Soo-San",cartaDelPersonaje15a);//20
		Carta cartaDelPersonaje15b = new Psico("Datfil", 45);
		PersonajeDelMapa lider15 = new PersonajeDelMapa("Lee Moon", cartaDelPersonaje15b);//21
		CasillaLider pCasillaLider15 = new CasillaLider(entrenador15, lider15);
		this.aniadirCasilla(pCasillaLider15, 1,5);
		
		Carta cartaDelPersonaje16 = new Psico("FranPsychs",46);
		PersonajeDelMapa entrenador16 = new PersonajeDelMapa("Zappa",cartaDelPersonaje16);//22
		Carta cartaElite16a = new Agua("Capteen",50);
		PersonajeDelMapa elite16a = new PersonajeDelMapa("BarbaNegra",cartaElite16a);//23
		Carta cartaElite16b = new Fuego("Geetik",55);
		PersonajeDelMapa elite16b = new PersonajeDelMapa("Diskoon",cartaElite16b);//24
		Carta cartaElite16c = new Hoja("Plancton",57);
		PersonajeDelMapa elite16c = new PersonajeDelMapa("Sinnerman",cartaElite16c);//25
	    CasillaElite pCasillaElite16 = new CasillaElite(entrenador16,elite16a, elite16b, elite16c);
		this.aniadirCasilla(pCasillaElite16, 1,6);
		
		//Nivel 3
		Carta cartaDelPersonaje20 = new Psico("Ghosty", 61);
		PersonajeDelMapa entrenador20 = new PersonajeDelMapa("Heracles", cartaDelPersonaje20);//26
		Casilla pCasilla20= new Casilla(entrenador20);
		this.aniadirCasilla(pCasilla20, 2, 0);
		
		Carta cartaDelPersonaje21a = new Psico("Magneteek", 62);
		PersonajeDelMapa entrenador21 = new PersonajeDelMapa("Black Wizard", cartaDelPersonaje21a);//27
		Carta cartaDelPersonaje21b = new Agua("Dunker", 65);
		PersonajeDelMapa lider21 = new PersonajeDelMapa("Txapas", cartaDelPersonaje21b);//28
	    CasillaLider pCasillaLider21 = new CasillaLider(entrenador21,lider21);
		this.aniadirCasilla(pCasillaLider21, 2,1);
		
		Carta cartaDelPersonaje22 = new Fuego("Hotren",65);
		PersonajeDelMapa entrenador22 = new PersonajeDelMapa("Cartman",cartaDelPersonaje22);//29
		Casilla pCasilla22 = new Casilla(entrenador22);
		this.aniadirCasilla(pCasilla22, 2,2);
	
		Carta cartaDelPersonaje23a = new Agua("Sinker",67);
		PersonajeDelMapa entrenador23 = new PersonajeDelMapa("Kaishu",cartaDelPersonaje23a);//30
		Carta cartaDelPersonaje23b = new Hoja("Greener", 70);
		PersonajeDelMapa lider23 = new PersonajeDelMapa("Aymaan", cartaDelPersonaje23b);//31
		CasillaLider pCasillaLider23 = new CasillaLider(entrenador23, lider23);
		this.aniadirCasilla(pCasillaLider23, 2,3);
		
		Carta cartaDelPersonaje24 = new Psico("Gaafar",71);
		PersonajeDelMapa entrenador24 = new PersonajeDelMapa("Wotowika",cartaDelPersonaje24);//32
		Casilla pCasilla24 = new Casilla(entrenador24);
		this.aniadirCasilla(pCasilla24, 2,4);
		
		Carta cartaDelPersonaje25a = new Fuego("Burtner",72);
		PersonajeDelMapa entrenador25 = new PersonajeDelMapa("Flamous",cartaDelPersonaje25a);//33
		Carta cartaDelPersonaje25b = new Psico("Hypno", 75);
		PersonajeDelMapa lider25 = new PersonajeDelMapa("Lee Choon", cartaDelPersonaje25b);//34
		CasillaLider pCasillaLider25 = new CasillaLider(entrenador25, lider25);
		this.aniadirCasilla(pCasillaLider25, 2,5);
		
		Carta cartaDelPersonaje26 = new Fuego("Hentrix",75);
		PersonajeDelMapa entrenador26 = new PersonajeDelMapa("Stratus",cartaDelPersonaje26);//35
		Carta cartaElite26a = new Agua("Geyodos",77);
		PersonajeDelMapa elite26a = new PersonajeDelMapa("Waterpolo",cartaElite26a);//36
		Carta cartaElite26b = new Fuego("Molok",79);
		PersonajeDelMapa elite26b = new PersonajeDelMapa("Teiker",cartaElite26b);//37
		Carta cartaElite26c = new Hoja("Leefo",82);
		PersonajeDelMapa elite26c = new PersonajeDelMapa("Boxxy",cartaElite26c);//38
	    CasillaElite pCasillaElite26 = new CasillaElite(entrenador26,elite26a, elite26b, elite26c);
		this.aniadirCasilla(pCasillaElite26, 2,6);
		
		//Nivel 4
		Carta cartaDelPersonaje30 = new Psico("Weezard", 83);
		PersonajeDelMapa entrenador30 = new PersonajeDelMapa("McMagic", cartaDelPersonaje30);//39
		Casilla pCasilla30= new Casilla(entrenador30);
		this.aniadirCasilla(pCasilla30, 3, 0);
		
		Carta cartaDelPersonaje31a = new Psico("Abraxas", 83);
		PersonajeDelMapa entrenador31 = new PersonajeDelMapa("Peenbol", cartaDelPersonaje31a);//40
		Carta cartaDelPersonaje31b = new Agua("Aquarius", 85);
		PersonajeDelMapa lider31 = new PersonajeDelMapa("Riverik", cartaDelPersonaje31b);//41
	    CasillaLider pCasillaLider31 = new CasillaLider(entrenador31,lider31);
		this.aniadirCasilla(pCasillaLider31, 3,1);
		
		Carta cartaDelPersonaje32 = new Fuego("Sunner",87);
		PersonajeDelMapa entrenador32 = new PersonajeDelMapa("Super Star",cartaDelPersonaje32);//42
		Casilla pCasilla32 = new Casilla(entrenador32);
		this.aniadirCasilla(pCasilla32, 3,2);
		
		Carta cartaDelPersonaje33a = new Hoja("Treeping",89);
		PersonajeDelMapa entrenador33 = new PersonajeDelMapa("Garnett",cartaDelPersonaje33a);//43
		Carta cartaDelPersonaje33b = new Fuego("Torino", 90);
		PersonajeDelMapa lider33 = new PersonajeDelMapa("Flamable", cartaDelPersonaje33b);//44
		CasillaLider pCasillaLider33 = new CasillaLider(entrenador33, lider33);
		this.aniadirCasilla(pCasillaLider33, 3,3);
		
		Carta cartaDelPersonaje34 = new Psico("Sarfer",90);
		PersonajeDelMapa entrenador34 = new PersonajeDelMapa("Wavy Vai",cartaDelPersonaje34);//45
		Casilla pCasilla34 = new Casilla(entrenador34);
		this.aniadirCasilla(pCasilla34, 3,4);
		
		Carta cartaDelPersonaje35a = new Agua("Aye",91);
		PersonajeDelMapa entrenador35 = new PersonajeDelMapa("Soo-San",cartaDelPersonaje35a);//46
		Carta cartaDelPersonaje35b = new Psico("Datfil", 92);
		PersonajeDelMapa lider35 = new PersonajeDelMapa("Lee Moon", cartaDelPersonaje35b);//47
		CasillaLider pCasillaLider35 = new CasillaLider(entrenador35, lider35);
		this.aniadirCasilla(pCasillaLider35, 3,5);
		
		Carta cartaDelPersonaje36 = new Psico("Damner",93);
		PersonajeDelMapa entrenador36 = new PersonajeDelMapa("Satrich",cartaDelPersonaje36);//48
		Carta cartaElite36a = new Agua("Mun",95);
		PersonajeDelMapa elite36a = new PersonajeDelMapa("Sain",cartaElite36a);//49
		Carta cartaElite36b = new Fuego("Fuzz",97);
		PersonajeDelMapa elite36b = new PersonajeDelMapa("Mc Hue",cartaElite36b);//50
		Carta cartaElite36c = new Hoja("Greener",99);
		PersonajeDelMapa elite36c = new PersonajeDelMapa("Mrs. Smith",cartaElite36c);//51
	    CasillaElite pCasillaElite36 = new CasillaElite(entrenador36,elite36a, elite36b, elite36c);
		this.aniadirCasilla(pCasillaElite36, 3,6);
		
		//Nivel 5
		Carta cartaDelPersonaje40 = new Psico("Xilent", 100);
		PersonajeDelMapa entrenador40 = new PersonajeDelMapa("Tracker", cartaDelPersonaje40);//52
		Casilla pCasilla40= new Casilla(entrenador40);
		this.aniadirCasilla(pCasilla40, 4, 0);
		
		Carta cartaDelPersonaje41a = new Psico("Magneteek", 105);
		PersonajeDelMapa entrenador41 = new PersonajeDelMapa("Aymaan", cartaDelPersonaje41a);//53
		Carta cartaDelPersonaje41b = new Agua("Boiler", 107);
		PersonajeDelMapa lider41 = new PersonajeDelMapa("Seilor", cartaDelPersonaje41b);//54
	    CasillaLider pCasillaLider41 = new CasillaLider(entrenador41,lider41);
		this.aniadirCasilla(pCasillaLider41, 4,1);
		
		Carta cartaDelPersonaje42 = new Fuego("Hotren",110);
		PersonajeDelMapa entrenador42 = new PersonajeDelMapa("Firebol",cartaDelPersonaje42);//55
		Casilla pCasilla42 = new Casilla(entrenador42);
		this.aniadirCasilla(pCasilla42, 4,2);
		
		Carta cartaDelPersonaje43a = new Hoja("Plancton",115);
		PersonajeDelMapa entrenador43 = new PersonajeDelMapa("Ar Bolero",cartaDelPersonaje43a);//56
		Carta cartaDelPersonaje43b = new Fuego("FireBird", 117);
		PersonajeDelMapa lider43 = new PersonajeDelMapa("Mr White", cartaDelPersonaje43b);//57
		CasillaLider pCasillaLider43 = new CasillaLider(entrenador43, lider43);
		this.aniadirCasilla(pCasillaLider43, 4,3);
		
		Carta cartaDelPersonaje44a = new Agua("Looper",125);
		PersonajeDelMapa entrenador44 = new PersonajeDelMapa("Swirly",cartaDelPersonaje44a);//58
		Carta cartaDelPersonaje44b = new Psico("Constrain", 127);
		PersonajeDelMapa lider44 = new PersonajeDelMapa("DeBugger", cartaDelPersonaje44b);//59
		CasillaLider pCasillaLider44 = new CasillaLider(entrenador44, lider44);
		this.aniadirCasilla(pCasillaLider44, 4,4);
		
		Carta cartaDelPersonaje45 = new Psico("Gaafard",130);
		PersonajeDelMapa entrenador45 = new PersonajeDelMapa("Fatality",cartaDelPersonaje45);//60
		Carta cartaElite45a = new Agua("Tza",155);
		PersonajeDelMapa elite45a = new PersonajeDelMapa("Rainbow Bunchies",cartaElite45a);//61
		Carta cartaElite45b = new Fuego("Jordan",175);
		PersonajeDelMapa elite45b = new PersonajeDelMapa("Mike",cartaElite45b);//62
		Carta cartaElite45c = new Hoja("Nantuko",195);
		PersonajeDelMapa elite45c = new PersonajeDelMapa("Mirari",cartaElite45c);//63
	    CasillaElite pCasillaElite45 = new CasillaElite(entrenador45,elite45a, elite45b, elite45c);
		this.aniadirCasilla(pCasillaElite45, 4,5);
		
		Carta cartaDelPersonaje46 = new Psico("Gaafard",5);
		PersonajeDelMapa entrenador46 = new PersonajeDelMapa("Scripter",cartaDelPersonaje46);//64
		Casilla pCasilla46 = new Casilla(entrenador46);
		this.aniadirCasilla(pCasilla46, 4,6);
		
		System.out.println("Mapa creado satisfactoriamente");
	}		
		
	
	public boolean existenCoordenadas(Coordenada pCoordenada)
	{
		int pAlto=pCoordenada.getPosCol();
		int pAncho=pCoordenada.getPosFil();
		if ((pAlto<=4)&&(pAncho<=6))//se podria llamar a algun metodo que lo haga automatico en lugar de introducir un numero manualmente?
									//as� esta bien
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}