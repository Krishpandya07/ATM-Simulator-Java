import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    private ArrayList<Account> accounts;
    private Scanner sc;

    public ATM() {
        accounts = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void start() {

        while (true) {

            System.out.println("\n===== ATM MACHINE =====");
            System.out.println("1. Create Account");
            System.out.println("2. Login Account");
            System.out.println("3. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createAccount();
                    break;

                case 2:
                    login();
                    break;

                case 3:
                    System.out.println("Thank you for using ATM.");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void createAccount() {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Set PIN: ");
        int pin = sc.nextInt();

        System.out.print("Enter Initial Deposit: ");
        double balance = sc.nextDouble();

        Account acc = new Account(accNo, pin, balance);
        accounts.add(acc);

        System.out.println("Account Created Successfully!");
    }

    private void login() {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        for (Account acc : accounts) {

            if (acc.getAccountNumber() == accNo && acc.validatePin(pin)) {

                System.out.println("Login Successful!");
                atmMenu(acc);
                return;
            }
        }

        System.out.println("Invalid Account Number or PIN.");
    }

    private void atmMenu(Account acc) {

        while (true) {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Logout");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    acc.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double deposit = sc.nextDouble();
                    acc.deposit(deposit);
                    break;

                case 3:
                    System.out.print("Enter amount: ");
                    double withdraw = sc.nextDouble();
                    acc.withdraw(withdraw);
                    break;

                case 4:
                    acc.showTransactions();
                    break;

                case 5:
                    System.out.println("Logged out.");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}