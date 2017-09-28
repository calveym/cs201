// PasswordAccount.java
// Michael Calvey
// CS201 HW2 Question 4

public class PasswordAccount {

    // instance variables

    protected int id;
    protected double balance;
    protected String password;


    // constructors

    // calls outer constructor with 0 balance
    public PasswordAccount(int id, String password) {
        this(id, password, 0.0);
    }

    // sets initial instance variables
    public PasswordAccount(int id, String password, double balance) {
        this.id = id;
        this.balance = balance;
        this.password = password;
    }


    // instance methods

    // Runs checks for withdrawal
    public void withdraw(int amount, String input) {
        if (checkPass(input)) {
            // withdrawal approved
            if(balanceCheck(amount)) { return; }
            modifyBalance(-amount);
            log("Withdrew $" + round(amount));
        } else {
            log("Incorrect password, please try again");
        }
    }

    // Runs checks for deposit
    public void deposit(int amount) {
        // This was added before testing with the required file
        // if(checkPass(input)) {
        //     // deposit approved
        modifyBalance(amount);
        log("Deposited $" + round(amount));
        // } else {
        //     log("Incorrect password, please try again");
        // }
    }

    // Pretty print balance
    public void printBalance(String input) {
        if (checkPass(input)) {
            // Print approved
            log("Your balance is $" + balance + ".");
        } else {
            log("Incorrect password, please try again");
        }
    }

    // Modifies balance by amount
    private void modifyBalance(double amount) {
        balance += amount;
    }

    // Check to stop overdraft
    public boolean balanceCheck(double amount) {
        if(balance < amount) {
            log("Withdrawing $" + amount +
                " would lead to an overdraft of $" + (balance -
                amount));
            return true;
        } else { return false; }
    }

    // Check for password match
    // I feel ashamed for storing passwords in plaintext
    public boolean checkPass(String input) {
        return input.equals(password);
    }

    // String representation for printing
    public String toString() {
        return ("Account #" + id);
    }

    // Logger, wraps System.out.println
    public void log(String logString) {
        System.out.println(logString);
    }

    // returns number rounded to have 2 decimal points
    public double round(double input) {
        return (Math.round(input * 100) / 100.0);
    }
}
