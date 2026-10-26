import java.util.ArrayList;
import java.util.List;

/** Represents a bank account with deposit, withdrawal, and freeze operations. */
public abstract class BankAccount {
  private double balance;
  private boolean isFrozen; // Changed to private for encapsulation
  private List<Transaction> transactionHistory;

  /** Creates an account with a zero balance and no transaction history. */
  public BankAccount() {
    this.balance = 0;
    this.isFrozen = false;
    this.transactionHistory = new ArrayList<>();
  }

  /** Deposits a positive amount unless the account is frozen. */
  public void deposit(double amount) throws InvalidAmountException, AccountFrozenException {
    if (isFrozen) {
      throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
    }

    if (!(amount > 0)) {
      throw new InvalidAmountException("Invalid amount. Must be greater than 0");
    }

    balance += amount;
    transactionHistory.add(new Transaction("Deposit", amount));
    System.out.printf("Amount deposited: %.2f%n", amount);
    System.out.printf("Current balance: %.2f%n", balance);
  }

  /** Withdraws a positive amount if sufficient funds are available. */
  public void withdraw(double amount)
      throws InvalidAmountException, InsufficientFundsException, AccountFrozenException {

    if (isFrozen) {
      throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
    }

    System.out.printf("Amount withdrawn: %.2f%n", amount);

    if (!(amount > 0)) {
      throw new InvalidAmountException("Invalid amount. Must be greater than 0");
    }

    if (amount > balance) {
      System.out.printf("Current balance: %.2f%n", balance);
      throw new InsufficientFundsException("Insufficient balance.");
    }

    balance -= amount;
    transactionHistory.add(new Transaction("Withdrawal", amount));
    System.out.printf("Current balance: %.2f%n", balance);
  }

  public double getBalance() {
    return balance;
  }

  public abstract String getOwnerName();

  public void freezeAccount() {
    isFrozen = true;
  }

  public void unfreezeAccount() {
    isFrozen = false;
    System.out.println("Account is UNFROZEN.");
  }

  public List<Transaction> getTransactionHistory() {
    return transactionHistory;
  }
}
