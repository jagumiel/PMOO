package org.pmoo.packlaboratorio7;

public abstract class Alumno extends Object
{
	// atributos
	private String dni;
	private String nombre;
	private String apellido;
	private int edad;
	private ListaAlumnos listaPreferencias;
	// constructora
	/**
	 * 
	 * @param pDNI
	 * @param pNombre
	 * @param pApellido
	 * @param pEdad
	 *            post: se inicializa un nuevo objeto de la clase Alumno con dni
	 *            pDNI, nombre pNombre apellido pApellido, edad pEdad y una
	 *            lista de preferencias vacia
	 */
	public Alumno(String pDNI, String pNombre, String pApellido, int pEdad)
	{
		this.dni=pDNI;
		this.nombre=pNombre;
		this.apellido=pApellido;
		this.edad=pEdad;
		this.listaPreferencias=new ListaAlumnos();
		// TODO completar
	}

	// getters y setters	
	/**
	 * 
	 * @return la lista de preferencias del alumno
	 */
	protected ListaAlumnos getListaPreferencias()
	{
		// TODO completar
		return this.listaPreferencias;
	}

	/**
	 * 
	 * @return el nombre del alumno
	 */
	public String getNombre()
	{
		// TODO completar
		return this.nombre;
	}

	/**
	 * 
	 * @return el apellido del alumno
	 */
	public String getApellido()
	{
		// TODO completar
		return this.apellido;
	}

	/**
	 * 
	 * @return la edad del alumno
	 */
	public int getEdad()
	{
		// TODO completar
		return this.edad;
	}

	/**
	 *  
	 * @return el dni del alumno
	 */
	public String getDNI()
	{
		// TODO completar
		return this.dni;
	}

	// otros métodos
	
	// hace falta cabecera aunque no se implemente.
	public abstract void anadirPreferencia(Alumno pAlumno);

}

