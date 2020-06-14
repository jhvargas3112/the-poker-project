package com.poker.project.multimodule.base.manos;

import java.util.ArrayList;
import com.poker.project.multimodule.base.cartas.Carta;
import com.poker.project.multimodule.base.manos.exceptions.NotValidCardsInPokerHandException;
import com.poker.project.multimodule.base.manos.exceptions.NotValidNumberOfCardsInPokerHandException;

public abstract class Mano implements Comparable<Mano> {
  protected ArrayList<Carta> cartas;
  protected NombreMano nombreMano;

  public NombreMano getNombreMano() {
    return nombreMano;
  }

  public void setNombreMano(NombreMano nombreMano) {
    this.nombreMano = nombreMano;
  }

  public ArrayList<Carta> getCartas() {
    return cartas;
  }

  public abstract void setCartas(ArrayList<Carta> cartas)
      throws NotValidNumberOfCardsInPokerHandException, NotValidCardsInPokerHandException;
}
