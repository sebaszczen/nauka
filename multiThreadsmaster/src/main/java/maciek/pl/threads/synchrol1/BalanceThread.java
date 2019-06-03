package maciek.pl.threads.synchrol1;

import java.awt.*;

public class BalanceThread extends Thread {

    private Balance balance;

    public BalanceThread(String name, Balance balance) {
        super(name);
        this.balance = balance;
        start();
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        int resut = 0;
        for (int i = 0; i < 1000; i++) {
            // można tez metodę synchronizować.
            synchronized (balance) {
                resut = balance.balanceNumbers();
                if (resut != 0) {
                    System.out.println("result 0 nie rowna sie 0 -> " + resut + " runda:" + i + ", " + getName());
                } else {
                    System.out.println("result wywolany -> " + resut + " runda:" + i + ", " + getName());
                }
            }
        }
        System.out.println("time: " + (System.currentTimeMillis()-start));
    }
}
