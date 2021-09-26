package org.pmoo.packlaboratorio7;

import java.util.*;

public class ListaParejas
{
	// atributos
	private ArrayList<Pareja> lista;
	private static ListaParejas miListaParejas=new ListaParejas();
	// constructora
	private ListaParejas()
	{
		this.lista=new ArrayList<Pareja>();
	}

	// getters y setters

	/**
	 * @return la única instancia de ListaParejas
	 */
	public static ListaParejas getListaParejas()
	{
		return ListaParejas.miListaParejas;
	}

	// otros métodos
	
	/**
	 * 
	 * @return el iterador de la lista de parejas
	 */
	private Iterator<Pareja> getIterador()
	{
		return ListaParejas.getListaParejas().lista.iterator();
	}
	
	private ArrayList<Pareja> getLista()
	{
		return ListaParejas.getListaParejas().lista;
	}
	
	private void setLista(ArrayList<Pareja> pLista)
	{
		ListaParejas.getListaParejas().lista=pLista;
	}
	/**
	 * pre: la lista de parejas está ordenada por edad de ella, de mayor a menor
	 * post: se añade la pareja pPareja manteniendo el orden PISTA: primero
	 * habrá que usar un iterador para buscar en qué posición debe ir la pareja
	 * a añadir (recuérdese que la primera posición es la 0) y después añadirla
	 * usando el método add(index, element).
	 */
	public void anadirOrdenadoPareja(Pareja pPareja)
	{
	
		Pareja unPareja;
		Iterator<Pareja> itr=ListaParejas.getListaParejas().getIterador(); 
		boolean posHallada=false;
		int pos=0;
		while(itr.hasNext()&&!posHallada)
		{
			unPareja=itr.next();
			if(unPareja.ella.getEdad()>=pPareja.ella.getEdad())
			{
				pos=pos+1;
			}
			else
			{
				posHallada=true;
			}	
		}
		ListaParejas.getListaParejas().getLista().add(pos, pPareja);
	}

	/**
	 * 
	 * @param pAlumno
	 * @return la pareja del alumno pAlumno. Si no existe tal pareja se devuelve
	 *         el valor null.
	 */
	public Alumno obtenerParejaDe(Alumno pAlumno)
	{
		Alumno unAlumno=null;
		Pareja unPareja;
		Iterator<Pareja> itr=ListaParejas.getListaParejas().getIterador(); 
		boolean esta=false;
		
		while(itr.hasNext()&&!esta)
		{
			unPareja=itr.next();
			if(unPareja.getEl().equals(pAlumno))
			{
				esta=true;
				unAlumno=unPareja.getElla();
			}
			else if(unPareja.getElla().equals(pAlumno))
			{
				esta=true;
				unAlumno=unPareja.getEl();
			}
		}
		return unAlumno;
	}
	public boolean tienePareja(Alumno pAlumno)
	{
		Pareja unPareja;
		Iterator<Pareja> itr=ListaParejas.getListaParejas().getIterador(); 
		boolean esta=false;
		
		while(itr.hasNext()&&!esta)
		{
			unPareja=itr.next();
			if(unPareja.esta(pAlumno))
			{
				esta=true;
			}
		}
		return esta;
	}

	/**
	 * post: si ha sido posible, se han reajustado las parejas. Si no ha sido posible,
	 *       la lista de parejas se ha dejado como al principio.
	 *       Se utiliza una lista auxiliar para ir recolocando las parejas en orden descendente de
	 *       edad de la mujer, y una lista con todos los hombres disponibles.
	 *       Para cada mujer, se busca entre la lista de hombres disponibles uno con el que poder emparejarla
	 *       hasta llegar al final de la lista (en cuyo caso se modifica la lista de parejas dejando en su
	 *       lugar la lista de parejas auxiliar) o hasta encontrar una mujer que no se pueda emparejar (en 
	 *       cuyo caso el proceso termina, se muestra un aviso por pantalla y se deja la lista de parejas
	 *       como estaba).
	 * 
	 *       (Ver el enunciado del ejercicio para más detalles sobre el algoritmo de reajuste de
	 *       las parejas.)
	 */
	public void reajustarParejas()
	{
		ArrayList<Pareja> listaAux=new ArrayList<Pareja>();
		ListaAlumnos ListaHombres=new ListaAlumnos();
		Iterator<Pareja> itr=ListaParejas.getListaParejas().getIterador();
		Pareja unPareja;
		while(itr.hasNext())
		{
			unPareja=itr.next();
			ListaHombres.anadirAlumno(unPareja.getEl());
		}
		itr=ListaParejas.getListaParejas().getIterador();
		Hombre unHombre;
		boolean salir=false;
		while(itr.hasNext()&&!salir)
		{
			unPareja=itr.next();
			unHombre=unPareja.getElla().emparejar(ListaHombres);
			if(unHombre==null)
			{
				salir=true;
				System.out.println("No puede realizarse el reajuste de las parejas.");
			}
			else
			{
				listaAux.add(new Pareja(unHombre,unPareja.getElla()));
			}
		}
		
		if(!salir)
		{
			ListaParejas.getListaParejas().setLista(listaAux);
		}
		// TODO completar
	}

	/**
	 * vacía la lista de parejas del curso
	 */
	public void resetear()
	{
		ListaParejas.getListaParejas().getLista().clear();
	}
}
