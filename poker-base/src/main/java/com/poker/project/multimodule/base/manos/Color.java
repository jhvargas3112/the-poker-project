package com.poker.project.multimodule.base.manos;

import java.util.ArrayList;
import java.util.List;

import com.poker.project.multimodule.base.Carta;
import com.poker.project.multimodule.base.constantes.ConstantesPR1;
import com.poker.project.multimodule.base.util.ordenar.OrdenarCartas;

/**
 * Mano Color
 * @author victor
 *
 */
public class Color extends CartaMasAlta {
	
	
	
	// Constructor de carta mas alta
	public Color(List<Carta> mano)
	{
		super(mano);
		tipo=ManoEnum.flush;
		/*ArrayList<Carta> manoOrd =  (new OrdenarCartas()).ordenarPorNumero(mano);
		this.cartas=manoOrd;
		*/
		
		
		
			
	}
	
	
	
	
	
	
	

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(ConstantesPR1.COLOR);
		//sb.append(" carta mas alta : ");
		//sb.append(cartas.get(0));
		
	
		return sb.toString();
	}
	
	
	
	
	
}
