package ht.ueh.first.java;

public class Main {
    public static void main(String[] args) {
        // System.out.println("***Partie 1 :---");

        BankAccount sharedAccount = new BankAccount(101,1000);
        // account.deposit(100);
       // account.withdraw(200);
        Thread t1 = new Thread(new ATMTask(sharedAccount, ATMTask.Action.WITHDRAW, 700.0), "Client Valide");
        t1.start();
        Thread t2 = new Thread(new ATMTask(sharedAccount, ATMTask.Action.WITHDRAW, 500.0), "Client Pauvre");
        t2.start();
        Thread t3 = new Thread(new ATMTask(sharedAccount, ATMTask.Action.DEPOSIT, -50.0), "Client Erreur Montant");
        t3.start();
        Thread t4 = new Thread(new ATMTask(sharedAccount, ATMTask.Action.BALANCE, 0), "Client Consultation");
        t4.start();
            // System.out.println("Solde final attendu :" + account.getBalance() + "Gdes");
      try{
        t1.join(); t2.join(); t3.join(); t4.join();
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
    System.out.println("La simulation est terminee : " + sharedAccount.getBalance() + "$");
    }
}
