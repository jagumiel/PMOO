package org.pmoo.packlaboratorio5;
public class Catalogo
{
	// atributos
	private ListaLibros lista;
	private static Catalogo miCatalogo=new Catalogo();
	// constructora
	private Catalogo()
	{ 
		this.lista=new ListaLibros();
	}
	// getters y setters
	public static Catalogo getCatalogo() 
	{
		return miCatalogo;
	}
	// otros métodos
 	public int getTamano()
 	{
 		return this.lista.getTamano();
 	}
 	public Libro buscarLibroPorId(int pIdLibro)
 	{
 	 	return this.lista.buscarLibroPorId(pIdLibro); 
 	}
 	public void prestarLibro(int pIdLibro, int pIdUsuario)
	{
 		Usuario	user= ListaUsuarios.getListaUsuarios().buscarUsuarioPorId(pIdUsuario);
 		Libro libro=Catalogo.getCatalogo().buscarLibroPorId(pIdLibro);
 		if(user==null)
 		{	System.out.println("El usuario no existe.");	}
 		else if(user.haAlcanzadoElMaximo())
		{	System.out.println("El usuario ha alcanzado el limite de prestados.");		}
 		else if(libro==null)
 		{	System.out.println("El libro no existe.");	}
 		else if(ListaUsuarios.getListaUsuarios().quienLoTienePrestado(libro)!=null)
 		{	System.out.println("El libro ya esta prestado.");	}
 		else
 		{	
 			ListaUsuarios.getListaUsuarios().buscarUsuarioPorId(pIdUsuario).anadirLibro(libro);
 			System.out.println("El libro se ha prestado al usuario.");
 		}
	}
 	public void devolverLibro(int pIdLibro)
	{
 		Libro unLibro=Catalogo.getCatalogo().buscarLibroPorId(pIdLibro);
 		try
 		{
 			if(unLibro!=null)
 			{
 				Usuario unUsuario=ListaUsuarios.getListaUsuarios().quienLoTienePrestado(unLibro);
 				if(unUsuario!=null)
 				{
 					ListaUsuarios.getListaUsuarios().quienLoTienePrestado(unLibro).eliminarLibro(unLibro);
 					System.out.println("El libro ha sido eliminado de la lista del usuario.");
 				}
 				else
 				{
 					throw(new noEstaPrestadoException());
 				}
 			}
 			else
 			{
 				throw(new noExisteLibroException());
 			}
 		}
 		catch(noEstaPrestadoException e)
 		{
 			System.out.println("Ningún usuario tiene ese libro prestado.");
 		}
 		catch(noExisteLibroException e)
 		{
 			System.out.println("El libro no existe.");
 		}
	}
 	public void catalogarLibro(Libro pLibro)
 	{
 		try
 		{
 			if(Catalogo.getCatalogo().buscarLibroPorId(pLibro.getIdLibro())!=null)
 			{
 				throw (new LibroYaCatalogadoException());
 			}
 			else
 			{
 				Catalogo.getCatalogo().lista.anadirLibro(pLibro);
 			}
 		}
 		catch(LibroYaCatalogadoException e)
 		{
 			System.out.println("El libro ya estaba catalogado.");
 		}
 	}
 	public void descatalogarLibro(int pIdLibro)
 	{
 		Libro libro=Catalogo.getCatalogo().buscarLibroPorId(pIdLibro);
		if(libro==null)
		{	System.out.println("El libro no existe.");	}
		else
		{	Catalogo.getCatalogo().lista.eliminarLibro(libro);	}
 	}
 	public void imprimir()
 	{
 		System.out.println("El catalogo tiene un total de "+Catalogo.getCatalogo().getTamano()+" títulos.");
 		Catalogo.getCatalogo().lista.imprimir();
 	}
 	public void resetear()
 	{
 		Catalogo.getCatalogo().lista=new ListaLibros();
 	}
}	