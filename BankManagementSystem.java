import java.util.Scanner;

class BankAccount {
    String accountHolderName;
    int accountNumber;
    double balance;

    BankAccount(String name, int accNo) {
        accountHolderName = name;
        accountNumber = accNo;
        balance = 0.0;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid Amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient Balance or Invalid Amount.");
        }
    }

    void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    void displayDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = null;
        int choice;

        do {
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    if (account == null) {
                        System.out.print("Enter Account Holder Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Account Number: ");
                        int accNo = sc.nextInt();
                        account = new BankAccount(name, accNo);
                        System.out.println("Account Created Successfully!");
                    } else {
                        System.out.println("Account already exists!");
                    }
                    break;
                case 2:
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmt = sc.nextDouble();
                        account.deposit(depositAmt);
                    } else {
                        System.out.println("No account found. Please create one.");
                    }
                    break;
                case 3:
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmt = sc.nextDouble();
                        account.withdraw(withdrawAmt);
                    } else {
                        System.out.println("No account found. Please create one.");
                    }
                    break;
                case 4:
                    if (account != null) {
                        account.checkBalance();
                    } else {
                        System.out.println("No account found. Please create one.");
                    }
                    break;
                case 5:
                    if (account != null) {
                        account.displayDetails();
                    } else {
                        System.out.println("No account found. Please create one.");
                    }
                    break;
                case 6:
                    System.out.println("Thank you for using our Bank!");
                    break;
                default:
                    System.out.println("Invalid Choice. Please try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}
