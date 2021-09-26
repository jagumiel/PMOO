package org.pmoo.packlaboratorio1;

public class Persona 
{
	//atributos
	
	private String nombreCompleto;
	private int edad;
	private int idPersona;
	private String grupoSanguineo;
	private String	nacionalidad ;

	//constructora
	
	public Persona()
	{
		this.nombreCompleto ="desconocido";
		this.edad =0;
		this.idPersona=0;
		this.grupoSanguineo ="desconocido";
		this.nacionalidad	= "desconocido" ;
	}

	//getters y setters
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}


	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}

	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	//otros metodos
	

	// Tiene mismo ID //
	
		public boolean tieneMismoId(Persona pPersona)
		{
			boolean sonIguales=false;
			
			if (this.getIdPersona()==pPersona.getIdPersona())
			{
				sonIguales=true;
			}
			return sonIguales;
		}
			
	// Puede Conducir //
		
		public boolean puedeConducir()
		{
			boolean puedeCon=false;
			
			if (this.getEdad()>=18)
			{	puedeCon=true;	}
			else if (this.getEdad()>=17 && this.getNacionalidad()==("Reino Unido"))
			{	puedeCon=true;   }
			else if (this.getEdad()>=16 &&(this.getNacionalidad()==("USA") || 		this.getNacionalidad()==("Australia")))
			{	puedeCon=true;	}
			else if (this.getEdad()>=14 && this.getNacionalidad()==("Etiopia"))
			{	puedeCon=true;	}
			
			return puedeCon;
		}
		
	// Inicial Nombre y Apellido //
		
		public char getInicialNombre()
		{	
			char inicialNombre=this.getNombreCompleto().charAt(0);
			return inicialNombre;
		}
		
		public char getInicialApellido()
		{
			int posicion=nombreCompleto.lastIndexOf(' ')+1;
			char inicialApellido=this.getNombreCompleto().charAt(posicion);
			return inicialApellido;
		}
		

	// Puede donar sangre //
		
		public boolean puedeDonarleSangre(Persona pPersona)
		{
			boolean donante=false;
			
			int rh=pPersona.getGrupoSanguineo().lastIndexOf('+'); // Si es positivo rh>0 si es negativo rh=-1
			int tieneA=pPersona.getGrupoSanguineo().lastIndexOf('A'); // Si tiene A tieneA>0 sino tieneA=-1
			int tieneB=pPersona.getGrupoSanguineo().lastIndexOf('B'); // Si tiene B tieneB>0 sino tieneB=-1
					
			if (this.getGrupoSanguineo()==("0-"))
			{	donante=true;	}
			else if (this.getGrupoSanguineo()==("0+") && rh>0)
			{	donante=true;	}
			else if (this.getGrupoSanguineo()==("A-") && tieneA>=0)
			{	donante=true;	}
			else if (this.getGrupoSanguineo()==("A+") && tieneA>=0 && rh>0)
			{	donante=true;	}
			else if (this.getGrupoSanguineo()==("B-") && tieneB>=0)
			{	donante=true;	}
			else if (this.getGrupoSanguineo()==("B+") && tieneB>=0 && rh>0)
			{	donante=true;	}
			else if (this.getGrupoSanguineo()==("AB-") && tieneA>=0 && tieneB>=0)
			{	donante=true;	}
			else if (this.getGrupoSanguineo()==("AB+") && tieneA>=0 && tieneB>=0 && rh>0)
			{	donante=true;	}
			
			return donante;
		}
		
}

	

