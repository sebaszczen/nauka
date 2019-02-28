package pl.threads.udemy.threads5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class App {

    public static void main(String[] args) {

        System.out.println("all task submitted.");
        ExecutorService executor = Executors.newFixedThreadPool(10);
        IntStream.range(0,40).forEach(t-> {
            executor.submit(new Processor(t));
        });


        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("all tasks completed");

    }
}
