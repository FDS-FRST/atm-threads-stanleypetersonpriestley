package ht.ueh.first.java;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(1, 500);

        Thread t1 = new Thread(
                new ATMTask(account, ATMTask.Action.WITHDRAW, 300),
                "Client-1"
        );

        Thread t2 = new Thread(
                new ATMTask(account, ATMTask.Action.WITHDRAW, 1000),
                "Client-2"
        );

        Thread t3 = new Thread(
                new ATMTask(account, ATMTask.Action.DEPOSIT, -50),
                "Client-3"
        );

        Thread t4 = new Thread(
                new ATMTask(account, ATMTask.Action.BALANCE, 0),
                "Client-4"
        );

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
