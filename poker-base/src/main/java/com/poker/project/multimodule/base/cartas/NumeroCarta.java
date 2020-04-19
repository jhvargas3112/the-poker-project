package com.poker.project.multimodule.base.cartas;

/**
 * Alternativa, poner enumerado al numero de la carta
 * @author victor
 *
 */
public enum NumeroCarta 
{
	
	
	AS(1,"A"),
	DOS(2,"2"),
	TRES(3,"3"),
	CUATRO(4,"4"),
	CINCO(5,"5"),
	SEIS(6,"6"),
	SIETE(7,"7"),
	OCHO(8,"8"),
	NUEVE(9,"9"),
	DIEZ(10,"10"),
	JACK(11,"J"),
	QUEEN(12,"Q"),
	KING(13,"K");
	
	int valor;
	String letra;
	
	private NumeroCarta(int valor,String letra) {
		this.valor = valor;
		this.letra=letra;
	}
	
	

}
