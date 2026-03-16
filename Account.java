import java.util.ArrayList;

public class Account {

    private int accountNumber;
    private int pin;
    private double balance;
    private ArrayList<String> transactions;

    public Account(int accountNumber, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        transactions = new ArrayList<>();
        transactions.add("Account created with balance: ₹" + balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public boolean validatePin(int enteredPin) {
        return pin == enteredPin;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited ₹" + amount);
        System.out.println("Deposit successful.");
    }

    public void withdraw(double amount) {

        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            transactions.add("Withdraw ₹" + amount);
            System.out.println("Withdrawal successful.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void showTransactions() {

        System.out.println("\nTransaction History:");

        for (String t : transactions) {
            System.out.println(t);
        }
    }
}