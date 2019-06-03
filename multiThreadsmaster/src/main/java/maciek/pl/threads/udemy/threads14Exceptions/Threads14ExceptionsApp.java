package maciek.pl.threads.udemy.threads14Exceptions;

import java.util.Random;
import java.util.stream.IntStream;

public class Threads14ExceptionsApp {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("T1 starting...");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Random ran = new Random();
                int bound = (int) 1E8;
                for (int t = 0; t < 100000; t++) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted!");
                        break;
                    }
                    Math.sin(ran.nextDouble());
                }
            }
        });

        t1.start();
        Thread.sleep(500);
        t1.join();
        System.out.println("finisih");
    }
}
