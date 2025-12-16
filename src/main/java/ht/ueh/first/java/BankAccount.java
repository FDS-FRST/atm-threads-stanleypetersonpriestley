package ht.ueh.first.java;

public class BankAccount {
    private final int acountNumber;
    private double balance;

    public BankAccount(double balance, int acountNumber) {
        this.balance = balance;
        this.acountNumber = acountNumber;
    }
}
