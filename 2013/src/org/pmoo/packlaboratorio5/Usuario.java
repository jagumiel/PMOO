package org.pmoo.packlaboratorio5;
public class Usuario
{
	//atributos
	private int idUsuario;
	private int maxLibros;
	private String nombreCompleto;
	private ListaLibros librosEnPrestamo;
	//constructora
	public Usuario(String pNombreCompleto, int pIdUsuario)
	{
		this.nombreCompleto=pNombreCompleto;
		this.idUsuario=pIdUsuario;
		this.maxLibros=3;
		librosEnPrestamo=new ListaLibros();
	}
	// getters y setters
	private int getMaxLibros()
	{
		return this.maxLibros;
	}
	private String getNombreCompleto()
	{
		return this.nombreCompleto;
	}
	private int getIdUsuario()
	{
		return this.idUsuario;
	}
	// otros métodos
	public boolean tieneEsteId(int pId)
	{
		if(this.getIdUsuario()==pId)
		{	return true;	}
		else
		{	return false;	}
	}
	public boolean tieneMismoId(Usuario pUsuario)
	{
		return pUsuario.tieneEsteId(this.getIdUsuario());
	}
	private int cuantosLibrosTiene()
	{
		return this.librosEnPrestamo.getTamano();
	}
	public boolean haAlcanzadoElMaximo()
	{
		if(this.getMaxLibros()==this.cuantosLibrosTiene())
		{	return true;	}
		else
		{	return false;	}
	}
	public void anadirLibro(Libro pLibro)
	{
		this.librosEnPrestamo.anadirLibro(pLibro);
	}
	public void eliminarLibro(Libro pLibro)
	{
		this.librosEnPrestamo.eliminarLibro(pLibro);
	}
	public boolean loTieneEnPrestamo(Libro pLibro)
	{
		return this.librosEnPrestamo.esta(pLibro);
	}
	public void imprimir()
	{
		System.out.println("ID: "+this.getIdUsuario()+" nombre: "+this.getNombreCompleto());
		if(this.librosEnPrestamo.getTamano()==0)
		{	System.out.println("No tiene libros en prestamo.");	}
		else if(this.cuantosLibrosTiene()==1)
		{	System.out.println("Tiene el siguiente libro en prestamo:"); this.librosEnPrestamo.imprimir();	}
		else
		{	System.out.println("Tiene los siguientes libros en prestamo:"); this.librosEnPrestamo.imprimir();	}
	}
}