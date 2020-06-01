package com.poker.project.multimodule.base.manos;

import java.util.ArrayList;
import java.util.List;

import com.poker.project.multimodule.base.Carta;
import com.poker.project.multimodule.base.constantes.ConstantesPR1;
import com.poker.project.multimodule.base.util.ordenar.OrdenarCartas;

/**
 * Mano Carta mas alta
 * 
 * @author victor
 *
 */
public class ManoSegunCompararTodas extends Mano implements Comparable<Mano> {

	/** Constructor de carta mas alta
	 * 
	 * @param mano
	 */
	public ManoSegunCompararTodas(List<Carta> mano)// ,ManoEnum me
	{

		//tipo = ManoEnum.high_card;
		List<Carta> manoOrd = (new OrdenarCartas()).ordenarPorNumero(mano);
		cartas = manoOrd;

	}

	@Override
	public int compareTo(Mano m2) {
		int r = super.compareTo(m2);
		if (r != 0)
			return r;
		int i = 0;

		while (r == 0 && i < cartas.size()) 
		{
			r = cartas.get(i).compareTo(m2.cartas.get(i));
			i++;
		}
		
		return r;
	}

	/*
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ConstantesPR1.CARTA_MAS_ALTA);
		sb.append(" ");
		// sb.append(" carta mas alta : ");
		sb.append(cartas.get(0).dameNombre());

		return sb.toString();
	}*/

}
