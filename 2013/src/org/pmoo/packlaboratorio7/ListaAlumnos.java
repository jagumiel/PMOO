package org.pmoo.packlaboratorio7;

import java.util.*;

public class ListaAlumnos
{
	// atributos
	ArrayList<Alumno> lista;

	/**
	 * post: inicializa la lista de alumnos a una lista vacía
	 */
	public ListaAlumnos()
	{
		this.lista=new ArrayList<Alumno>();
	}

	private ArrayList<Alumno> getLista()
	{
		return this.lista;
	}
	// otros métodos

	/**
	 * @param pAlumno
	 *            post: añade el alumno pAlumno a la lista de alumnos
	 */
	public void anadirAlumno(Alumno pAlumno)
	{
		this.getLista().add(pAlumno);
	}

	/**
	 * @param pAlumno
	 *            post: retira el alumno pAlumno de la lista de alumnos
	 */
	public void retirarAlumno(Alumno pAlumno)
	{
		this.getLista().remove(pAlumno);
	}

	/**
	 * @param pAlumno
	 * @return un booleano que indica si el alumno pAlumno está en la lista de
	 *         alumnos
	 */
	public boolean esta(Alumno pAlumno)
	{
		return this.getLista().contains(pAlumno);
	}
	
	/**
	 * @return el número de elementos de la lista de alumnos
	 */  
	public int getTamano()
	{
		// TODO completar
		return this.getLista().size();
	}

	/**
	 * @param pPos
	 * @return el alumno que ocupa la posición pPos de la lista de alumnos
	 *					post: si el parámetro pPos no es válido, se muestra un
	 *						mensaje por pantalla y se devuelve null. Las posiciones
	 *                      de la lista se cuentan empezando en 0 y terminando en
	 *                      n-1, siendo n el número de alumnos que hay en ella.
	 *           
	 */
	 public Alumno getAlumnoEnPos(int pPos)
	 {
			// TODO completar
		 if(pPos>=this.getTamano())
		 {
			 System.out.println("La posicion no existe.");
			 return null;
		 }
		 else if(this.lista.get(pPos)!=null)
		 {
			 return this.lista.get(pPos);
		 }
		 else
		 {
			 System.out.println("La posicion no existe.");
			 return null;
		 }
	 }
}