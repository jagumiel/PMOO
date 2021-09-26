package org.pmoo.proyecto;

public abstract class Carta {
	private String nombre;
	private int ataque;
	private int defensa;
	private int nivel;
	private int vidaActual;
	private int vidaMaxima;
	private int velocidad;
	public Carta(String pNombre, int pNivel)
	{
		this.nombre=pNombre;
		this.nivel=pNivel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}

	public int getNivel() {
		return nivel;
	}

	protected void setNivel(int pNivel) {
		this.nivel = pNivel;
	}

	public int getAtaque() {
		return ataque;
	}

	protected void setAtaque(int pAtaque) {
		this.ataque = pAtaque;
	}

	public int getDefensa() {
		return defensa;
	}

	protected void setDefensa(int pDefensa) {
		this.defensa = pDefensa;
	}

	public int getVelocidad() {
		return velocidad;
	}

	protected void setVelocidad(int pVelocidad) {
		this.velocidad = pVelocidad;
	}

	public int getVidaActual() {
		return vidaActual;
	}

	protected void setVidaActual(int pVidaActual) {
		this.vidaActual = pVidaActual;
	}

	public int getVidaMaxima() { //publico porque lo tiene que saber Jugador para curar la carta.
		return vidaMaxima;
	}

	protected void setVidaMaxima(int pVidaMaxima) {
		this.vidaMaxima = pVidaMaxima;
	}
	
	public abstract void actualizarNivel(int pNuevoNivel);
	
	
	public void imprimirResultadoAtaque(int pDanoCausado, Carta pCartaRival)
	{
		System.out.println("La carta "+this.getNombre()+" ataca causando un dano de "+pDanoCausado+" a la carta "+pCartaRival.getNombre()+ " por lo que le quedan ");

		if(pCartaRival.getVidaActual()>0){
			System.out.println(pCartaRival.getVidaActual()+" puntos de vida.");
		}else{
			System.out.println("0 puntos de vida.");
		}
	}
	
	public void imprimirNivelYAtributos()
	{
		System.out.println(" ");
		System.out.println("Tu carta "+this.getNombre()+ " esta en el nivel "+ this.getNivel()+" y tiene las siguientes caracteristicas:");
		System.out.println(" ");
		System.out.println("******************");
		System.out.println("Tipo: "+this.getTipo());
		System.out.println("Ataque: "+this.getAtaque());
		System.out.println("Defensa: "+this.getDefensa());
		System.out.println("Velocidad: "+this.getVelocidad());
		System.out.println("HP: "+this.getVidaActual()+"/"+this.getVidaMaxima());
	}
	
	public void recuperarVida(){
		this.setVidaActual(this.getVidaMaxima());
	}
	
	public abstract String getTipo();

}
