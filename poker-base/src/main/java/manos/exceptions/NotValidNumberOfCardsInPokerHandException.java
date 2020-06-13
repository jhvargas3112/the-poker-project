package manos.exceptions;

public class NotValidNumberOfCardsInPokerHandException extends Exception {
  public NotValidNumberOfCardsInPokerHandException() {
    super("Wrong number of cards. The correct number of cards is 5.");
  }

  public NotValidNumberOfCardsInPokerHandException(String message) {
    super(message);
  }
}
