package com.poker.project.multimodule.base.manos;

import java.util.ArrayList;
import java.util.List;

import com.poker.project.multimodule.base.Carta;
import com.poker.project.multimodule.base.constantes.ConstantesPR1;
import com.poker.project.multimodule.base.util.ordenar.OrdenarCartas;

/**
 * Mano Pareja
 * Una pareja esta formada por dos cartas iguales y 3 cartas diferentes
 * @author victor
 *
 */
public class Pareja extends Mano
{
	
	
	
	
	public Pareja(List<Carta> mano )
	{
		
			
			tipo=ManoEnum.pair;
			List<Carta> manoOrd =  (new OrdenarCartas()).ordenarPorIguales(mano);
			this.cartas=manoOrd;
			
		
	}

	@Override
	public ManoEnum dameTipo() {
		
		return ManoEnum.pair;
	}
	
	public String toString()
	{
		
		StringBuffer sb = new StringBuffer();
		sb.append(ConstantesPR1.PAREJA);
		sb.append(" of ");
		sb.append(cartas.get(0).dameNombre());
		sb.append("s");	//\n
		return sb.toString();
		
		
	}
	
	

}
