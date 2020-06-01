package com.poker.project.multimodule.manos;

import static org.junit.Assert.*;

import org.junit.Test;

import com.poker.project.multimodule.base.manos.Mano;
import com.poker.project.multimodule.base.manos.NombreMano;
import com.poker.project.multimodule.base.manos.fact.FactoriaMano;

public class EscaleraColorTest
{
	FactTestManos factTestManos= new FactTestManos();
	FactoriaMano factoriaMano= new FactoriaMano();
	
	
	@Test
	public void creaEscaleraColor() throws Exception {
		Mano manoEscaleraColor = factoriaMano.creaMano(factTestManos.creaEscaleraColor(), NombreMano.straight_flush);
		
		
	}
	@Test
	public void escaleraColorVSEscaleraColorBaja() throws Exception {
		
	}

}
