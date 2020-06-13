package manos.exceptions;

public class NotValidCardsInPokerHandException extends Exception {
  public NotValidCardsInPokerHandException() {
    super("The set of cards in this poker hand is not valid.");
  }

  public NotValidCardsInPokerHandException(String message) {
    super(message);
  }
}
