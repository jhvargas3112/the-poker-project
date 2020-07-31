package com.poker.project.multimodule.manos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.poker.project.multimodule.base.Carta;
import com.poker.project.multimodule.base.Palo;
import com.poker.project.multimodule.base.manos.Color;
import com.poker.project.multimodule.base.manos.DoblesParejas;

public class DoblesParejasTest
{

	
	
	
	@Test
	public void testColor1Carta() throws Exception
	{
		
		
		
		List<Carta> cartas= new ArrayList<>();
		List<Carta> cartas2= new ArrayList<>();

		List<Carta> cartasBase1= new ArrayList<>();
		List<Carta> cartasBase2= new ArrayList<>();
		
		cartasBase1.add(new Carta(10,Palo.CORAZONES));
		cartasBase1.add(new Carta(10,Palo.PICAS));
		cartasBase1.add(new Carta(7,Palo.CORAZONES));
		cartasBase1.add(new Carta(7,Palo.TREBOLES));
		cartasBase1.add(new Carta(5,Palo.DIAMANTES));
		
		
		cartasBase2.add(new Carta(9,Palo.CORAZONES));
		cartasBase2.add(new Carta(9,Palo.PICAS));
		cartasBase2.add(new Carta(6,Palo.CORAZONES));
		cartasBase2.add(new Carta(6,Palo.TREBOLES));
		cartasBase2.add(new Carta(4,Palo.DIAMANTES));
		
		
		

		List<Carta> cartasMismasParejasExceptoUltima= new ArrayList<>();
		cartasMismasParejasExceptoUltima.add(cartasBase1.get(0));
		cartasMismasParejasExceptoUltima.add(cartasBase1.get(1));
		cartasMismasParejasExceptoUltima.add(cartasBase1.get(2));
		cartasMismasParejasExceptoUltima.add(cartasBase1.get(3));

		cartasMismasParejasExceptoUltima.add(cartasBase2.get(4));

		
		List<Carta> cartasDobleParejasAlta= new ArrayList<>();
		cartasDobleParejasAlta.add(cartasBase1.get(0));
		cartasDobleParejasAlta.add(cartasBase1.get(1));
		
		cartasDobleParejasAlta.add(cartasBase2.get(2));
		cartasDobleParejasAlta.add(cartasBase2.get(3));

		cartasDobleParejasAlta.add(cartasBase2.get(4));


		List<Carta> cartasDobleParejasBaja= new ArrayList<>();
		cartasDobleParejasBaja.add(cartasBase2.get(0));
		cartasDobleParejasBaja.add(cartasBase2.get(1));
		
		cartasDobleParejasBaja.add(cartasBase1.get(2));
		cartasDobleParejasBaja.add(cartasBase1.get(3));

		cartasDobleParejasBaja.add(cartasBase2.get(4));


	


		
			DoblesParejas doblesParejasAltas = new DoblesParejas(cartasBase1);
			Color cartaMasAlta2 = new Color(cartas2);
			
			System.out.println("Comparando");
			System.out.println(doblesParejasAltas + cartasBase1.toString());
			System.out.println(cartaMasAlta2 + cartas2.toString());
			System.out.println();
			
			Assert.assertTrue(doblesParejasAltas.compareTo(cartaMasAlta2)>=0);
			cartas2.clear();
	
		
		

		
	}
}
