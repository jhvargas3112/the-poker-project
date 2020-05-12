package com.poker.project.multimodule;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.poker.project.multimodule.base.cartas.Carta;
import com.poker.project.multimodule.base.mazos.MazoCartas;
import com.poker.project.multimodule.base.mazos.MazoOptMatriz;

public class MazoTest 
{
	MazoCartas mazo;
	
	@Before
	public void setUp() 
	{
		mazo= new MazoOptMatriz();
	}
	
	
	
	@Test
	public void testDameCartaAleatoria() throws Exception 
	{
		Carta carta=mazo.dameCartaAleatoria();
		
		Assert.assertNotNull(carta);
	
		
	}
	
	

}
