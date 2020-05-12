package com.poker.project.multimodule.base.mazos.fact;

import com.poker.project.multimodule.base.mazos.MazoCartas;
import com.poker.project.multimodule.base.mazos.MazoOptMatriz;

/**
 * Se elige mazo pt matriz como el mejor.
 * @author victor
 *
 */
public class FactMazo
{
	
	public MazoCartas dameMazo()
	{
		return new MazoOptMatriz();
	}

}
