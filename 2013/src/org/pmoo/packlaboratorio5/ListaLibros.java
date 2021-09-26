package org.pmoo.packlaboratorio5;
import java.util.ArrayList;
import java.util.Iterator;
public class ListaLibros
{
    // atributos
	private ArrayList<Libro> lista;
	// constructora222
	public ListaLibros()
	{
		this.lista=new ArrayList<Libro>();
	}
	// otros métodos
	public int getTamano()
	{  
		return this.lista.size();
	}
	private Iterator<Libro> getIterador()
	{
		return this.lista.iterator();
	}
	public Libro buscarLibroPorId(int pIdLibro)
	{
		Libro libro;
	    Iterator<Libro> itr=this.getIterador();
	    while(itr.hasNext())
	    {
	    	libro=itr.next();
	    	if(libro.tieneEsteId(pIdLibro))
	    	{	return libro; }
	    }
	    return null;
	}
  	public boolean esta(Libro pLibro)
	{
  		if(this.buscarLibroPorId(pLibro.getIdLibro())==null)
  		{	return false;}
  		else
  		{	return true;	}
	}
	public void anadirLibro(Libro pLibro)
    {
	   this.lista.add(pLibro);
    }
    public void eliminarLibro(Libro pLibro)
    {
	   this.lista.remove(pLibro);
    }
	public void imprimir()
    {
		Iterator<Libro>	itr=this.getIterador();
		while(itr.hasNext())
		{	itr.next().imprimir();	}
    }
 }