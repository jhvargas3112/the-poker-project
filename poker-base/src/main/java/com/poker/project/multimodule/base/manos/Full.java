package com.poker.project.multimodule.base.manos;

import java.util.ArrayList;
import com.poker.project.multimodule.base.cartas.Carta;
import com.poker.project.multimodule.base.manos.exceptions.NotValidCardsInPokerHandException;
import com.poker.project.multimodule.base.manos.exceptions.NotValidNumberOfCardsInPokerHandException;
import com.poker.project.multimodule.base.manos.validadores.ValidadorManos;

public class Full extends Mano {
  public Full(ArrayList<Carta> cartas)
      throws NotValidNumberOfCardsInPokerHandException, NotValidCardsInPokerHandException {
    setCartas(cartas);
    nombreMano = NombreMano.FULL;
  }

  public void setCartas(ArrayList<Carta> cartas)
      throws NotValidNumberOfCardsInPokerHandException, NotValidCardsInPokerHandException {
    if (!ValidadorManos.validarFull(cartas)) {
      throw new NotValidCardsInPokerHandException();
    }

    this.cartas = cartas;
  }

  @Override
  public int compareTo(Mano o) {
    return 0;
  }
}
