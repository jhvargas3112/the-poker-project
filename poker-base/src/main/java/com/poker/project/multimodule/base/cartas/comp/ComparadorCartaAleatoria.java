package com.poker.project.multimodule.base.cartas.comp;

import java.util.Comparator;

import com.poker.project.multimodule.base.cartas.Carta;

public class ComparadorCartaAleatoria implements Comparator<Carta>
{

	@Override
	public int compare(Carta o1, Carta o2)
	{
		int r=o1.getPalo().compareTo(o2.getPalo());
		
		if(r==0)
			r= o1.compareTo(o2);
		
		return r;
	}

	
}
