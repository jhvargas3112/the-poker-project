package com.poker.project.multimodule.base.manos;

import java.util.ArrayList;
import java.util.List;

import com.poker.project.multimodule.base.Carta;
import com.poker.project.multimodule.base.constantes.ConstantesPR1;
import com.poker.project.multimodule.base.util.ordenar.OrdenarCartas;

/**
 * Mano Dobles parejas
 * @author victor
 *
 */
public class DoblesParejas extends Mano
{
	
	private Carta parejaMayor;
	private Carta parejaMenor;
	private Carta desparejada;
	
	public DoblesParejas(List<Carta> mano)
	{
		
		tipo=ManoEnum.two_pair;
		List<Carta> manoOrd =  (new OrdenarCartas()).ordenarPorIguales(mano);
		parejaMayor= manoOrd.get(0);
		parejaMenor= manoOrd.get(2);
		desparejada= manoOrd.get(4);

		if(parejaMayor.compareTo(parejaMenor)==-1)
		{
			Carta cartaAux= parejaMayor;
			parejaMayor=parejaMenor;
			parejaMenor=cartaAux;
		}
		this.cartas=manoOrd;
			
			
	}
	@Override
	public int compareTo(Mano m2)
	{
		int r= super.compareTo(m2);
		if(r!=0)return r;
		
		DoblesParejas dp= (DoblesParejas) m2;
		 r=parejaMayor.compareTo(dp.parejaMayor);
		 
		 if(r!=0)return r;
		 r=parejaMenor.compareTo(dp.parejaMenor);
		 
		 if(r!=0)return r;
		 r=desparejada.compareTo(dp.desparejada);
		 
		 return r;
		
		
		
	}
		
	public String toString()
	{
		
		/*Carta c1 = cartas.get(0);
		Carta c2 = cartas.get(2);
		*/
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(ConstantesPR1.DOBLES_PAREJAS);
		sb.append(" of ");
		sb.append(parejaMayor.dameNombre());
		sb.append("s and ");
		sb.append(parejaMenor.dameNombre());
		sb.append("s");	//\n
		
	
		return sb.toString();
	}
	
	
	
}
