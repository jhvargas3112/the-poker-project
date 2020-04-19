 package com.poker.project.multimodule.base.manos;

import java.util.ArrayList;

import com.poker.project.multimodule.base.Carta;
import com.poker.project.multimodule.base.constantes.ConstantesPR1;
import com.poker.project.multimodule.base.util.ordenar.OrdenarCartas;

/**
 * Mano Carta mas alta
 * @author victor
 *
 */
public class CartaMasAlta extends Mano  implements Comparable<Mano>
{
	
	
	
	
	
	
	// Constructor de carta mas alta
	public CartaMasAlta(ArrayList<Carta> mano)//,ManoEnum me
	{
		
		tipo=ManoEnum.high_card;
		ArrayList<Carta> manoOrd =  (new OrdenarCartas()).ordenarPorNumero(mano);
		cartas=manoOrd;
			
	}
	
	
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(ConstantesPR1.CARTA_MAS_ALTA);
                sb.append(" ");
		//sb.append(" carta mas alta : ");
		sb.append(cartas.get(0).dameNombre());
			
		return sb.toString();
	}
	
}
