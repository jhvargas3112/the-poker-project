package com.poker.project.multimodule.base.util.ordenar.comp;

import java.util.Comparator;

import com.poker.project.multimodule.base.Carta;
import com.poker.project.multimodule.base.Palo;

/**
 * Compara cartas segun el palo
 * PERMITE IGUALES
 * @author victor
 *
 */
public class CompCartaPorColor implements Comparator<Carta> {

	@Override
	public int compare(Carta carta1, Carta carta2) 
	{
		Palo p1= carta1.getPalo();
		Palo p2= carta2.getPalo();

		
		
		int r= Character.compare(p1.letr(), p2.letr());
		
		return r;
	}

}
