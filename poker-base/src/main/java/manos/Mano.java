package manos;

import java.util.ArrayList;
import com.poker.project.multimodule.base.cartas.Carta;
import manos.exceptions.NotValidNumberOfCardsInPokerHandException;

public class Mano implements Comparable<Mano> {
  protected ArrayList<Carta> cartas;
  protected NombreMano nombreMano;

  public Mano(ArrayList<Carta> cartas) throws NotValidNumberOfCardsInPokerHandException {
    setCartas(cartas);
  }

  public ArrayList<Carta> getCartas() {
    return cartas;
  }

  public void setCartas(ArrayList<Carta> cartas) throws NotValidNumberOfCardsInPokerHandException {
    if (cartas.size() < 5) {
      throw new NotValidNumberOfCardsInPokerHandException();
    }

    this.cartas = cartas;
  }

  @Override
  public int compareTo(Mano o) {
    return 0;
  }
}
