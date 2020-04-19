package com.poker.project.multimodule.base.manos;

import java.util.ArrayList;

import com.poker.project.multimodule.base.Carta;
import com.poker.project.multimodule.base.constantes.ConstantesPR1;
import com.poker.project.multimodule.base.util.ordenar.OrdenarCartas;

/**
 * Mano Escalera
 * @author victor
 *
 */
public class Escalera extends Mano
{
	
	
	public Escalera(ArrayList<Carta> mano )
	{
			
			tipo=ManoEnum.straight;
			//cartas =  (new OrdenarCartas()).ordenarPorNumeroAscendente(mano);
                        cartas =  (new OrdenarCartas()).ordenarPorNumero(mano);
                        
                         // si la escalera contiene un as, pero su carta mas baja es un 2, poner el as como ultima 
			if(cartas.get(4).getNum()==2 && cartas.get(0).getNum()==1)
			{
				Carta as = cartas.get(0);
				cartas.add(5,as);
				cartas.remove(0);
			}
	
	}

	
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(ConstantesPR1.ESCALERA);
		
		/*sb.append(" desde ");
		sb.append(cartas.get(0).dameNombre());
		sb.append(" hasta ");
		sb.append(cartas.get(4).dameNombre());
		*/
	
		return sb.toString();
	}
	
	
	
}
