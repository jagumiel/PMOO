package org.pmoo.packlaboratorio7;

import java.util.*;

public class ListaAlumnosCurso
{
	// atributos
	private static ListaAlumnosCurso miListaAlumnosCurso= new ListaAlumnosCurso();
	private ArrayList<Alumno> lista;
	// constructora
	private ListaAlumnosCurso()
	{
		this.lista=new ArrayList<Alumno>();
	}

	// getters y setters

	/**
	 * @return la única instancia de ListaAlumnosCurso
	 */
	public static ListaAlumnosCurso getListaAlumnosCurso()
	{
		// TODO completar
		return miListaAlumnosCurso;
	}

	private ArrayList<Alumno> getLista()
	{
		return this.lista;
	}
	
	// otros métodos
	
	/**
	 * 
	 * @param pAlumno
	 *            post: si el alumno no está dado de alta en el curso, lo añade.
	 *            Si no, escribe un mensaje y no hace nada más
	 */
	public void anadirAlumnoCurso(Alumno pAlumno)
	{
		// TODO completar
		if(ListaAlumnosCurso.getListaAlumnosCurso().buscarAlumnoPorDNI(pAlumno.getDNI())==null)
		{
			ListaAlumnosCurso.getListaAlumnosCurso().getLista().add(pAlumno);
		}
		else
		{
			System.out.println("El alumno ya existe");
		}
	}

	/**
	 * 
	 * @return el iterador de la lista de alumnos del curso
	 */
	private Iterator<Alumno> getIterador()
	{
		// TODO completar
		return this.getLista().iterator();
	}

	/**
	 * vacía la lista de alumnos del curso
	 */
	public void resetear()
	{
		ListaAlumnosCurso.getListaAlumnosCurso().getLista().clear();
		// TODO completar
	}

	/**
	 * 
	 * @param pDNI
	 * @return el alumno del curso cuyo DNI es pDNI. Si no existe tal alumno,
	 *         devuelve el objeto null.
	 */
	public Alumno buscarAlumnoPorDNI(String pDNI)
	{
		boolean esta=false;
		Alumno unAlumno=null;
		Iterator<Alumno> itr=ListaAlumnosCurso.getListaAlumnosCurso().getIterador();
		while(itr.hasNext()&&!esta)
		{
			unAlumno=itr.next();
			if(unAlumno.getDNI()==pDNI)
			{
				esta=true;
			}
		}
		if(esta)
		{
			return unAlumno;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * 
	 * @return un booleano que indica si hay algún alumno del curso que no tenga
	 *         pareja en la lista de parejas
	 */
	public boolean hayAlumnosSinPareja()
	{
		boolean sinPareja=false;
		Alumno unAlumno;
		Iterator<Alumno> itr=ListaAlumnosCurso.getListaAlumnosCurso().getIterador();
		while(itr.hasNext()&&!sinPareja)
		{
			unAlumno=itr.next();
			if(!ListaParejas.getListaParejas().tienePareja(unAlumno))
			{
				sinPareja=true;
			}
		}
		return sinPareja;
	}
}