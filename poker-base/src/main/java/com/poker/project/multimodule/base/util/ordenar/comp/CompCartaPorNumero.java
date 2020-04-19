package com.poker.project.multimodule.base.util.ordenar.comp;

import java.util.Comparator;

import com.poker.project.multimodule.base.Carta;

/**
 * Compara cartas segun el valor
 * @author victor
 *
 */
public class CompCartaPorNumero implements Comparator<Carta> {

	@Override
	public int compare(Carta carta1, Carta carta2) 
	{
		int n1=carta1.getNum();
		int n2=carta2.getNum();
		if(n1==1)n1 = 15;
		if(n2==1)n2 = 15;
		
		int r= Integer.compare(n1, n2);
		if(r==0)r=0;//tienen el mismo valor
		
		return r;
	}

}
