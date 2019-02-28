package pl.threads.udemy.threads11Deadlock;

import pl.threads.udemy.threads10ReEntratLocks.Runner10;

public class Runnerr11App {

    public static void main(String[] args) throws InterruptedException {
        Runner11 r11 = new Runner11();

//        Runnable run = ()-> r10.fristT();

        Thread t1 = new Thread(() -> {
            try {
                r11.fristT();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    r11.secondT();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        r11.finish();
    }
}
