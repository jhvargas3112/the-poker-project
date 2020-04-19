package com.poker.project.multimodule.base.util.ordenar;

import com.poker.project.multimodule.base.util.ordenar.comp.CompCartaPorColor;
import com.poker.project.multimodule.base.util.ordenar.comp.CompCartaPorNumero;

public class FactOrdenacion {

	
	public OrdenacionCartas  getOrdenacion(TipoOrdenar tipoOrdenar)
	{
		
		if(TipoOrdenar.NUMERO.equals(tipoOrdenar))
			return new OrdenacionComparador(new CompCartaPorNumero());
		else if(TipoOrdenar.PALO.equals(tipoOrdenar))
			return new OrdenacionComparador(new CompCartaPorColor());
		else
			return null;
	}
}
