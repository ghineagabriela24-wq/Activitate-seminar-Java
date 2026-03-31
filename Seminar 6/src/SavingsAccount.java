public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) throws InvalidAmountException {
        super(accountNumber, ownerName, balance);

        if (interestRate < 0) {
            throw new InvalidAmountException("Interest rate cannot be negative.");
        }

        this.interestRate = interestRate;
    }

    public void addInterest() {
        balance += balance * interestRate / 100;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Interest rate: " + interestRate + "%");
    }

    public double getInterestRate() {
        return interestRate;
    }
}