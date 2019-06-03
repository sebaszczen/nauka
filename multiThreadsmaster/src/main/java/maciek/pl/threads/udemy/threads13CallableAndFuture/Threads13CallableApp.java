package maciek.pl.threads.udemy.threads13CallableAndFuture;

import java.util.Random;
import java.util.concurrent.*;

public class Threads13CallableApp {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> futur = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                int dur = random.nextInt(2000);
                System.out.println("starting ");

                try {
                    Thread.sleep(dur);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("finished");
                return dur;
            }
        });

        executorService.shutdown();
        try {
            System.out.println("future gettt " + futur.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e);
        }
    }
}
