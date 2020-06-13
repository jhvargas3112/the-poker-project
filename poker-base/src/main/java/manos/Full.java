package manos;

import java.util.ArrayList;
import com.poker.project.multimodule.base.cartas.Carta;
import manos.exceptions.NotValidCardsInPokerHandException;
import manos.exceptions.NotValidNumberOfCardsInPokerHandException;

public class Full extends Mano {
  public Full(ArrayList<Carta> cartas)
      throws NotValidNumberOfCardsInPokerHandException, NotValidCardsInPokerHandException {
    super(cartas);

    if (!validateCards(cartas)) {
      throw new NotValidCardsInPokerHandException();
    }

    super.nombreMano = NombreMano.FULL;
  }

  private boolean validateCards(ArrayList<Carta> cartas) {
    // TODO: implement the whole method body

    return false;
  }
}
