package com.poker.project.multimodule.base.mazos;

import java.util.ArrayList;

import com.poker.project.multimodule.base.Carta;

public interface MazoOpt 
{
	
	public Carta dameCartaAleatoria();
	public ArrayList<Carta> dameNCartas(int n);
	
	public void insertaCarta(Carta c);
	public void insertaCarta(ArrayList<Carta> l);
	
	

}
