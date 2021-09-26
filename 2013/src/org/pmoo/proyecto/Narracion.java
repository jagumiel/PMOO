package org.pmoo.proyecto;

public class Narracion {
	private int id;
	private String texto;
	
	public Narracion(int pId, String pTexto)
	{
		this.id=pId;
		this.texto=pTexto;
	}


	private String getTexto() {
		return texto;
	}

	private int getId()
	{
		return this.id;
	}
	
	public boolean tieneEsteId(int pId)
	{
		return this.getId()==pId;
	}
	
	public void imprimirTexto()
	{
		System.out.println(this.getTexto());
	}
}
