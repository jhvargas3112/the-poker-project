package com.poker.project.multimodule.manos;

import com.poker.project.multimodule.base.manos.Color;
import com.poker.project.multimodule.base.manos.DoblesParejas;
import com.poker.project.multimodule.base.manos.Escalera;
import com.poker.project.multimodule.base.manos.EscaleraColor;
import com.poker.project.multimodule.base.manos.ManoEnum;
import com.poker.project.multimodule.base.manos.Pareja;
import com.poker.project.multimodule.base.manos.Trio;
import com.poker.project.multimodule.base.manos.fact.FactoriaMano;

public class FactTestManosCreadas
{
	FactTestManos factTestManos= new FactTestManos();
	FactoriaMano factManos= new FactoriaMano();
	
	public Pareja creaPareja()
	{
		return (Pareja) factManos.creaMano(factTestManos.creaPareja(), ManoEnum.pair);
	}
	
	public DoblesParejas creaDoblesParejas()
	{
		return (DoblesParejas) factManos.creaMano(factTestManos.creaDoblesPareja(), ManoEnum.two_pair);
	}
	
	public DoblesParejas creaDoblesParejasBajas()
	{
		return (DoblesParejas) factManos.creaMano(factTestManos.creaDoblesParejaBajas(), ManoEnum.two_pair);
	}
	
	public Trio creaTrio()
	{
		return (Trio) factManos.creaMano(factTestManos.creaTrio(), ManoEnum.three_of_a_kind);
	}
	
	public Escalera creaEscalera()
	{
		return (Escalera) factManos.creaMano(factTestManos.creaEscalera(), ManoEnum.straight);
	}
	
	public Escalera creaEscaleraBaja()
	{
		return (Escalera) factManos.creaMano(factTestManos.creaEscaleraBaja(), ManoEnum.straight);
	}
	
	public Color creaColor()
	{
		return (Color) factManos.creaMano(factTestManos.creaColor(), ManoEnum.flush);
	}
	
	public Color creaColorBaja()
	{
		return (Color) factManos.creaMano(factTestManos.creaColorBajo(), ManoEnum.flush);
	}
	
	public EscaleraColor creaEscaleraColor()
	{
		return (EscaleraColor) factManos.creaMano(factTestManos.creaEscaleraColor(), ManoEnum.straight_flush);
	}
	
	public EscaleraColor creaEscaleraColorBaja()
	{
		return (EscaleraColor) factManos.creaMano(factTestManos.creaEscaleraColorBaja(), ManoEnum.straight_flush);
	}


}
