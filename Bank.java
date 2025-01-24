import java.util.*;

interface NRB {
    String countryCode = "977"; 
    String extensionLine = "NP"; 
    void openAccount(String accountType, String customerName, double initialDeposit);

    void deposit(String accountNumber, double amount);

    void withdraw(String accountNumber, double amount);

    void calculateInterest(String accountNumber);

    void customerDetails(String accountNumber);

    void showAllCustomers();
}

class EVEREST implements NRB {
    private final double CHEQUING_INTEREST_RATE = 0.02;
    private final double SAVINGS_INTEREST_RATE = 0.04;
    private final double FIXED_DEPOSIT_INTEREST_RATE = 0.06;

    private static class Account {
        String accountNumber;
        String customerName;
        String accountType;
        double balance;

        Account(String accountNumber, String customerName, String accountType, double balance) {
            this.accountNumber = accountNumber;
            this.customerName = customerName;
            this.accountType = accountType;
            this.balance = balance;
        }
    }

    private final ArrayList<Account> accounts = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public void openAccount(String accountType, String customerName, double initialDeposit) {
        if (initialDeposit <= 0) {
            System.out.println("Initial deposit must be positive.");
            return;
        }
        String accountNumber = countryCode + random.nextInt(100000) + extensionLine;
        accounts.add(new Account(accountNumber, customerName, accountType, initialDeposit));
        System.out.println("Account successfully opened for " + customerName + " in EVEREST BANK");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Initial Deposit: " + initialDeposit);
    }

