package pl.threads.workers;

import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class JavaWorker2 implements Runnable {

    @Override
    public void run() {
        IntStream.range(0,1000).forEach(e-> {
            System.out.println("\033[32m JavaWorker 2 running .. " + currentThread().getName() + "\033[0m");
            try {
                sleep(550);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });
    }
}
