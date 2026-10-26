public class InvalidAmountException extends Exception {
  private final String message;

  public InvalidAmountException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
