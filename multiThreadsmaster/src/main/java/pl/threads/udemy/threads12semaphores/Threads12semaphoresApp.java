package pl.threads.udemy.threads12semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Threads12semaphoresApp {

    public static void main(String[] args) throws  Exception{



        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i =0; i < 200; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    Connection.getInstance().connection();
                }

            });


        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}
