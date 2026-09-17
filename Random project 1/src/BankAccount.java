import java.io.*;
import java.util.*;

class BankAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account created.");
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposited: $" + amount);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("Withdrew: $" + amount);
            return true;
        }
        return false;
    }

    private void addTransaction(String detail) {
        transactionHistory.add(detail + " | Balance: $" + balance);
    }

    public void printHistory() {
        System.out.println("--- Transaction History ---");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
}

