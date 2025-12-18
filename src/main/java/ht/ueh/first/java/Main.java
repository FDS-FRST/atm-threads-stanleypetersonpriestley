package ht.ueh.first.java;

public class Main {
    public static void main(String[] args) {
        System.out.println("***Partie 1 :---");

        BankAccount account = new BankAccount(509, 6000);
        account.deposit(100);
        account.withdraw(200);

            System.out.println("Solde final attendu :" + account.getBalance() + "Gdes");
    }
}