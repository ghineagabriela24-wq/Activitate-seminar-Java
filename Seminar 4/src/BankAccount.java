public class BankAccount {
    private String accountNumber;
    private String ownerName;
    protected double balance;

    public BankAccount(String accountNumber, String ownerName, double balance) throws InvalidAmountException {
        if (balance < 0) {
            throw new InvalidAmountException("Initial balance cannot be negative.");
        }

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be greater than 0.");
        }

        balance += amount;
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be greater than 0.");
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Not enough money in the account.");
        }

        balance -= amount;
    }

    public void displayInfo() {
        System.out.println("Account number: " + accountNumber);
        System.out.println("Owner: " + ownerName);
        System.out.println("Balance: " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }
}