/**
 * Indicates that an operation failed because the available funds were insufficient.
 */
public class InsufficientFundsException extends Exception {
  private final String message;

  public InsufficientFundsException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
