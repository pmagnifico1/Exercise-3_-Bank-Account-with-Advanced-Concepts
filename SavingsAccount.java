/** Represents a savings account with an owner name. */
public class SavingsAccount extends BankAccount {
  private String ownerName; // Changed to private for encapsulation

  public SavingsAccount(String ownerName) {
    this.ownerName = ownerName;
  }

  /** Returns the savings account owner's name. */
  @Override
  public String getOwnerName() {
    return ownerName;
  }
}
