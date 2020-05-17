package com.poker.project.multimodule.base.mazos;

import java.util.List;

import com.poker.project.multimodule.base.cartas.Carta;
import com.poker.project.multimodule.base.mazos.exceptions.CardIsInTheDeckException;

/**
 * Mazo de cartas que permite extraer cartas aleatorias y concretas
 * Sabiendo si una carta pertenece al mazo
 * 
 * @author victor
 *
 */
public interface MazoCartas 
{
	/**
	 * Devuelve una carta aleatoria
	 * @return
	 */
	public Carta dameCartaAleatoria();
	
	/**
	 * Devuelve n cartas aleatoria
	 * @return
	 */
	public List<Carta> dameNCartasAleatoria(int n);
	
	/**
	 * Devuelve una carta concreta
	 * @return
	 */
	public Carta dameCartaConcreta(Carta cartaConcreta);
	
	/**
	 * Devuelve varias carta concreta
	 * @return
	 */
	public List<Carta> dameNCartasConcretas(List<Carta> cartasConcretas);
	
	
	/**
	 * Mete una carta concreta en el mazo
	 * @return
	 * @throws CardIsInTheDeckException when the given card is already in the deck.
	 */
	public void insertarCarta(Carta carta) throws CardIsInTheDeckException;
	
	

	/**
	 * Mete varias carta concreta en el mazo
	 * @return
	 */
	
	public void insertarCartas(List<Carta> cartas);
	
	public boolean estaSeleccionada(Carta carta);
}
