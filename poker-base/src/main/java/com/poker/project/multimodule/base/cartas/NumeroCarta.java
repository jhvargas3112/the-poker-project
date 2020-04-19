package com.poker.project.multimodule.base.cartas;

/**
 * Alternativa, poner enumerado al numero de la carta
 * @author victor
 *
 */
public enum NumeroCarta 
{
	
	
	AS(1),
	DOS(2),
	TRES(3),
	CUATRO(4),
	CINCO(5),
	SEIS(6),
	SIETE(7),
	OCHO(8),
	NUEVE(9),
	DIEZ(10),
	JACK(11),
	QUEEN(12),
	KING(13);
	
	int valor;

	private NumeroCarta(int valor) {
		this.valor = valor;
	}
	
	

}
