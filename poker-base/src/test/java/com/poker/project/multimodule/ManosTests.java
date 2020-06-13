package com.poker.project.multimodule;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;
import com.poker.project.multimodule.base.cartas.Carta;
import com.poker.project.multimodule.base.cartas.Palo;
import manos.Full;
import manos.Pareja;

public class ManosTests {
  @Test
  public void fullVsPair() {
    ArrayList<Carta> cartasFull = new ArrayList<Carta>();
    
    cartasFull.add(new Carta(11, Palo.TREBOLES));
    cartasFull.add(new Carta(11, Palo.CORAZONES));
    cartasFull.add(new Carta(11, Palo.DIAMANTES));
    cartasFull.add(new Carta(1, Palo.CORAZONES));
    cartasFull.add(new Carta(1, Palo.TREBOLES));
    
    Full full = new Full(cartasFull);
    
    ArrayList<Carta> cartasPareja = new ArrayList<Carta>();
    
    cartasPareja.add(new Carta(1, Palo.CORAZONES));
    cartasPareja.add(new Carta(1, Palo.TREBOLES));
    cartasPareja.add(new Carta(8, Palo.PICAS));
    cartasPareja.add(new Carta(6, Palo.CORAZONES));
    cartasPareja.add(new Carta(2, Palo.DIAMANTES));
    
    Pareja pareja = new Pareja(cartasPareja);
    
    assertEquals(1, full.compareTo(pareja));
  }
}
