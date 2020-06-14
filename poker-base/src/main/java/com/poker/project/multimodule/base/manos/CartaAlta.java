package com.poker.project.multimodule.base.manos;

import com.poker.project.multimodule.base.cartas.Carta;
import com.poker.project.multimodule.base.manos.exceptions.NotValidCardsInPokerHandException;
import com.poker.project.multimodule.base.manos.exceptions.NotValidNumberOfCardsInPokerHandException;
import com.poker.project.multimodule.base.manos.validadores.ValidadorManos;

import java.util.ArrayList;

public class CartaAlta extends Mano {
  public CartaAlta(ArrayList<Carta> cartas)
      throws NotValidNumberOfCardsInPokerHandException, NotValidCardsInPokerHandException {
    setCartas(cartas);
    nombreMano = NombreMano.CARTA_ALTA;
  }

  public void setCartas(ArrayList<Carta> cartas)
      throws NotValidNumberOfCardsInPokerHandException, NotValidCardsInPokerHandException {
    if (!ValidadorManos.validarCartaAlta(cartas)) {
      throw new NotValidCardsInPokerHandException();
    }

    this.cartas = cartas;
  }

  @Override
  public int compareTo(Mano o) {
    return 0;
  }
}
