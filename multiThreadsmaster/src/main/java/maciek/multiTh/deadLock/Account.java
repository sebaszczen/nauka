package maciek.multiTh.deadLock;

public class Account {
    private  int balance = 10000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void widhdraw(int amount) {
        balance-=amount;
    }

    public int getBalace() {
        return balance;
    }

    public static void transfer (Account acc1, Account acc2, int amount) {
        acc1.widhdraw(amount);
        acc2.deposit(amount);
    }
}
