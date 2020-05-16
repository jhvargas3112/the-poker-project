package com.poker.project.multimodule.base.mazos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.poker.project.multimodule.base.cartas.Carta;
import com.poker.project.multimodule.base.cartas.Palo;
import com.poker.project.multimodule.base.mazos.exceptions.EmptyCardDeckException;

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
			} catch (EmptyCardDeckException e) {
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
	public void insertaCarta(Carta carta) {
		int p = carta.getPaloOrdinal();
		int n = carta.getNum();
		
		seleccionada[p][n] = false;
		
		numCartasNoSeleccionadas++;
	}

	/**
	 * coste lineal
	 */
	@Override
	public void insertaCartas(List<Carta> l) {

		for(Carta c: l)
			insertaCarta(c);
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
	 * Comprueba si una determinada carta está en el mazo.
	 * 
	 * @param Carta carta
	 * @return boolean - true si la carta está en el mazo, false si no.
	 */
	public boolean perteneceCartaAMazo(Carta c) {
		return !estaSeleccionada(c);
	}
	
	/**
	 * Coste en tiempo O(1).
	 */
	public void seleccionarCarta(Carta carta) throws EmptyCardDeckException {
		if (estaVacio()) {
			throw new EmptyCardDeckException("Card deck is empty.");
		}
		
		if (carta == null) {
			return;
		}
		
		int numero = carta.getNum();
		int paloOrdinal = carta.getPaloOrdinal();
		
		if (!estaSeleccionada(carta)) {
			seleccionada[paloOrdinal][numero] = true;
			numCartasNoSeleccionadas--;
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
		
		int numero = cartaConcreta.getNum();
		int paloOrdinal = cartaConcreta.getPaloOrdinal();
		
		boolean estaSeleccionada = false;
		
		try {
			estaSeleccionada = this.seleccionada[paloOrdinal][numero];
			
		} catch(Exception e) {
			System.err.println("Mazo. Está seleccionada " + cartaConcreta + " " + numero + " " + paloOrdinal);
			
			System.exit(-1);
		}
		
		return !estaSeleccionada ? mazo[paloOrdinal][numero] : null;
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
