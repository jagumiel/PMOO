package org.pmoo.packlaboratorio7;

public class Mujer extends Alumno
{
	// constructora
	/**
	 * @param pDNI
	 * @param pNombre
	 * @param pApellido
	 * @param pEdad
	 *            post: invoca a la constructora de la superclase para
	 *            instanciar un alumno Mujer
	 */
	public Mujer(String pDNI, String pNombre, String pApellido, int pEdad)
	{
		// TODO completar
		super(pDNI,pNombre, pApellido, pEdad);
	}
	
// otros métodos
	
	/**
	 * 
	 * @param pHombreDisponibles
	 * @return devuelve el primer Hombre de los que hay en la lista de preferencias
	 *         de la mujer que se encuentre en la lista de alumnos pHombresDisponibles
	 *         y que acepta a la mujer actual (esto es, la tiene entre sus propias
	 *         preferencias).
	 *         Si no existe tal hombre, se devuelve el objeto null.
	 *         Si en la lista pHombresDisponibles se encuentra alguna mujer, se muestra
	 *         un aviso por consola y se devuelve null.
	 */
	public Hombre emparejar(ListaAlumnos pHombreDisponibles)
	{
		Hombre unHombre=null;
		int cuantosHombres=pHombreDisponibles.getTamano();
		int enPreferencia=this.getListaPreferencias().getTamano();
		int i=0;
		boolean flag=false;
		for(i=0;i<cuantosHombres&&!flag;i=i+1)
		{	
			if(pHombreDisponibles.getAlumnoEnPos(i) instanceof Mujer)
			{
				flag=true;
				unHombre=null;
				System.out.println("Hay una mujer en la lista de preferencias.");
			}
			
		}
		for(i=0;i<enPreferencia&&!flag;i=i+1)
		{
				unHombre=(Hombre)this.getListaPreferencias().getAlumnoEnPos(i);
				if(pHombreDisponibles.esta(unHombre)&&unHombre.getListaPreferencias().esta(this))
				{
					flag=true;
				}
				else
				{
					unHombre=null;
				}
		}	
		return unHombre;
	}

	/**
	 * @param pAlumno
	 *            post: si el parámetro pAlumno es una instancia de Hombre, la
	 *            añade a la lista de preferencias de la mujer si no, muestra un
	 *            mensaje de aviso por pantalla y no modifica la lista de
	 *            preferencias.
	 */
	public void anadirPreferencia(Alumno pAlumno)
	{
		if(pAlumno instanceof Hombre)
		{
			this.getListaPreferencias().anadirAlumno(pAlumno);
		}
		else
		{
			System.out.println("El alumno debe ser un Hombre.");
		}
		// TODO completar
	}
}
