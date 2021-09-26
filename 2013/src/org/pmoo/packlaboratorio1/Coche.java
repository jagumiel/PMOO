package org.pmoo.packlaboratorio1;

public class Coche 
{
	private String marcaModelo;
	private String matricula;
	private Persona propietario;
	
	public Coche(String pmarcaModelo, String pmatricula) 
	{
		super();
		this.marcaModelo = pmarcaModelo;
		this.matricula = pmatricula;
		this.propietario = null;
	}

	public String getMarcaModelo() {
		return marcaModelo;
	}

	public void setMarcaModelo(String marcaModelo) {
		this.marcaModelo = marcaModelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}
	
	
	
}
