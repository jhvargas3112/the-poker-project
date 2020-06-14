package com.poker.project.multimodule.base.util.ordenar.comp;

import java.util.Comparator;
import com.poker.project.multimodule.base.cartas.Carta;

public class ComparadorCartaPorNumero implements Comparator<Carta> {
  @Override
  public int compare(Carta carta1, Carta carta2) {
    if (carta1.getNum() > carta2.getNum()) {
      return 1;
    } else if (carta1.getNum() < carta2.getNum()) {
      return -1;
    } else {
      return 0;
    }
  }
}
