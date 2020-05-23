package com.poker.project.multimodule.base.manos;

import java.util.ArrayList;
import java.util.List;

import com.poker.project.multimodule.base.Carta;
import com.poker.project.multimodule.base.constantes.ConstantesPR1;
import com.poker.project.multimodule.base.util.ordenar.OrdenarCartas;

/**
 * Mano Full
 * @author victor
 *
 */
public class Full extends Mano
{
	
	
	public Full(List<Carta> mano )
	{
		
			
			tipo=ManoEnum.full_house;
			List<Carta> manoOrd =  (new OrdenarCartas()).ordenarPorIguales(mano);
			this.cartas=manoOrd;
			
		
	}
	
	
	public String toString()
	{
		
		StringBuffer sb = new StringBuffer();
		sb.append(ConstantesPR1.FULL);
		sb.append(" of ");
		sb.append(cartas.get(0).dameNombre());
		sb.append("s and ");
		sb.append(cartas.get(3).dameNombre());
		sb.append("s");	//\n
		
	
		return sb.toString();
	}

	
	
	
}
