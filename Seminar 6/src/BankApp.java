public class BankApp {
    public static void main(String[] args) {
        try {
            BankAccount account1 = new BankAccount("BA1001", "Maria Popescu", 1000);
            SavingsAccount account2 = new SavingsAccount("SA2001", "Ion Ionescu", 2000, 5);

            System.out.println("Initial accounts:");
            account1.displayInfo();
            System.out.println();

            account2.displayInfo();
            System.out.println();

            account1.deposit(500);
            account1.withdraw(300);

            account2.deposit(1000);
            account2.withdraw(700);
            account2.addInterest();

            System.out.println("After operations:");
            account1.displayInfo();
            System.out.println();

            account2.displayInfo();
            System.out.println();

            account1.withdraw(5000);

        } catch (InvalidAmountException e) {
            System.out.println("Invalid amount error: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Insufficient funds error: " + e.getMessage());
        }
    }
}