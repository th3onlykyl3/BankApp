import java.io.*;

public class BankApp {
    private static final String DATA_FILE = "bank_data.ser";

    public static void main(String[] args) {
        BankAccount account = loadAccount();
        if (account == null) {
            account = new BankAccount("ACC1001", "Kyle Mmbo");
        }

        account.deposit(500.00);
        account.withdraw(150.00);
        account.printHistory();

        saveAccount(account);
    }

    private static void saveAccount(BankAccount account) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(account);
            System.out.println("Account state saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving account state: " + e.getMessage());
        }
    }

    private static BankAccount loadAccount() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            return (BankAccount) ois.readObject();
        } catch (Exception e) {
            System.out.println("No previous state found. Initializing new account.");
            return null;
        }
    }
}
