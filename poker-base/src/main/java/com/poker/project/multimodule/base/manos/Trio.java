package com.poker.project.multimodule.base.manos;

import java.util.ArrayList;
import java.util.List;

import com.poker.project.multimodule.base.Carta;
import com.poker.project.multimodule.base.constantes.ConstantesPR1;
import com.poker.project.multimodule.base.util.ordenar.OrdenarCartas;

/**
 * Mano Trio
 * @author victor
 *
 */
public class Trio extends Mano 
{

	
	
		public Trio(List<Carta> mano )
		{
			
				
				tipo=ManoEnum.three_of_a_kind;
				ArrayList<Carta> manoOrd =  (new OrdenarCartas()).ordenarPorIguales(mano);
				this.cartas=manoOrd;
				
				
			
		}
		
	
	public String toString()
	{
				
		StringBuffer sb = new StringBuffer();
		sb.append(ConstantesPR1.TRIO);
		sb.append(" of ");
		sb.append(cartas.get(0).dameNombre());
		sb.append("s");	//\n
		return sb.toString();
	}
	
	
	
	
}
