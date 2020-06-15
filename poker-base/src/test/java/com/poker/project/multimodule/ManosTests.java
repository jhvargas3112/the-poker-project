package com.poker.project.multimodule;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import com.poker.project.multimodule.base.manos.Full;
import com.poker.project.multimodule.base.manos.Pareja;
import com.poker.project.multimodule.base.manos.CartaAlta;
import com.poker.project.multimodule.base.manos.exceptions.NotValidCardsInPokerHandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.poker.project.multimodule.base.cartas.Carta;
import com.poker.project.multimodule.base.cartas.Palo;
import com.poker.project.multimodule.base.manos.exceptions.NotValidNumberOfCardsInPokerHandException;

public class ManosTests {
  private ArrayList<Carta> cartas;

  @BeforeEach
  public void setup() {
    cartas = new ArrayList<>();
  }

  @Test
  public void NumeroInsuficienteCartas() {
    cartas.add(new Carta(2, Palo.PICAS));
    cartas.add(new Carta(12, Palo.TREBOLES));
    cartas.add(new Carta(12, Palo.CORAZONES));
    cartas.add(new Carta(12, Palo.PICAS));

    assertThrows(NotValidNumberOfCardsInPokerHandException.class, () -> new Full(cartas));
    assertThrows(NotValidNumberOfCardsInPokerHandException.class, () -> new Pareja(cartas));
    assertThrows(NotValidNumberOfCardsInPokerHandException.class, () -> new CartaAlta(cartas));
  }

  @Test
  public void NumeroExcedidoCartas() {
    cartas.add(new Carta(2, Palo.PICAS));
    cartas.add(new Carta(2, Palo.DIAMANTES));
    cartas.add(new Carta(8, Palo.TREBOLES));
    cartas.add(new Carta(12, Palo.TREBOLES));
    cartas.add(new Carta(12, Palo.CORAZONES));
    cartas.add(new Carta(12, Palo.PICAS));

    assertThrows(NotValidNumberOfCardsInPokerHandException.class, () -> new Full(cartas));
    assertThrows(NotValidNumberOfCardsInPokerHandException.class, () -> new Pareja(cartas));
    assertThrows(NotValidNumberOfCardsInPokerHandException.class, () -> new CartaAlta(cartas));
  }

  @Test
  public void fullValido()
      throws NotValidNumberOfCardsInPokerHandException, NotValidCardsInPokerHandException {
    Full full = null;

    cartas.add(new Carta(2, Palo.PICAS));
    cartas.add(new Carta(2, Palo.CORAZONES));
    cartas.add(new Carta(12, Palo.TREBOLES));
    cartas.add(new Carta(12, Palo.CORAZONES));
    cartas.add(new Carta(12, Palo.PICAS));

    full = new Full(cartas);

    Assertions.assertNotNull(full);
    Assertions.assertEquals(5, full.getCartas().size());
  }

  @Test
  public void fullValidoCartasSinOrdenEspecifico()
      throws NotValidNumberOfCardsInPokerHandException, NotValidCardsInPokerHandException {
    Full full = null;

    cartas.add(new Carta(12, Palo.CORAZONES));
    cartas.add(new Carta(2, Palo.PICAS));
    cartas.add(new Carta(12, Palo.TREBOLES));
    cartas.add(new Carta(12, Palo.PICAS));
    cartas.add(new Carta(2, Palo.CORAZONES));

    full = new Full(cartas);

    Assertions.assertNotNull(full);
    Assertions.assertEquals(5, full.getCartas().size());
  }

  @Test
  public void fullNoValido() {
    cartas.add(new Carta(2, Palo.PICAS));
    cartas.add(new Carta(2, Palo.CORAZONES));
    cartas.add(new Carta(4, Palo.DIAMANTES));
    cartas.add(new Carta(12, Palo.TREBOLES));
    cartas.add(new Carta(12, Palo.CORAZONES));

    assertThrows(NotValidCardsInPokerHandException.class, () -> new Full(cartas));
  }

  @Test
  public void parejaValida()
      throws NotValidNumberOfCardsInPokerHandException, NotValidCardsInPokerHandException {
    Pareja pareja = null;

    cartas.add(new Carta(3, Palo.PICAS));
    cartas.add(new Carta(6, Palo.TREBOLES));
    cartas.add(new Carta(7, Palo.PICAS));
    cartas.add(new Carta(12, Palo.CORAZONES));
    cartas.add(new Carta(12, Palo.DIAMANTES));

    pareja = new Pareja(cartas);

    Assertions.assertNotNull(pareja);
    Assertions.assertEquals(5, pareja.getCartas().size());
  }

  @Test
  public void parejaValidaCartasSinOrdenEspecifico()
      throws NotValidNumberOfCardsInPokerHandException, NotValidCardsInPokerHandException {
    Pareja pareja = null;

    cartas.add(new Carta(7, Palo.PICAS));
    cartas.add(new Carta(12, Palo.CORAZONES));
    cartas.add(new Carta(3, Palo.PICAS));
    cartas.add(new Carta(6, Palo.TREBOLES));
    cartas.add(new Carta(12, Palo.DIAMANTES));

    pareja = new Pareja(cartas);

    Assertions.assertNotNull(pareja);
    Assertions.assertEquals(5, pareja.getCartas().size());
  }

  @Test
  public void parejaNoValida() {
    cartas.add(new Carta(6, Palo.TREBOLES));
    cartas.add(new Carta(7, Palo.PICAS));
    cartas.add(new Carta(12, Palo.CORAZONES));
    cartas.add(new Carta(12, Palo.DIAMANTES));
    cartas.add(new Carta(12, Palo.TREBOLES));

    assertThrows(NotValidCardsInPokerHandException.class, () -> new Pareja(cartas));
  }

  @Test
  public void cartaAltaValida()
      throws NotValidNumberOfCardsInPokerHandException, NotValidCardsInPokerHandException {
    CartaAlta manoCartaAlta = null;

    cartas.add(new Carta(2, Palo.PICAS));
    cartas.add(new Carta(4, Palo.CORAZONES));
    cartas.add(new Carta(7, Palo.DIAMANTES));
    cartas.add(new Carta(11, Palo.TREBOLES));
    cartas.add(new Carta(13, Palo.CORAZONES));

    manoCartaAlta = new CartaAlta(cartas);

    Assertions.assertNotNull(manoCartaAlta);
    Assertions.assertEquals(5, manoCartaAlta.getCartas().size());
  }

  @Test
  public void cartaAltaNoValida() {
    cartas.add(new Carta(2, Palo.PICAS));
    cartas.add(new Carta(2, Palo.CORAZONES));
    cartas.add(new Carta(12, Palo.TREBOLES));
    cartas.add(new Carta(12, Palo.CORAZONES));
    cartas.add(new Carta(12, Palo.PICAS));

    assertThrows(NotValidCardsInPokerHandException.class, () -> new CartaAlta(cartas));
  }
}
