package com.poker.project.multimodule.manos;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.poker.project.multimodule.base.manos.EscaleraColor;
import com.poker.project.multimodule.base.manos.Mano;
import com.poker.project.multimodule.base.manos.ManoEnum;
import com.poker.project.multimodule.base.manos.fact.FactoriaMano;

public class EscaleraColorTest
{
	FactTestManos factTestManos= new FactTestManos();
	FactoriaMano factoriaMano= new FactoriaMano();
	
	
	@Test
	public void creaEscaleraColor() throws Exception {
		Mano manoEscaleraColor = factoriaMano.creaMano(factTestManos.creaEscaleraColor(), ManoEnum.straight_flush);
		Assert.assertTrue(manoEscaleraColor instanceof EscaleraColor);
		
	}
	@Test
	public void escaleraColorVSEscaleraColorBaja() throws Exception {
		
	}

}
