public class Account {

  // Instance vars
  protected double balance;
  protected int id;

  // Constructor
  public Account(int newId, double newBalance) {
    this.balance = newBalance;
    this.id = newId;
  }

  // Instance methods
  public void withdraw(double amount){
    balance -= amount;
  }

  public void deposit(double amount){
    balance += amount;
  }

  // Accessor
  public double getBalance() {
    return balance;
  }

  public String toString() {
    return "Account #" + id + ", balance = " + balance;
  }

  public static void main(String[] args) {
    Account myAccount = new Account(1, 200);
    myAccount.deposit(15);
    System.out.println(myAccount.toString());
  }
}
