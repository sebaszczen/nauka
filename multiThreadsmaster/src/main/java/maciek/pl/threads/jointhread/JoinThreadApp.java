package maciek.pl.threads.jointhread;

import java.util.stream.IntStream;

public class JoinThreadApp {
    private int count=0;


    public static void main(String[] args) {
        JoinThreadApp j = new JoinThreadApp();
        j.doIt();

    }

    public  void doIt() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                IntStream.range(0,10000).forEach(t-> count++);
            }
        });

        Runnable runnable = ()-> {
            IntStream.range(0,10000).forEach(t-> count++);
        };

       Thread t2 = new Thread(runnable);

       t1.start();
       t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Cout result: " + count);
    }

}
