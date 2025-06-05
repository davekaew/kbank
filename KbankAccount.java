package kbank;

public class KbankAccount {
    private String owner;
    private double balance;
    private static final double OVERDRAFT_LIMIT = -100;

    public KbankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance - amount < OVERDRAFT_LIMIT) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean transfer(KbankAccount recipient, double amount) {
        if (withdraw(amount)) {
            recipient.deposit(amount);
            return true;
        }
        return false;
    }
}
