package ht.ueh.first.java;

public class BankAccount {
    private final int acountNumber;
    private double balance;

    public BankAccount(double balance, int acountNumber) {
        this.balance = balance;
        this.acountNumber = acountNumber;
     System.out.println("Mon Compte :" + acountNumber + "Avec le Solde:" + balance + "Gdes");
    }
    public void deposit(double amount) {
        System.out.println(Thread.currentThread().getName() + "Mon depot" + amount + "Gdes");
        System.out.println(Thread.currentThread().getName() + "Mon Nouveau Solde" + balance + "Gdes");
     balance += amount;
    }

    public void withdraw(double amount) {
        System.out.println(Thread.currentThread().getName() + "Mon Retrait" + amount + "Gdes");
    double currentBalance = balance;
    if  (currentBalance >= amount) {

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + "Mon Retrait" + amount + "Gdes OK. Solde restant :" + balance + "Gdes");
    }else {
        System.out.println(Thread.currentThread().getName() + "Retrait echoue: Solde insuffisant" + currentBalance + "Gdes");
    }
    }
    public double getBalance() {
        System.out.println(Thread.currentThread().getName() + "Solde Actuel : " + balance + "Gdes");
        return balance;
    }

    public int getAcountNumber() {
        return acountNumber;
    }
}
class InvalidAccountException extends Exception {
    public InvalidAccountException(String message) {
        super(message);
    }
}
class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}
