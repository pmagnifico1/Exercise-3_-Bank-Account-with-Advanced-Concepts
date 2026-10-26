
/** Runs a basic demonstration of bank account operations. */
public class Main {
  /** Runs the account and transaction history demonstration. */
  public static void main(String[] args) {
    BankAccount acc1 = new SavingsAccount("Test0");
    BankAccountManager accM1 = new BankAccountManager();

    try {
      // /* TEST CASES */
      //
      // /* 1 */
      // acc1.deposit(-500);

      // /* 2 */
      // acc1.freezeAccount();
      // acc1.deposit(11500);

      // /* 3 */
      // acc1.withdraw(-100);

      // /* 4 */
      // acc1.deposit(500.125);
      // acc1.withdraw(1500);

      // /* 5 */
      // acc1.freezeAccount();
      // acc1.withdraw(500);

      // /* 6 */
      // --- SAMPLE TRANSACTIONS --- //
      acc1.deposit(300);
      acc1.withdraw(150);
      acc1.withdraw(100);
      acc1.deposit(213);

      accM1.filterTransactionsAtOrAbove(200, acc1.getTransactionHistory());
      accM1.sortTransactionsByAmount(acc1.getTransactionHistory());
    } catch (InvalidAmountException | InsufficientFundsException | AccountFrozenException e) {
      System.out.println(e.getMessage());
    }
  }
}
