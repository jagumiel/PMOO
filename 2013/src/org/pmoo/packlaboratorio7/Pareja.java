package org.pmoo.packlaboratorio7;

public class Pareja
{
	// atributos
	Hombre el;
	Mujer ella;
	// constructora
	/**
	 * 
	 * @param pAlumno1
	 * @param pAlumno2
	 * post: si los alumnos pAlumno1 y pAlumno2 son instancias de un Hombre y de una Mujer (sin importar cuál
	 *       de ellos es el hombre cuál es la mujer - ESTO ES, el orden en el que vengan no importa mientras
	 *       sean uno de cada sexo), se crea una nueva pareja. 
	 *       Si los dos alumnos son del mismo sexo, se muestra un mensaje indicando que no se ha podido crear
	 *       la pareja y se dejan los atributos correspondientes con el valor null.
	 */
	public Pareja(Alumno pAlumno1, Alumno pAlumno2)
	{
		if(pAlumno1 instanceof Hombre && pAlumno2 instanceof Mujer)
		{
			this.el=(Hombre)pAlumno1;
			this.ella=(Mujer)pAlumno2;
		}
		else if(pAlumno2 instanceof Hombre && pAlumno1 instanceof Mujer)
		{
			this.el=(Hombre)pAlumno2;
			this.ella=(Mujer)pAlumno1;
		}
		else
		{
			this.el=null;
			this.ella=null;
			System.out.println("Los integrantes de la pareja deben ser de sexo opuesto.");
		}
		//TODO completar
	}
	
	// getters y setters
	
	/**
	 * 
	 * @return el atributo de tipo Hombre de la pareja
	 */
	public Hombre getEl()
	{
		//TODO completar
		return this.el;
	}
	
	public void setEl(Hombre pEl)
	{
		this.el=pEl;
	}
	/**
	 * 
	 * @return el atributo de tipo Mujer de la pareja
	 */
	public Mujer getElla()
	{
		//TODO completar
		return this.ella;
	}
	public void setElla(Mujer pElla)
	{
		this.ella=pElla;
	}
	
	/**
	 * 
	 * @param pAlumno
	 * @return un booleano que indica si el alumno pAlumno es alguno de los miembros de la pareja
	 */
	public boolean esta(Alumno pAlumno)
	{
		boolean esta=false;
		if(pAlumno==this.el||pAlumno==this.ella)
		{
			esta=true;
		}
		return esta;
	}
}
