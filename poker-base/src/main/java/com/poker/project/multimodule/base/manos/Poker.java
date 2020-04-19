package com.poker.project.multimodule.base.manos;

import java.util.ArrayList;

import com.poker.project.multimodule.base.Carta;
import com.poker.project.multimodule.base.constantes.ConstantesPR1;
import com.poker.project.multimodule.base.util.ordenar.OrdenarCartas;

/**
 * Mano Poker
 * @author victor
 *
 */
public class Poker 
extends Mano{

	private int kind;
	
	
	
		public Poker(ArrayList<Carta> mano )
		{
			
				
				tipo=ManoEnum.four_of_a_kind;
				ArrayList<Carta> manoOrd =  (new OrdenarCartas()).ordenarPorIguales(mano);
				this.cartas=manoOrd;
				kind=cartas.get(0).getNum();
				
			
		}
	/*	 po que?
	@Override
	public ManoEnum dameTipo() {
		// TODO Auto-generated method stub
		return ManoEnum.four_of_a_kind;
	}*/
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(ConstantesPR1.POKER);
		sb.append(" of ");
		sb.append(kind);
		sb.append("s");	//\n	
		return sb.toString();
		
		
	}

	

}
