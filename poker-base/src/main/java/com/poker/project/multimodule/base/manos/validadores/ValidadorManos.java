package com.poker.project.multimodule.base.manos.validadores;

import com.poker.project.multimodule.base.cartas.Carta;
import com.poker.project.multimodule.base.manos.exceptions.NotValidNumberOfCardsInPokerHandException;
import com.poker.project.multimodule.base.util.ordenar.comp.ComparadorCartaPorNumero;

import java.util.ArrayList;

public class ValidadorManos {
  private static final int NUM_CARTAS_MANO = 5;

  /**
   * Coste en tiempo O(n).
   *
   * @param cartas
   * @return
   */
  public static boolean validarFull(ArrayList<Carta> cartas)
      throws NotValidNumberOfCardsInPokerHandException {
    if (!validarNumeroCartasMano(cartas)) {
      throw new NotValidNumberOfCardsInPokerHandException();
    }

    cartas.sort(new ComparadorCartaPorNumero());

    int i = 1;

    while (i < cartas.size()) {
      if (cartas.get(i - 1).getNum() == cartas.get(i).getNum()) {
        ++i;
      } else {
        break;
      }
    }

    int j = i;
    int k = 1;

    while (j < cartas.size() - 1) {
      if (cartas.get(j).getNum() == cartas.get(j + 1).getNum()) {
        ++k;
      } else {
        break;
      }

      ++j;
    }

    return (i == 2 && k == 3) || (i == 3 && k == 2);
  }

  public static boolean validarPareja(ArrayList<Carta> cartas)
      throws NotValidNumberOfCardsInPokerHandException {
    if (!validarNumeroCartasMano(cartas)) {
      throw new NotValidNumberOfCardsInPokerHandException();
    }

    // TODO: implement the whole method body.

    return true;
  }

  public static boolean validarCartaAlta(ArrayList<Carta> cartas)
      throws NotValidNumberOfCardsInPokerHandException {
    if (!validarNumeroCartasMano(cartas)) {
      throw new NotValidNumberOfCardsInPokerHandException();
    }

    cartas.sort(new ComparadorCartaPorNumero());

    return !validarFull(cartas);
  }

  public static boolean validarNumeroCartasMano(ArrayList<Carta> cartas) {
    return cartas.size() == NUM_CARTAS_MANO;
  }
}
