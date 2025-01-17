import java.util.Random;
import java.util.Scanner;

interface NRB {
    String countryCode = "977"; 
    String extensionLine = "NP"; 
    void openAccount(String accountType);
    void deposit(double amount);
    void withdraw(double amount);
    double calculateInterest();
}

class BankA implements NRB {
    private double balance = 0;
    private final double CHEQUING_RATE = 0.03; 
    private final double SAVINGS_RATE = 0.05; 
    private final double FIXED_DEPOSIT_RATE = 0.07; 
    private int depositCount = 0;

    @Override
    public void openAccount(String accountType) {
        Random random = new Random();
        int randomInt = Math.abs(random.nextInt());
        System.out.println("BankA: " + accountType + " account has been opened.");
        System.out.println("Your account number is:" + countryCode+ randomInt + extensionLine);

    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            depositCount++;
            
            if (depositCount >= 1) {
                double interest = calculateInterest();
                balance += interest;
                System.out.println("Interest of " + interest + " added to your balance.");
            }
            
            System.out.println("Total balance in Bank A: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
            System.out.println("Remaining balance: " + balance);
        } else if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
    @Override
    public double calculateInterest() {
        double interestRate = 0;
        if (balance >= 100000) {
            interestRate = FIXED_DEPOSIT_RATE; 
        } 
        else if(balance >= 20000 && balance < 100000) {
            interestRate = SAVINGS_RATE; 
        }
        else{
            interestRate = CHEQUING_RATE;
        }
        return balance * interestRate;
    }
}


class BankB implements NRB {
    private double balance = 0;
    private final double CHEQUING_RATE = 0.04; 
    private final double SAVINGS_RATE = 0.06; 
    private final double FIXED_DEPOSIT_RATE = 0.08; 
    private int depositCount = 0; 
    @Override
    public void openAccount(String accountType) {
        Random random = new Random();

        int randomInt = Math.abs(random.nextInt());
        System.out.println("BankB: " + accountType + " account has been opened.");
        System.out.println("Your account number is:" + countryCode+ randomInt + extensionLine);

    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            depositCount++;
            
            if (depositCount >= 1) {
                double interest = calculateInterest();
                balance += interest;
                System.out.println("Interest of " + interest + " added to your balance.");
            }
            
            System.out.println("Total balance in Bank B: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
            System.out.println("Remaining balance: " + balance);
        } else if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public double calculateInterest() {
        double interestRate = 0;
        if (balance >= 100000) {
            interestRate = FIXED_DEPOSIT_RATE; 
        } 
        else if(balance >= 20000 && balance < 100000) {
            interestRate = SAVINGS_RATE; 
        }
        else{
            interestRate = CHEQUING_RATE;
        }
        return balance * interestRate;
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        NRB bank = null;
        
        System.out.println("Welcome to the Banking System");
        
        // Select bank
        System.out.println("Choose the bank:");
        System.out.println("1. BankA");
        System.out.println("2. BankB");
        int bankChoice = sc.nextInt();
        
        
        if (bankChoice == 1) {
            bank = new BankA();
        } else if (bankChoice == 2) {
            bank = new BankB();
        } else {
            System.out.println("Invalid choice.");
            return;
        }
        
        
        System.out.println("Choose the account type (Chequing, Savings, Fixed Deposit):");
        String accountType = sc.nextLine();
        bank.openAccount(accountType);
        
        System.out.println("Enter the initial deposit amount:");
        double initialDeposit = sc.nextDouble();
        bank.deposit(initialDeposit);
        
        while (true) {
            // Menu
            System.out.println("Choose an operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Quit");
            
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Enter the amount to deposit:");
                    double depositAmount = sc.nextDouble();
                    bank.deposit(depositAmount);
                    break;

                case 2:
                    System.out.println("Enter the amount to withdraw:");
                    double withdrawAmount = sc.nextDouble();
                    bank.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.println("Exiting... Thank you for banking with us!");
                    System.exit(0);
                
                default:
                    System.out.println("Invalid operation. Please choose a valid option.");
            }
        }
    }
}