package com.poker.project.multimodule.base.mazos;

import java.util.ArrayList;
import java.util.List;

import com.poker.project.multimodule.base.cartas.Carta;

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
	 */
	public void insertaCarta(Carta c);
	
	

	/**
	 * Mete varias carta concreta en el mazo
	 * @return
	 */
	
	public void insertaCarta(List<Carta> l);
	
	
	public void seleccionarCarta(Carta c );
	/**
	 * es usada
	 * @param c
	 * @return
	 */
	public boolean estaSeleccionada(Carta c);
	
	public boolean estaCarta(Carta c);
	/*
	public boolean quitarCarta(Carta c);
	public boolean quitarNCarta(Carta c);
	*/
	
	
	
	
	
	
	
	

}
