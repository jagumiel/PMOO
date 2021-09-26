package org.pmoo.proyecto;

public class PersonajeDelMapa {
	private String nombre;
	private Carta suCarta;
	private int vecesderrotado;
	private int regala;
	
	public PersonajeDelMapa(String pNombre, Carta pSuCarta)
	{
		this.nombre=pNombre;
		this.suCarta=pSuCarta;
		this.vecesderrotado=0;
		this.regala=0;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}

	public Carta getSuCarta() {
		return suCarta;
	}
	public int getVecesDerrotado()
	{
		return this.vecesderrotado;
	}
	public int getRegala()
	{
		return this.regala;
	}
	public void setRegala(int pRegala)
	{
		this.regala=pRegala;
	}
	public void sumarVecesDerrotado()
	{
		this.vecesderrotado=this.getVecesDerrotado()+1;
	}
	public void setSuCarta(Carta pSuCarta) {
		this.suCarta = pSuCarta;
	}
	
	public void imprimirInfoPersonaje(){
		System.out.println("Nombre: "+this.getNombre()+". Carta: "+this.getSuCarta().getNombre()+
				". Nivel: "+this.getSuCarta().getNivel()+". Tipo: "+this.getSuCarta().getTipo());
	}
	
}
