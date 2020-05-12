package com.poker.project.multimodule.base.mazos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.poker.project.multimodule.base.cartas.Carta;
import com.poker.project.multimodule.base.cartas.Palo;

/**
 * Mazo peor.
 * bueno que una lista enlazada puede borrar en el medio sin reordenar las otras
 * pero el acceso indice no es constante
 * 
 * Lista enlazada, al borrar , quita del medio
 * @author victor
 *
 */
public class MazoOptListaEnlazadaOrdenada implements MazoCartas
{
	private LinkedList<Carta> mazo;
	
	private List<Carta> cartasUsadas;
	
	
	Random r= new Random(System.currentTimeMillis());


	
	public MazoOptListaEnlazadaOrdenada()
	{
		mazo = new LinkedList<>();
		cartasUsadas = new LinkedList<>();
		for(Palo p : Palo.values())
		{
			for(int i=1;i<14;i++)//cambiado
				mazo.add(new Carta(i,p));
		}
	
	}
	
	
	/**
	 * 
	 */
	public Carta dameCartaAleatoria()
	{
		int n= r.nextInt(mazo.size());
		Carta carta = mazo.remove(n);
		cartasUsadas.add(carta);
		return carta;
		
	}



	@Override
	public List<Carta> dameNCartasAleatoria(int n) 
	{
		
		 ArrayList<Carta> a = new  ArrayList<>();
		 for(int i=0;i<n;i++)
			 a.add(dameCartaAleatoria());
		
		 
		 return a;
	}



	@Override
	public void insertaCarta(Carta c)
	{
		mazo.add(c);
		
	}



	@Override
	public void insertaCartas(List<Carta> l)
	{
		mazo.addAll(l);
		/*
		for(Carta c: l)
			insertaCarta(c);
		*/
	}



	/**
	 * Coste n
	 * intentar coste log n - busqqueda binaria
	 */
	@Override
	public Carta dameCartaConcreta(Carta cartaConcreta)
	{		
		
		mazo.remove(cartaConcreta);
		return cartaConcreta;
		/*
		 * Palo palo = cartaConcreta.getPalo();
		int ord=palo.ordinal();
		
		
		Carta pivote= mazo.get(ord*10);// coste lineal
		
		
		Carta cartaBuscada= null;
		
		
		
		return cartaBuscada;
		*/
	}



	/**
	 * Suponer que las cartas existen 
	 */
	@Override
	public List<Carta> dameNCartasConcretas(List<Carta> cartasConcretas) {
		/*List<Carta> cartas= new ArrayList<>();
		for (Carta carta : cartasConcretas) {
			cartas.add(dameCartaConcreta(carta));
		}*/
		
		mazo.removeAll(cartasConcretas);

		
		
		return cartasConcretas;

	}



	
	



	@Override
	public boolean perteneceCartaAMazo(Carta c) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
