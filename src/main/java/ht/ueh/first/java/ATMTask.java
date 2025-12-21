package ht.ueh.first.java;

public class ATMTask implements Runnable {

    public enum Action {
        DEPOSIT, WITHDRAW, BALANCE
    }

    private BankAccount account;
    private Action action;
    private double amount;

    public ATMTask(BankAccount account, Action action, double amount) {
        this.account = account;
        this.action = action;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            switch (action) {
                case DEPOSIT -> account.deposit(amount);
                case WITHDRAW -> account.withdraw(amount);
                case BALANCE ->
                        System.out.println(Thread.currentThread().getName()
                                + " | Solde consulté : "
                                + account.getBalance());
            }
            Thread.sleep(300); // Simulation temps ATM
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName()
                    + " | Action : " + action
                    + " | Montant : " + amount
                    + " | Erreur : " + e.getMessage());
        }
    }
}
