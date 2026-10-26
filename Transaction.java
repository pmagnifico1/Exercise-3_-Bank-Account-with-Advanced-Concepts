import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** Records the type, amount, and timestamp of an account transaction. */
public class Transaction {
  private static final DateTimeFormatter TIME_FORMAT =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
  private final String type;
  private final double amount;
  private final LocalDateTime timeStamp;

  /** Creates a transaction with the current timestamp. */
  public Transaction(String type, double amount) {
    this.type = type;
    this.amount = amount;
    this.timeStamp = LocalDateTime.now();
  }

  public double getAmount() {
    return amount;
  }

  @Override
  public String toString() {
    return "Transaction [type=" + type
        + ", amount=" + amount
        + ", time_stamp=" + timeStamp.format(TIME_FORMAT)
        + "]";
  }
}
