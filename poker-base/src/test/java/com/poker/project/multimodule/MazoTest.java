package com.poker.project.multimodule;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.poker.project.multimodule.base.cartas.Carta;
import com.poker.project.multimodule.base.cartas.Palo;
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
	
	
	@Test
	public void testDameNCartaAleatoria() throws Exception 
	{
		int n=2;
		List<Carta> cartas = mazo.dameNCartasAleatoria(n);
		
		Assert.assertNotNull(cartas);
		
		Assert.assertTrue(!cartas.isEmpty());

	
		
	}
	
	
	@Test
	public void testDameCartaConcreta() throws Exception 
	{
		Carta cartaConcreta= new Carta(2,Palo.CORAZONES);
		Carta carta=mazo.dameCartaConcreta(cartaConcreta);
		
		Assert.assertNotNull(carta);
	
		
		Assert.assertTrue(carta.compareTo(cartaConcreta)==0);
		
	}
	
	
	@Test
	public void testDameNCartasConcretas() throws Exception 
	{
		int n=2;
		Carta cartaConcreta1= new Carta(1,Palo.CORAZONES);

		Carta cartaConcreta2= new Carta(2,Palo.CORAZONES);

		List<Carta> cartasConcretas= new ArrayList<>();
		
		cartasConcretas.add(cartaConcreta1);
		cartasConcretas.add(cartaConcreta2);

		
		List<Carta> cartas = mazo.dameNCartasConcretas(cartasConcretas);
		
		Assert.assertNotNull(cartas);
		
		Assert.assertTrue(!cartas.isEmpty());

		Assert.assertTrue(cartas.size()==cartasConcretas.size());
		
		for (int i = 0; i < cartas.size(); i++)
		{
			
			Carta carta= cartas.get(i);
			Carta cartaConcreta= cartasConcretas.get(i);
			Assert.assertTrue(carta.compareTo(cartaConcreta)==0);

		}

	}
	

}
