package org.pmoo.packlaboratorio7;

public class Hombre extends Alumno
{
	// constructora
	/**
	 * @param pDNI
	 * @param pNombre
	 * @param pApellido
	 * @param pEdad
	 *            post: invoca a la constructora de la superclase para
	 *            instanciar un alumno Hombre
	 */
	public Hombre(String pDNI, String pNombre, String pApellido, int pEdad)
	{
		// TODO completar
		super(pDNI, pNombre, pApellido, pEdad);
	}

	// otros métodos

	/**
	 * @param pMujer
	 * @return un booleano que indica si la mujer pMujer se encuentra entre las
	 *         preferencias del alumno.
	 */
	public boolean aceptar(Mujer pMujer)
	{
		boolean estaEnLista=false;
		if(this.getListaPreferencias().esta(pMujer))
		{	
			estaEnLista=true;	
		}
		return estaEnLista;
	}

	/**
	 * @param pAlumno
	 *            post: si el parámetro pAlumno es una instancia de Mujer, la
	 *            añade a la lista de preferencias del hombre si no, muestra un
	 *            mensaje de aviso por pantalla y no modifica la lista de
	 *            preferencias.
	 */
	public void anadirPreferencia(Alumno pAlumno)
	{
		if(pAlumno instanceof Mujer)
		{ 
			this.getListaPreferencias().anadirAlumno(pAlumno);
		}
		else
		{
			System.out.println("El alumno debe ser una mujer.");
		}
		// TODO completar
	}
}