    private Account findAccount(String accountNumber) {
        
        for (Account account : accounts) {
            if (account.accountNumber.equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            if (amount > 0) {
                account.balance += amount;
                System.out.println("Deposited: " + amount + " into account " + accountNumber);
                System.out.println("New Balance: " + account.balance);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            if (amount > 0 && amount <= account.balance) {
                account.balance -= amount;
                System.out.println("Withdrew: " + amount + " from account " + accountNumber);
                System.out.println("New Balance: " + account.balance);
            } else {
                System.out.println("Invalid withdrawal amount or insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    @Override
    public void calculateInterest(String accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            double interestRate;
            switch (account.accountType.toLowerCase()) {
                case "chequing":
                    interestRate = CHEQUING_INTEREST_RATE;
                    break;
                case "savings":
                    interestRate = SAVINGS_INTEREST_RATE;
                    break;
                case "fixed":
                    interestRate = FIXED_DEPOSIT_INTEREST_RATE;
                    break;
                default:
                    System.out.println("Unknown account type.");
                    return;
            }
            double interest = account.balance * interestRate;
            account.balance += interest;
            System.out.println("Interest of " + interest + " added to account " + accountNumber);
            System.out.println("New Balance: " + account.balance);
        } else {
            System.out.println("Account not found.");
        }
    }

    @Override
    public void customerDetails(String accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("Customer Name: " + account.customerName);
            System.out.println("Account Number: " + account.accountNumber);
            System.out.println("Account Type: " + account.accountType);
            System.out.println("Balance: " + account.balance);
        } else {
            System.out.println("Account not found.");
        }
    }

    @Override
    public void showAllCustomers() {
        if (accounts.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("List of Customers:");
            for (Account account : accounts) {
                System.out.println("Name: " + account.customerName + ", Account Number: " + account.accountNumber
                        + ", Balance: " + account.balance);
            }
        }
    }


}

class NABIL implements NRB {
    private final double CHEQUING_INTEREST_RATE = 0.03;
    private final double SAVINGS_INTEREST_RATE = 0.05;
    private final double FIXED_DEPOSIT_INTEREST_RATE = 0.07;

    private static class Account {
        String accountNumber;
        String customerName;
        String accountType;
        double balance;

        Account(String accountNumber, String customerName, String accountType, double balance) {
            this.accountNumber = accountNumber;
            this.customerName = customerName;
            this.accountType = accountType;
            this.balance = balance;
        }
    }

    private final ArrayList<Account> accounts = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public void openAccount(String accountType, String customerName, double initialDeposit) {
        if (initialDeposit <= 0) {
            System.out.println("Initial deposit must be positive.");
            return;
        }
        String accountNumber = countryCode + random.nextInt(100000) + extensionLine;
        accounts.add(new Account(accountNumber, customerName, accountType, initialDeposit));
        System.out.println("Account successfully opened for " + customerName + " in NABIL BANK");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Initial Deposit: " + initialDeposit);
    }

    private Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.accountNumber.equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        
        if (account != null) {
            if (amount > 0) {
                account.balance += amount;
                System.out.println("Deposited: " + amount + " into account " + accountNumber);
                System.out.println("New Balance: " + account.balance);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            if (amount > 0 && amount <= account.balance) {
                account.balance -= amount;
                System.out.println("Withdrew: " + amount + " from account " + accountNumber);
                System.out.println("New Balance: " + account.balance);
            } else {
                System.out.println("Invalid withdrawal amount or insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    @Override
    public void calculateInterest(String accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            double interestRate;
            switch (account.accountType.toLowerCase()) {
                case "chequing":
                    interestRate = CHEQUING_INTEREST_RATE;
                    break;
                case "savings":
                    interestRate = SAVINGS_INTEREST_RATE;
                    break;
                case "fixed":
                    interestRate = FIXED_DEPOSIT_INTEREST_RATE;
                    break;
                default:
                    System.out.println("Unknown account type.");
                    return;
            }
            double interest = account.balance * interestRate;
            account.balance += interest;
            System.out.println("Interest of " + interest + " added to account " + accountNumber);
            System.out.println("New Balance: " + account.balance);
        } else {
            System.out.println("Account not found.");
        }
    }

    @Override
    public void customerDetails(String accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("Customer Name: " + account.customerName);
            System.out.println("Account Number: " + account.accountNumber);
            System.out.println("Account Type: " + account.accountType);
            System.out.println("Balance: " + account.balance);
        } else {
            System.out.println("Account not found.");
        }
    }

    @Override
    public void showAllCustomers() {
        if (accounts.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("List of Customers:");
            for (Account account : accounts) {
                System.out.println("Name: " + account.customerName + ", Account Number: " + account.accountNumber
                        + ", Balance: " + account.balance);
            }
        }
    }


}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NRB bank = null;
        
        System.out.println("Welcome to the Banking System");
        
        // Select bank
        System.out.println("Choose the bank:");
        System.out.println("1. EVEREST BANK LIMITED");
        System.out.println("2. NABIL BANK LIMITED");
        int bankChoice = sc.nextInt();
        sc.nextLine(); // Consume newline after integer input
        
        if (bankChoice == 1) {
            bank = new EVEREST();
        } else if (bankChoice == 2) {
            bank = new NABIL();
        } else {
            System.out.println("Invalid choice.");
            return;
        }
        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Calculate Interest");
            System.out.println("5. Customer Details");
            System.out.println("6. Show All Customers");
            System.out.println("7. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume leftover newline

            switch (choice) {
                case 1:
                    System.out.println("Enter customer name:");
                    String name = sc.nextLine();
                    System.out.println("Enter account type (Chequing/Savings/Fixed Deposit):");
                    String type = sc.nextLine();
                    System.out.println("Enter initial deposit amount:");
                    double initialDeposit = sc.nextDouble();
                    bank.openAccount(type, name, initialDeposit);
                    break;

                case 2:
                    System.out.println("Enter account number:");
                    String depositAccount = sc.next();
                    System.out.println("Enter deposit amount:");
                    double depositAmount = sc.nextDouble();
                    bank.deposit(depositAccount, depositAmount);
                    break;

                case 3:
                    System.out.println("Enter account number:");
                    String withdrawAccount = sc.next();
                    System.out.println("Enter withdrawal amount:");
                    double withdrawAmount = sc.nextDouble();
                    bank.withdraw(withdrawAccount, withdrawAmount);
                    break;

                case 4:
                    System.out.println("Enter account number:");
                    String interestAccount = sc.next();
                    bank.calculateInterest(interestAccount);
                    break;

                case 5:
                    System.out.println("Enter account number:");
                    String detailAccount = sc.next();
                    bank.customerDetails(detailAccount);
                    break;

                case 6:
                    bank.showAllCustomers();
                    break;

                case 7:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
