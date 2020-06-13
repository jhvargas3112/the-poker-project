package com.poker.project.multimodule;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.poker.project.multimodule.base.cartas.Carta;
import com.poker.project.multimodule.base.cartas.Palo;
// import manos.Full;
import manos.Mano;
// import manos.Pareja;
import manos.exceptions.WrongNumberOfCardsException;

public class ManosTests {
  private ArrayList<Carta> cartas;

  @BeforeEach
  public void setup() {
    cartas = new ArrayList<>();
  }

  @Test
  public void numeroCartasManoValido() throws WrongNumberOfCardsException {
    Mano mano = null;

    cartas.add(new Carta(2, Palo.PICAS));
    cartas.add(new Carta(2, Palo.TREBOLES));
    cartas.add(new Carta(2, Palo.CORAZONES));
    cartas.add(new Carta(12, Palo.TREBOLES));
    cartas.add(new Carta(13, Palo.DIAMANTES));

    mano = new Mano(cartas);

    Assertions.assertNotNull(mano);
    Assertions.assertEquals(5, mano.getCartas().size());
  }

  @Test
  public void NumeroCartasManoErroneo() {
    cartas.add(new Carta(2, Palo.PICAS));
    cartas.add(new Carta(2, Palo.CORAZONES));
    cartas.add(new Carta(12, Palo.TREBOLES));
    cartas.add(new Carta(13, Palo.DIAMANTES));

    assertThrows(WrongNumberOfCardsException.class, () -> new Mano(cartas));
  }

  /* @Test
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
  } */
}
