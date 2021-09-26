package org.pmoo.proyecto;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaNarraciones 
{
	private static ListaNarraciones miListaNarraciones=new ListaNarraciones();
	private ArrayList<Narracion> lista;
	
	private ListaNarraciones() //CAMBIADO
	{
		this.lista=new ArrayList<Narracion>();
	}
	
	public static ListaNarraciones getListaNarraciones()
	{
		return miListaNarraciones;
	}
	
	private ArrayList<Narracion> getLista()
	{
		return this.lista;
	}
	
	private Iterator<Narracion> getIterador()
	{
		return this.getLista().iterator();
	}

	
	public Narracion buscarNarracionPorId(int pId)
	{
		Narracion aux=null;
		Iterator<Narracion>itr=this.getIterador();
		boolean enc=false;
		
		while(itr.hasNext()&&!enc)
		{
			aux=itr.next();
			if(aux.tieneEsteId(pId))
			{
				enc=true;
			}
		}
		if(!enc)
		{
			aux=null;
		}
		return aux;
	}
	
	public void aniadirNarracion(Narracion pNarracion)
	{
		this.lista.add(pNarracion);
	}
	
	public void resetear()
	{
		this.getLista().clear();
	}
	
	public void inicializarLista()
	{
		//Nivel 1
		
			this.aniadirNarracion(new Narracion(00, "Eh, "+Jugador.getJugador().getNombre()+ ", a donde vas? Antes de enfrentarte a los mejores y conquistar la Liga deberas de demostrar tu fuerza, pequeno padawan. Pelea con los entrenadores y haz que tu carta se mantenga en forma, solo asi lograras ser un campeon"));
			this.aniadirNarracion(new Narracion(10, "Ya estas en marcha, la aventura te espera. Trata bien a "+Jugador.getJugador().getListaCartas().elegirCarta().getNombre()+", si su vida llega a 0 perdera niveles y tendras que volverla a entrenar."));
			this.aniadirNarracion(new Narracion(20, "Enhorabuena, si estas aqui es porque has derrotado al primer lider. Los lideres te bloquearan el paso, tienes que demostrar ser mejor que ellos si quieres avanzar."));
			this.aniadirNarracion(new Narracion(30, "Parece que lo estas haciendo bien, "+Jugador.getJugador().getNombre()+ ", pero recuerda que esto es solo el entrenamiento. Si quieres subir niveles siempre puedes retroceder en el camino y volver a luchar."));
			this.aniadirNarracion(new Narracion(40, "Le has dado una buena paliza, parece que no todos pueden presumir de ser tan buen entrenador como tu"));
			this.aniadirNarracion(new Narracion(50, "Estas muy cerca de la Elite, asegurate de que tu amigo "+Jugador.getJugador().getListaCartas().elegirCarta().getNombre()+" este en buenas condiciones o te derrotaran sin piedad alguna" ));
			this.aniadirNarracion(new Narracion(60, "Ya esta, ya has llegado, aqui estan los maestros, espero que hayas seguido mi consejo. Te dejo solo ante el peligro."));
			
		//Nivel 2
			this.aniadirNarracion(new Narracion(01, "Al final has conseguido pasar. Te estas haciendo respetar. Si continuas accederas al gimnasio."));
			this.aniadirNarracion(new Narracion(11, "Vaya, te estan bloqueando el acceso! Solo si consigues derrotar a este entrenador conseguiras entrar"));
			this.aniadirNarracion(new Narracion(21, "Lo has conseguido una vez mas. Bienvenido al gimnasio de Dafgus! Es tan solo un pequeno pueblos, pero sus habitantes tienen mucho tiempo libre para entrenar."));
			this.aniadirNarracion(new Narracion(31, "He aqui tu primer maton. Nadie que no le gane es digno de combatir contra el lider del gimnasio."));
			this.aniadirNarracion(new Narracion(41, "Le has conseguido vencer, sigue entrenandote para la gran batalla."));
			this.aniadirNarracion(new Narracion(51, "Ten cuidado con este tipo, es mas poderoso que el anterior. Acuerdate de que tu companero este en condiciones, pronto tendras que enfrentarte contra el lider supremo del gimnasio y sus dos camaradas."));
			this.aniadirNarracion(new Narracion(61, "Llego la hora del gran combate. Esta en juego la medalla, y quien no se la merece no la puede conseguir."));

		//Nivel 3	
			this.aniadirNarracion(new Narracion(02, "No me lo puedo creer, "+Jugador.getJugador().getNombre()+ ", has conseguido la medalla, la liga esta cada vez mas cerca." ));
			this.aniadirNarracion(new Narracion(12, "Vaya, resulta que unos indeseables te lo van a poner dificil. Han secuestrado a los entrenadores de la liga. Deberas rescatarlos. Aqui esta el primer villano, demuestrale tus habilidades y que no se te escape!"));
			this.aniadirNarracion(new Narracion(22, "Le has dado una buena paliza, pero aun hay mas desaparecidos."));
			this.aniadirNarracion(new Narracion(32, "Pero que tenemos aqui, otro que quiere huir. Pues no se saldra con la suya, ataca!"));
			this.aniadirNarracion(new Narracion(42, "Lo estas haciendo bien, pero no creas que por salvarlos te lo van a poner mas facil en la Liga, son muy competitivos y no hacen distinciones"));
			this.aniadirNarracion(new Narracion(52, "Otro enemigo, desafortunadamente este no lleva a nadie consigo, pero habra que hacerle cantar. Que empiece el combate!"));
			this.aniadirNarracion(new Narracion(62, "Dice que estos son los ultimos, derrotalos y libera a los prisioneros."));
			
		//Nivel 4
			this.aniadirNarracion(new Narracion(03, "Has salvado la Liga. Por desgracia te has salido del camino y te has desorientado, tendras que encontrar el edificio donde se realizan los combates"));
			this.aniadirNarracion(new Narracion(33, "Parece que hay gente por el camino. Este lugareno te dira como llegar, pero solo si le ganas en un combate"));
			this.aniadirNarracion(new Narracion(23, "Muy bien, parece que tenemos que ir hacia el Sur."));
			this.aniadirNarracion(new Narracion(33, "Otro lider, a ver si este nos puede decir por donde queda la Liga."));
			this.aniadirNarracion(new Narracion(43, "Perfecto, ahora tenemos que ir hacia el Oeste. Si, ya estamos llegando."));
			this.aniadirNarracion(new Narracion(53, "Ahora resulta que hay dos caminos y tenemos a otro entrenador que rehusa a ayudarnos sin antes haberle derrotado."));
			this.aniadirNarracion(new Narracion(63, "Vale, ahora hacia el Norte. Que tenemos aqui? Otra reunion de entrenadores. Venga, demuestra quien es el mas fuerte o no te dejaran avanzar."));
			
		//Nivel 5	
			this.aniadirNarracion(new Narracion(04, "Bienvenido a la Liga, seras tu el conquistador, "+Jugador.getJugador().getNombre() +"?"));
			this.aniadirNarracion(new Narracion(14, "Aqui son todos muy poderosos, ve con cuidado"));
			this.aniadirNarracion(new Narracion(24, "Quizas le hayas ganado, pero no te lo creas demasiado, es solo el primero"));
			this.aniadirNarracion(new Narracion(34, "Otro lider, no creo que esta vez te sea tan facil."));
			this.aniadirNarracion(new Narracion(44, "Estas a un paso de combatir contra los mandamases, seras digno de ello?"));
			this.aniadirNarracion(new Narracion(54, "Aqui estan los jefes de la Liga, a cada cual mas poderoso que el anterior, que la suerte te acompane y que la fuerza este de tu lado."));
			this.aniadirNarracion(new Narracion(64, "Enhorabuena, eres el Conquistador de la Liga. Les has derrotado a todos. Ahora puedes continuar el juego luchando contra entrenadores aun mas poderosos. Eres el campeon, "+Jugador.getJugador().getNombre()));

	}
	
	public int getTamano()
	{
		return this.getLista().size();
	}
	
}
