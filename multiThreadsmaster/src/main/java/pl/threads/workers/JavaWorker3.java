package pl.threads.workers;

import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class JavaWorker3 {

    public Runnable runnableJavaWorker3() {
        Runnable javaWorker3 = () -> {
            IntStream.range(0, 1000).forEach(e3 -> {
                System.out.println("\033[34m JavaWorker 2 running .. " + currentThread().getName() + "\033[0m");
                try {
                    sleep(550);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        };
        return javaWorker3;
    }
}
