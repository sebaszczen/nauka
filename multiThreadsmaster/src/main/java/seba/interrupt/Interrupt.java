package seba.interrupt;

import java.util.concurrent.Callable;

public class Interrupt {

    public static void main(String[] args) throws InterruptedException {
        Watek watek = new Watek();
        Thread thread = new Thread(watek);
        thread.start();
        Thread.sleep(10000);
        thread.interrupt();
    }

    static class Watek implements Runnable{

        @Override
        public void run() {
            while (!Thread.interrupted() ) {
                System.out.println("watek wywolany");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("interrapted exception, stopping my work");
                }

            }
        }
    }
}
