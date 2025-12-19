package ht.ueh.first.java;

public class ATMTask  implements Runnable {
    public enum Action {DEPOSIT, WITHDRAW, BALANCE}
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
        String threadName = Thread.currentThread().getName();
        try {
                switch (action) {
                    case DEPOSIT:
                        account.deposit(amount);
                        break;
                        case WITHDRAW:
                            account.withdraw(amount);
                            break;
                            case BALANCE:
                                System.out.println("[" + threadName + "] Consultation : " + account.getBalance() + "$");
                                break;
                }
            }catch (InvalidAmountException | InsufficientFundsException e){
                System.err.println("Erreur[" + threadName + "] sur " + action + "de" + amount + "$ :" + e.getClass());
            }catch(Exception e){
                System.err.println("Erreur inattendue : " + e.getMessage());
            }
        }
    }
}
