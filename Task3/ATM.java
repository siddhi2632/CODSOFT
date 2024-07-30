import java.util.Scanner;

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("ATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            }

            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();

            switch (choice) {
                case 1:
                    if (amount > account.getBalance()) {
                        System.out.println("Insufficient balance.");
                    } else {
                        account.withdraw(amount);
                        System.out.println("Withdrawal successful. New balance: " + account.getBalance());
                    }
                    break;
                case 2:
                    account.deposit(amount);
                    System.out.println("Deposit successful. New balance: " + account.getBalance());
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance());
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // Initial balance
        ATM atm = new ATM(account);
        atm.start();
    }
}
