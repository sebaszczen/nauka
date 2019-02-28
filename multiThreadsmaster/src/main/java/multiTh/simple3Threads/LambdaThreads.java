package multiTh.simple3Threads;

import static multiTh.Consoler.*;

public class LambdaThreads {

    public static void main(String[] args) {

        Runnable r = () -> {
            int counter = 0;
            while (counter < 10) {
                System.out.println(ANSI_RED + "->runnable lambda thread<- " + ANSI_RESET);
                counter++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread rt = new Thread(r);

        Thread t = new Thread(() -> {
            int counter = 0;
            while (counter < 10) {
                System.out.println(ANSI_PURPLE + "->thread lambda thread<- " + ANSI_RESET);
                counter++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        rt.start();

//        try {
//            rt.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        t.start();
    }
}
