public class AccountFrozenException extends Exception {
  private final String message;

  public AccountFrozenException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
