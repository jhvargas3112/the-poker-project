package com.poker.project.multimodule;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.poker.project.multimodule.base.cartas.Carta;
import com.poker.project.multimodule.base.cartas.Palo;
import com.poker.project.multimodule.base.mazos.MazoCartas;
import com.poker.project.multimodule.base.mazos.MazoOptMatriz;
import com.poker.project.multimodule.base.mazos.exceptions.EmptyCardDeckException;

public class MazoTest 
{
	private MazoCartas mazo;
	
	private static final  int NUM_PALOS = Palo.values().length;
	private static final  int NUM_CARTAS = 13;
	
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
	
	@Test
	public void seleccionarCarta() {
		Carta carta = new Carta(7, Palo.CORAZONES);
		
		int numCartasNoSeleccionadas = ((MazoOptMatriz) mazo).getNumCartasNoSeleccionadas();
		
		try {
			((MazoOptMatriz) mazo).seleccionarCarta(carta);
		} catch (EmptyCardDeckException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(((MazoOptMatriz) mazo).getNumCartasNoSeleccionadas(), numCartasNoSeleccionadas - 1);
	}
	
	@Test(expected = EmptyCardDeckException.class)
	public void seleccionarCartaMazoVacio() throws EmptyCardDeckException {
		((MazoOptMatriz) mazo).dameNCartasAleatoria(NUM_PALOS * NUM_CARTAS);
		
		((MazoOptMatriz) mazo).seleccionarCarta(new Carta(7, Palo.CORAZONES));
	}
	
	@Test
	public void noPerteneceCartaAMazo() {
		Carta carta = new Carta(7, Palo.CORAZONES);
		
		try {
			((MazoOptMatriz) mazo).seleccionarCarta(carta);
		} catch (EmptyCardDeckException e) {
			e.printStackTrace();
		}
		
		boolean pertenece = mazo.perteneceCartaAMazo(carta);
		
		Assert.assertFalse(pertenece);
	}
	
	@Test
	public void perteneceCartaAMazo() {
		Carta carta = new Carta(7, Palo.CORAZONES);
		
		boolean pertenece = mazo.perteneceCartaAMazo(carta);
		
		Assert.assertTrue(pertenece);
	}
	
	@Test
	public void insertarCarta() {
		mazo= new MazoOptMatriz();
		
		((MazoOptMatriz) mazo).dameNCartasAleatoria(8);
		
		int numCartasSinSeleccionar = ((MazoOptMatriz) mazo).getNumCartasNoSeleccionadas();
		
		Carta carta = new Carta(7, Palo.CORAZONES);
		
		mazo.insertaCarta(carta);
		
		Assert.assertEquals(numCartasSinSeleccionar + 1, ((MazoOptMatriz) mazo).getNumCartasNoSeleccionadas());
	}
}
