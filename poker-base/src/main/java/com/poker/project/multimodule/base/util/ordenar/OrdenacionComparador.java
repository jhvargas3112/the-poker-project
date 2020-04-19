package com.poker.project.multimodule.base.util.ordenar;

import java.util.Comparator;
import java.util.List;

import com.poker.project.multimodule.base.Carta;
import com.poker.project.multimodule.base.util.ordenar.comp.CompCartaPorNumero;

public class OrdenacionComparador implements OrdenacionCartas
{

	Comparator<Carta> comp;
	
	
	
	public OrdenacionComparador(Comparator<Carta> comp) {
		super();
		this.comp = comp;
	}



	@Override
	public List<Carta> ordenarCartas(List<Carta> cartas) {
		cartas.sort(comp);
		return cartas;
	}
	
	

}
