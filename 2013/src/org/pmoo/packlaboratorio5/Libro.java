package org.pmoo.packlaboratorio5;
public class Libro
{
	// atributos
	private String titulo;
	private String autor;
	private int idLibro;
	// constructora
	public Libro(String pTitulo, String pAutor, int pIdLibro)
	{
		this.titulo=pTitulo;
		this.autor=pAutor;
		this.idLibro=pIdLibro;
	} 
	// getters y setters
	private	String getTitulo()
	{
		return this.titulo;
	}
	public int getIdLibro()
	{
		return this.idLibro;
	}
	private String getAutor()
	{
		return this.autor;
	}
	// otros métodos
	public boolean tieneEsteId (int pIdLibro)
	{
		if(pIdLibro==this.getIdLibro())
		{	return true;	}
		else
		{	return false;	}
	}
	public void imprimir() 
	{
		System.out.println(this.getTitulo()+", escrito por "+this.getAutor()+".");
	}
}