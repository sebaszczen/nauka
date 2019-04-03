package maciek.multiTh.conc.executor;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ExecApp {

    public static void main(String[] args) {

        System.out.println("all task submitted.");
        long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 4);

        IntStream.range(0, 50).parallel().forEach(t -> {
            executor.submit(new ExecSlaveWorker(t));

        });
        executor.shutdown();
        try {
            executor.awaitTermination(2, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("all runnable tasks completed at the time: " + (System.currentTimeMillis() - start) + " ms");
    }
}
