package manos.exceptions;

public class WrongNumberOfCardsException extends Exception {
  public WrongNumberOfCardsException() {
    super("Wrong number of cards. The correct number of cards is 5.");
  }

  public WrongNumberOfCardsException(String message) {
    super(message);
  }
}
