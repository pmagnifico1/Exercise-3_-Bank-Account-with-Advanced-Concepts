/** Represents a bank that manages accounts. */
public interface Bank {
  void addAccount(BankAccount account);

  BankAccount getAccount(int id);
}
