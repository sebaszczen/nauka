package maciek.pl.threads.synchrol1;

public class BalanceApp {
    public static void main(String[] args) {
        Balance b = new Balance();


        Thread[] threads = new Thread[100];

        for (int i = 0; i < 100; i++) {
            threads[i] = new BalanceThread("ThreadName->" + i, b);
        }
    }
}
