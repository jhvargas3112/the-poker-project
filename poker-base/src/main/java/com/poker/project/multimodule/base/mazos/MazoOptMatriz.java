package com.poker.project.multimodule.base.mazos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.poker.project.multimodule.base.cartas.Carta;
import com.poker.project.multimodule.base.cartas.Palo;
import com.poker.project.multimodule.base.mazos.exceptions.CardIsAlreadySelectedException;
import com.poker.project.multimodule.base.mazos.exceptions.CardIsInTheDeckException;

/**
 * matriz de cartas 
 * acceso constante
 * al pedir aleatoria, necesita 2 aleatorios
 * coste en espacio N*M
 * 
 * conteo , constante
 * saber si existe una carta, acceso constante
 * 
 * @author victor
 *
 */
public class MazoOptMatriz implements MazoCartas
{
	private Carta mazo[][];
	private boolean seleccionada[][];
	private int numCartasNoSeleccionadas;
	
	private static final  int NUM_PALOS=  Palo.values().length;
	private static final  int NUM_CARTAS= 13;
	
	public MazoOptMatriz()
	{
		mazo =  new Carta[NUM_PALOS][NUM_CARTAS];
		seleccionada= new boolean[NUM_PALOS][NUM_CARTAS];
		numCartasNoSeleccionadas = NUM_PALOS*NUM_CARTAS;
		for(Palo p : Palo.values())
		{
			for(int i=0;i<NUM_CARTAS;i++)//cambiado
				mazo[p.ordinal()][i]= new Carta(i+1,p);
		}
	}
	
	
	
	
	/**
	 * Extrae una carta del mazo
	 * 2 aleatoriios y lugo acceso constante
	 * @return carta aleatoria
	 */
	public Carta dameCartaAleatoria()
	{
		if(numCartasNoSeleccionadas==0){
			return null;
		}else{
		
			Random r = new Random(System.currentTimeMillis());
					
			int nPalo = r.nextInt(NUM_PALOS);
			int nCarta = r.nextInt(NUM_CARTAS);
			
			Palo p =  Palo.values()[nPalo];
			Carta c = new Carta(nCarta+1,p);
			
			while(estaSeleccionada(c))
			{
				nPalo = r.nextInt(NUM_PALOS);
				nCarta = r.nextInt(NUM_CARTAS);
				
				p =  Palo.values()[nPalo];
				c = new Carta(nCarta+1,p);
			}
			
			numCartasNoSeleccionadas--;
			
			try {
				seleccionarCarta(c);
			} catch (CardIsAlreadySelectedException e) {
				e.printStackTrace();
			}
			return c;
		}
		
	}
	
	
	
	
	/**
	 * Extrae n cartas del mazo
	 * @return cartas aleatorias
	 */
	public List<Carta> dameNCartasAleatoria(int n)
	{
		 ArrayList<Carta> a = new  ArrayList<>();
		 for(int i=0;i<n;i++)
			 a.add(dameCartaAleatoria());
		
		 
		 return a;
	}

	/**
	 * Coste en tiempo O(1).
	 */
	@Override
	public void insertarCarta(Carta carta) throws CardIsInTheDeckException {
		if (!estaSeleccionada(carta)) {
			throw new CardIsInTheDeckException("This card is already in the deck.");
		}
		
		int paloOrdinal = carta.getPaloOrdinal();
		int numero = carta.getNum();
		
		seleccionada[paloOrdinal][numero] = false;
		
		numCartasNoSeleccionadas++;
	}

	/**
	 * Coste en tiempo O(n).
	 */
	@Override
	public void insertarCartas(List<Carta> cartas) {
		for(Carta carta: cartas)
			try {
				insertarCarta(carta);
			} catch (CardIsInTheDeckException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * Devuelve si hay cartas en el mazo
	 * Coste constante
	 * @return
	 */
	public boolean estaVacio()
	{
		return numCartasNoSeleccionadas==0;//mazo.isEmpty();
	}
	
	
	/**
	 * Coste constante
	 * @return
	 */
	public int quedanNumCartas()
	{
		return numCartasNoSeleccionadas;
	}
	
	/**
	 * Coste en tiempo O(1).
	 */
	public void seleccionarCarta(Carta carta) throws CardIsAlreadySelectedException {
		if (carta == null) {
			return;
		}
		
		int numero = carta.getNum();
		int paloOrdinal = carta.getPaloOrdinal();
		
		if (!estaSeleccionada(carta)) {
			seleccionada[paloOrdinal][numero] = true;
			numCartasNoSeleccionadas--;
		} else {
			throw new CardIsAlreadySelectedException("This card is already selected.");
		}
	}
	
	/**
	 * Coste en tiempo O(1).
	 */
	public boolean estaSeleccionada(Carta carta) {
		int numero = carta.getNum();
		int paloOrdinal = carta.getPaloOrdinal();
		
		boolean estaSeleccionada = this.seleccionada[paloOrdinal][numero];
		
		return estaSeleccionada;
	}

	/**
	 * Coste en tiempo O(1).
	 */
	@Override
	public Carta dameCartaConcreta(Carta cartaConcreta) {
		if(cartaConcreta == null) {
			return null;
		}
		
		if (estaSeleccionada(cartaConcreta)) {
			cartaConcreta = null;
		} else {
			try {
				seleccionarCarta(cartaConcreta);
			} catch (CardIsAlreadySelectedException e) {
				e.printStackTrace();
			}
		}
		
		return cartaConcreta;
	}
	
	@Override
	/**
	 * Coste lineal
	 */
	public List<Carta> dameNCartasConcretas(List<Carta> cartasConcretas) {
		
		List<Carta> cartas= new ArrayList<>();
		for (Carta carta : cartasConcretas) {
			cartas.add(dameCartaConcreta(carta));
		}
		return cartas;
	}
	
	/**
	 * Coste en tiempo O(1).
	 */
	public int getNumCartasNoSeleccionadas()
	{
		return numCartasNoSeleccionadas;
	}
}
