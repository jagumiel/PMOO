package org.pmoo.packlaboratorio5;
import java.util.ArrayList;
import java.util.Iterator;
public class ListaUsuarios
{
	// atributos
	private ArrayList<Usuario> lista;
	private static ListaUsuarios miListaUsuarios=new ListaUsuarios();
	// constructora
	private ListaUsuarios()
    { 
    	this.lista=new ArrayList<Usuario>();
    }
   	// getters y setters
    public synchronized static ListaUsuarios getListaUsuarios()
   	{
   		return miListaUsuarios;
   	}
    // otros métodos
   	public int getTamano()
   	{
   		return this.lista.size();
   	}
   	private Iterator<Usuario> getIterador()
   	{
   		return this.lista.iterator();
   	}
    public Usuario buscarUsuarioPorId(int pId)
   	{
   		Usuario user;
   		Iterator<Usuario> itr=ListaUsuarios.getListaUsuarios().getIterador();
   		while(itr.hasNext())
   		{
   			user=itr.next();
   			if(user.tieneEsteId(pId))
   			{	return user;	}
   		}
   		return null;
   	}
   	public boolean existeUsuarioConMismoId(Usuario pUsuario)
   	{
   		Iterator<Usuario> itr=ListaUsuarios.getListaUsuarios().getIterador();
   		while(itr.hasNext())
   		{
   			if(itr.next().tieneMismoId(pUsuario))
   			{	return true;	}
   		}
   		return false;
   	}
   	public void darDeAltaUsuario(Usuario pUsuario)
   	{
	   	if(ListaUsuarios.getListaUsuarios().existeUsuarioConMismoId(pUsuario))
	   	{	System.out.println("El usuario ya existe.");	}
	   	else
	   	{	ListaUsuarios.getListaUsuarios().lista.add(pUsuario);	}
   	}
   	public void darDeBajaUsuario(int pIdUsuario)
	{
   		Usuario unUsuario;
   		unUsuario=ListaUsuarios.getListaUsuarios().buscarUsuarioPorId(pIdUsuario);
   		
   		try
   		{
   			if(unUsuario==null)
   			{
   				throw (new noHayUsuarioException());
   			}
   			ListaUsuarios.getListaUsuarios().lista.remove(unUsuario);	
   		}
   		catch(noHayUsuarioException e)
   		{
   			System.out.println("No existe ese usuario");
   		}
	
   	}
   	public Usuario quienLoTienePrestado(Libro pLibro)
   	{
   		Usuario user;
   		Iterator<Usuario> itr=ListaUsuarios.getListaUsuarios().getIterador();
   		while(itr.hasNext())
   		{
   			user=itr.next();
   			if(user.loTieneEnPrestamo(pLibro))
   			{	return user;	}
   		}
   		return null;
   	}
   	public void imprimir()
   	{	
   		System.out.println(ListaUsuarios.getListaUsuarios().getTamano()+" usuarios.");
   		Iterator<Usuario> itr=ListaUsuarios.getListaUsuarios().getIterador();
   		while(itr.hasNext())
   		{
   			itr.next().imprimir();
   		}
   	}
   	public void resetear()
   	{
   		ListaUsuarios.getListaUsuarios().lista.clear();
   	}
}