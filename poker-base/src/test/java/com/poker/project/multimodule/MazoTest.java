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
import com.poker.project.multimodule.base.mazos.exceptions.CardIsAlreadySelectedException;
import com.poker.project.multimodule.base.mazos.exceptions.CardIsInTheDeckException;

public class MazoTest 
{
	private MazoCartas mazo;
	
	private static final  int NUM_PALOS = Palo.values().length;
	private static final  int NUM_CARTAS = 13;
	
	private ArrayList<Carta> cartas;
	
	@Before
	public void setUp() 
	{
		mazo= new MazoOptMatriz();
		
		cartas = new ArrayList<>();
		
		cartas.add(new Carta(7, Palo.CORAZONES));
		cartas.add(new Carta(3, Palo.PICAS));
		cartas.add(new Carta(5, Palo.DIAMANTES));
		cartas.add(new Carta(8, Palo.TREBOLES));
	}
	
	
	
	@Test
	public void testDameCartaAleatoria() throws Exception 
	{
		Carta carta=mazo.dameCartaAleatoria();
		
		Assert.assertNotNull(carta);
	
		
	}
	
	
	@Test
	public void testDameNCartaAleatoria() throws Exception // FIXME: mejorar este test, creo que no el método dameNCartasAleatoria no funciona bien si se piden que te de 52 cartas aleatorias.
	{
		int n=2;
		List<Carta> cartas = mazo.dameNCartasAleatoria(n);
		
		Assert.assertNotNull(cartas);
		
		Assert.assertTrue(!cartas.isEmpty());
		
		n = NUM_PALOS * NUM_CARTAS;
				
		Assert.assertTrue(((MazoOptMatriz)mazo).estaVacio());
	}
	
	
	@Test
	public void testDameCartaConcreta() 
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
		} catch (CardIsAlreadySelectedException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(((MazoOptMatriz) mazo).getNumCartasNoSeleccionadas(), numCartasNoSeleccionadas - 1);
	}
	
	@Test(expected = CardIsAlreadySelectedException.class)
	public void seleccionarCartaMazoVacio() throws CardIsAlreadySelectedException {
		((MazoOptMatriz) mazo).dameNCartasAleatoria(NUM_PALOS * NUM_CARTAS);
		
		((MazoOptMatriz) mazo).seleccionarCarta(new Carta(7, Palo.CORAZONES));
	}
	
	@Test
	public void noPerteneceCartaAMazo() {
		Carta carta = new Carta(7, Palo.CORAZONES);
		
		try {
			((MazoOptMatriz) mazo).seleccionarCarta(carta);
		} catch (CardIsAlreadySelectedException e) {
			e.printStackTrace();
		}
		
		boolean pertenece = !mazo.estaSeleccionada(carta);
		
		Assert.assertFalse(pertenece);
	}
	
	@Test
	public void perteneceCartaAMazo() {
		Carta carta = new Carta(7, Palo.CORAZONES);
		
		boolean pertenece = !mazo.estaSeleccionada(carta);
		
		Assert.assertTrue(pertenece);
	}
	
	@Test
	public void insertarCarta() throws CardIsInTheDeckException {
		((MazoOptMatriz) mazo).dameNCartasConcretas(cartas);
		
		int numCartasSinSeleccionar = ((MazoOptMatriz) mazo).getNumCartasNoSeleccionadas();
		
		Carta carta = new Carta(7, Palo.CORAZONES);
		
		mazo.insertarCarta(carta);
		
		Assert.assertEquals(numCartasSinSeleccionar + 1, ((MazoOptMatriz) mazo).getNumCartasNoSeleccionadas());
	}
	
	@Test
	public void insertarNCartas() throws CardIsInTheDeckException {
		((MazoOptMatriz) mazo).dameNCartasConcretas(cartas);
		
		int numCartasSinSeleccionar = ((MazoOptMatriz) mazo).getNumCartasNoSeleccionadas();
		
		mazo.insertarCartas(cartas);
		
		Assert.assertEquals(numCartasSinSeleccionar + 4, ((MazoOptMatriz) mazo).getNumCartasNoSeleccionadas());
	}
	
	@Test(expected = CardIsInTheDeckException.class)
	public void insertarCartaRepetida() throws CardIsInTheDeckException {
		Carta carta = new Carta(7, Palo.CORAZONES);
		
		mazo.insertarCarta(carta);
	}
}
