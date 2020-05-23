package com.poker.project.multimodule.manos;

import java.util.ArrayList;
import java.util.List;

import com.poker.project.multimodule.base.Carta;
import com.poker.project.multimodule.base.Palo;

public class FactTestManos 
{
	public List<Carta> creaPareja()
	{
		List<Carta> cartas= new ArrayList<>();
		
		cartas.add(new Carta(2,Palo.PICAS));
		cartas.add(new Carta(2,Palo.TREBOLES));
	
		cartas.add(new Carta(4,Palo.PICAS));
		cartas.add(new Carta(5,Palo.DIAMANTES));
		cartas.add(new Carta(7,Palo.CORAZONES));
		
		return cartas;
		
	}
	
	public List<Carta> creaTrio()
	{
		List<Carta> cartas= new ArrayList<>();
		
		cartas.add(new Carta(3,Palo.PICAS));
		cartas.add(new Carta(3,Palo.TREBOLES));
		cartas.add(new Carta(3,Palo.DIAMANTES));

	
		cartas.add(new Carta(4,Palo.PICAS));
		cartas.add(new Carta(7,Palo.CORAZONES));
		
		return cartas;
		
	}
	
	public List<Carta> creaPoker()
	{
		List<Carta> cartas= new ArrayList<>();
		
		cartas.add(new Carta(1,Palo.PICAS));
		cartas.add(new Carta(1,Palo.TREBOLES));
		cartas.add(new Carta(1,Palo.DIAMANTES));
		cartas.add(new Carta(1,Palo.CORAZONES));

	
		cartas.add(new Carta(4,Palo.PICAS));
		
		return cartas;
		
	}
	
	public List<Carta> creaEscalera()
	{
		List<Carta> cartas= new ArrayList<>();
		
		cartas.add(new Carta(12,Palo.PICAS));
		cartas.add(new Carta(11,Palo.TREBOLES));
		cartas.add(new Carta(10,Palo.PICAS));
		cartas.add(new Carta(9,Palo.CORAZONES));	
		cartas.add(new Carta(8,Palo.PICAS));
		
		return cartas;
		
	}
	
	public List<Carta> creaEscaleraColor()
	{
		List<Carta> cartas= new ArrayList<>();
		
		cartas.add(new Carta(12,Palo.DIAMANTES));
		cartas.add(new Carta(11,Palo.DIAMANTES));
		cartas.add(new Carta(10,Palo.DIAMANTES));
		cartas.add(new Carta(9,Palo.DIAMANTES));	
		cartas.add(new Carta(8,Palo.DIAMANTES));
		
		return cartas;
		
	}
	
	public List<Carta> creaEscaleraColorBaja()
	{
		List<Carta> cartas= new ArrayList<>();
		
		cartas.add(new Carta(7,Palo.DIAMANTES));
		cartas.add(new Carta(6,Palo.DIAMANTES));
		cartas.add(new Carta(5,Palo.DIAMANTES));
		cartas.add(new Carta(4,Palo.DIAMANTES));	
		cartas.add(new Carta(3,Palo.DIAMANTES));
		
		return cartas;
		
	}
	
	public List<Carta> creaEscaleraBaja()
	{
		List<Carta> cartas= new ArrayList<>();
		
		cartas.add(new Carta(7,Palo.TREBOLES));
		cartas.add(new Carta(6,Palo.CORAZONES));
		cartas.add(new Carta(5,Palo.PICAS));
		cartas.add(new Carta(4,Palo.DIAMANTES));	
		cartas.add(new Carta(3,Palo.DIAMANTES));
		
		return cartas;
		
	}
	
	public List<Carta> creaDoblesPareja()
	{
		List<Carta> cartas= new ArrayList<>();
		
		cartas.add(new Carta(12,Palo.PICAS));
		cartas.add(new Carta(12,Palo.TREBOLES));
	
		cartas.add(new Carta(10,Palo.PICAS));
		cartas.add(new Carta(10,Palo.DIAMANTES));
		cartas.add(new Carta(7,Palo.CORAZONES));
		
		return cartas;
		
	}
	
	public List<Carta> creaDoblesParejaBajas()
	{
		List<Carta> cartas= new ArrayList<>();
		
		cartas.add(new Carta(2,Palo.PICAS));
		cartas.add(new Carta(2,Palo.TREBOLES));
	
		cartas.add(new Carta(4,Palo.PICAS));
		cartas.add(new Carta(4,Palo.DIAMANTES));
		cartas.add(new Carta(7,Palo.CORAZONES));
		
		return cartas;
		
	}
	
	public List<Carta> creaColor()
	{
		List<Carta> cartas= new ArrayList<>();
		
		cartas.add(new Carta(8,Palo.TREBOLES));
		cartas.add(new Carta(10,Palo.TREBOLES));
	
		cartas.add(new Carta(11,Palo.TREBOLES));
		cartas.add(new Carta(5,Palo.TREBOLES));
		cartas.add(new Carta(7,Palo.TREBOLES));
		
		return cartas;
		
	}
	
	public List<Carta> creaColorBajo()
	{
		List<Carta> cartas= new ArrayList<>();
		
		cartas.add(new Carta(2,Palo.PICAS));
		cartas.add(new Carta(3,Palo.PICAS));
	
		cartas.add(new Carta(9,Palo.PICAS));
		cartas.add(new Carta(5,Palo.PICAS));
		cartas.add(new Carta(7,Palo.PICAS));
		
		return cartas;
		
	}


}
