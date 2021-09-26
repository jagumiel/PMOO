package org.pmoo.proyecto;

public class Coordenada {
	private int posCol;
	private int posFil;
	//Recordad que en Java lo que llamamos pos1 es la pos0.
	
	public Coordenada(int col, int fil)
	{
		this.posCol=col;
		this.posFil=fil;
	}

	public int getPosFil() {
		return posFil;
	}

	public int getPosCol() {
		return posCol;
	}

	/*private void setPosFil(int posFil) {
		this.posFil = posFil;
	}

	private void setPosCol(int posCol) {
		this.posCol = posCol;
	}
	
	//No tenemos los setters en el diagrama, nos sobran?.
*/
}
