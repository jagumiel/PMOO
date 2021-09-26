package org.pmoo.proyecto;
import java.util.*;

public class Combate 
{
	private Carta carta1; //La carta del Jugador
	private Carta carta2; //La carta del rival
	int A1,A2,N1,N2,D1,D2;
	double M1,M2,P1;//multiplicador de tipo y probabilidad de ataque
	public Combate(Carta pCarta1, Carta pCarta2)
	{
		this.setCarta1(pCarta1);
		this.setCarta2(pCarta2);
		A1=this.carta1.getAtaque();
		A2=this.carta2.getAtaque();
		N1=this.carta1.getNivel();
		N2=this.carta2.getNivel();
		D1=this.carta1.getDefensa();
		D2=this.carta2.getDefensa();
		this.asignarFactoresDeDano();
	}
	
	public Carta getCarta1()
	{
		return carta1;
	}
	
	public Carta getCarta2()
	{
		return carta2;
	}
	public void setCarta1(Carta pCarta)
	{
		this.carta1=pCarta;
	}
	public void setCarta2(Carta pCarta)
	{
		this.carta2=pCarta;
	}

	public boolean simularCombate()
	{
		boolean haGanado = false;
		int dmg=0;
		
		Random generador=new Random();
		int dado;
		double variacion;//valor que oscila entre 0.9 y 1.1
		
		while((this.getCarta1().getVidaActual()>0)&&(this.getCarta2().getVidaActual())>0)	
		{
			dado=generador.nextInt(10);
			variacion=(generador.nextDouble()*20+90)/100;
			if(dado>P1)
			{
				
				dmg=(int)Math.floor((((((2.0*N1/5.0)+2)*A1)/D2)/50+2)*M1*variacion);
				this.cambiarVida(this.getCarta2(), dmg);
				this.carta1.imprimirResultadoAtaque(dmg, this.getCarta2());
				try
				{
					Thread.sleep(600);
				}
				catch(InterruptedException ex)
				{
					Thread.currentThread().interrupt();
				}
			}
			else
			{
				dmg=(int)Math.floor((((((2.0*N2/5.0)+2)*A2)/D1)/50+2)*M2*variacion);
				
				this.cambiarVida(this.getCarta1(), dmg);
				
				this.carta2.imprimirResultadoAtaque(dmg, this.getCarta1());
				try
				{
					Thread.sleep(6);
				}
				catch(InterruptedException ex)
				{
					Thread.currentThread().interrupt();
				}
			}
			 
		}
		
		if(this.getCarta1().getVidaActual()>0)
		{
			haGanado=true;
			this.getCarta2().recuperarVida();
			this.getCarta2().actualizarNivel(this.getCarta2().getNivel());

		}
		
		
		return haGanado;
	}
	
	private void asignarFactoresDeDano()
	{
		if(this.getCarta1().getVelocidad()>this.getCarta2().getVelocidad())
		{
			P1=4;
		}
		else if(this.getCarta1().getVelocidad()<this.getCarta2().getVelocidad())
		{
			P1=6;
		}
		else
		{
			P1=5;
		}
		if(this.carta1 instanceof Fuego)//Carta del jugador es fuego
		{
			if(this.carta2 instanceof Fuego)
			{
				M1=1;
				M2=1;
			}
			else if(this.carta2 instanceof Agua)
			{
				M1=0.8;
				M2=1.2;
			}
			else if(this.carta2 instanceof Hoja)
			{
				M1=1.2;
				M2=0.8;
			}
			else if(this.carta2 instanceof Psico)
			{
				M1=1;
				M2=1;
			}
		}
		else if(this.carta1 instanceof Agua)//Carta del jugador es agua
		{
			if(this.carta2 instanceof Agua)
			{
				M1=1;
				M2=1;
			}
			else if(this.carta2 instanceof Hoja)
			{
				M1=0.8;
				M2=1.2;
			}
			else if(this.carta2 instanceof Psico)
			{
				M1=1;
				M2=1;
			}
			else if(this.carta2 instanceof Fuego)
			{
				M1=1.2;
				M2=0.8;
			}
		}
		else if(this.carta1 instanceof Hoja)//Carta del jugador es Hoja
		{
			if(this.carta2 instanceof Hoja)
			{
				M1=1;
				M2=1;
			}
			else if(this.carta2 instanceof Fuego)
			{
				M1=0.8;
				M2=1.2;
			}
			else if(this.carta2 instanceof Psico)
			{
				M1=1;
				M2=1;
			}
			else if(this.carta2 instanceof Agua)
			{
				M1=1.2;
				M2=0.8;
			}
		}
		else if(this.carta1 instanceof Psico)//Carta del jugador es Psiqui
		{
			
				M1=1;
				M2=1;
		}
	}
	private void cambiarVida(Carta pCarta, int pDmg)
	{
		int vidaActual;
		vidaActual=pCarta.getVidaActual()-pDmg;
		if(vidaActual<0)
		{
			pCarta.setVidaActual(0);
		}
		else
		{
			pCarta.setVidaActual(vidaActual);
		}
	}
}