package com.poker.project.multimodule.base.mazos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.poker.project.multimodule.base.Carta;
import com.poker.project.multimodule.base.Palo;

/**
 * Estructura de un mazo de cartas de una baraja francesa
 * @author victor
 *
 */
public class Mazo 
{
	private List<Carta> cartas;
	private boolean seleccionada[][];
	
	public Mazo()
	{
		cartas = new  ArrayList<>();
		seleccionada= new boolean[4][13];
		
		for(Palo p : Palo.values())
		{
			for(int i=1;i<14;i++)//cambiado
				cartas.add(new Carta(i,p));
		}
	}
	
	public void seleccionarCarta(Carta c )
	{
		if(c==null) return ;
		int n= c.getNum()-1;
		int p= c.getPalo().ordinal();
		
		seleccionada[p][n]=true;
		
	}
	
	public boolean estaSeleccionada(Carta c)
	{
		if(c==null) return false;
		int n= c.getNum()-1;
		int p= c.getPalo().ordinal();
		
		return this.seleccionada[p][n];
	}
	
	/**
	 * Extrae una carta del mazo
	 * @return carta aleatoria
	 */
	public Carta dameCartaAleatoria()
	{
		Random r = new Random();
		int i =0;
		Carta c =null;
		
	//	System.out.println("mazo de cartas:  "+mazo.size());
		while(!estaSeleccionada(c) && !cartas.isEmpty())
		{
			i = r.nextInt(cartas.size());
			c= cartas.get(i);
			if(!estaSeleccionada(c))
			{
				cartas.remove(i);
				seleccionarCarta(c);
			}
			else c=null;
			
		}
		
		
		
		
		return c;
	}
	
	
	/**
	 * Extrae n cartas del mazo
	 * @return cartas aleatorias
	 */
	public ArrayList<Carta> dameNCartas(int n)
	{
		 ArrayList<Carta> a = new  ArrayList<Carta>();
		 for(int i=0;i<n;i++)
			 a.add(dameCartaAleatoria());
		 return a;
	}
	/**
	 * Devuelve si hay cartas en el mazo
	 * @return
	 */
	public boolean estaVacio()
	{
		return cartas.isEmpty();
	}
	
	/**
	 * Devuelve si la carta c , est� en el mazo
	 * @param c
	 * @return
	 */
	public boolean estaCarta(Carta c)
	{
		return !estaSeleccionada(c);//mazo.contains(c);
	}
	
	/**
	 * Retira la carta c del mazo
	 * @param c
	 * @return
	 */
	public boolean quitaCarta(Carta c)
	{
		//System.out.println("quito la carta " +c);
		//return mazo.remove(c);
		seleccionarCarta(c);
		if(estaCarta(c))
		{
			//System.out.println("esta la carta " +c);
			seleccionarCarta(c);
			//System.out.println("borro la carta " +c);
			return cartas.remove(c);
		}
		else return false;
	}
	
	
	public Mazo clonar()
	{
		Mazo m = new Mazo();
		m.cartas.addAll(this.cartas);//bien???
		
		for(Palo p : Palo.values())
			for(int i=1;i<14;i++)//cambiado
					m.seleccionada[p.ordinal()][i]= this.seleccionada[p.ordinal()][i];
		return m;
	}
	
	/*
	public static void main(String args [])
	{
		Mazo m = new Mazo();
		
		while(!m.estaVacio())
		{
			System.out.println(m.dameCartaAleatoria());
		}
		
	}*/
}
