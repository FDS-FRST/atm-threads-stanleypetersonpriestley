package ht.ueh.first.java;

import ht.ueh.first.java.InsufficientFundsException;
import ht.ueh.first.java.InvalidAmountException;

public class BankAccount {

    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Montant invalide : " + amount);
        }
        balance += amount;
        System.out.println(Thread.currentThread().getName()
                + " | Dépôt : " + amount
                + " | Solde : " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Montant invalide : " + amount);
        }
        if (balance < amount) {
            throw new InsufficientFundsException("Fonds insuffisants");
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getName()
                + " | Retrait : " + amount
                + " | Solde : " + balance);
    }

    public synchronized double getBalance() {
        return balance;
    }
}
