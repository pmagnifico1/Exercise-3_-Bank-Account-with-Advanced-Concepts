import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** Manages bank accounts stored by their account IDs. */
public class BankAccountManager implements Bank {
  Map<Integer, BankAccount> accounts;
  int id;

  public BankAccountManager() {
    this.accounts = new HashMap<>();
    this.id = 0;
  }

  @Override
  public void addAccount(BankAccount account) {
    if (accounts.size() >= 100) {
      System.out.println("Maximum accounts reached");
      return;
    }

    accounts.put(id, account);
    System.out.println("Account added successfully with ID: " + id);
    id++;
  }

  @Override
  public BankAccount getAccount(int id) {
    // TODO Auto-generated method stub
    return accounts.get(id);
  }

  /** Returns transactions whose amounts are at least the specified amount. */
  public List<Transaction> filterTransactionsAtOrAbove(double amount, List<Transaction> txList) {
    List<Transaction> filteredTransactions = txList.stream()
        .filter(transaction -> transaction.getAmount() >= amount)
        .collect(Collectors.toList());
    System.out.println("Filtering transactions at or above " + amount + "...");
    System.out.println(filteredTransactions);
    return filteredTransactions;
  }

  /** Returns the transactions sorted by amount in ascending order. */
  public List<Transaction> sortTransactionsByAmount(List<Transaction> txList) {
    List<Transaction> sortedTransactions = txList.stream()
        .sorted((first, second) -> Double.compare(first.getAmount(), second.getAmount()))
        .collect(Collectors.toList());
    System.out.println("Sorting transactions by amount...");
    System.out.println(sortedTransactions);
    return sortedTransactions;
  }

  /** Prints each account's ID, owner name, and balance. */
  public void listAccounts() {
    for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
      int accountId = entry.getKey();
      BankAccount account = entry.getValue();
      System.out.printf(
          "Account ID: %d, Account Name: %s, Balance: %.2f%n",
          accountId, account.getOwnerName(), account.getBalance());
    }
  }
}
