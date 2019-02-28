package multiTh.conc.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class LatchesApp {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        System.out.println("Lacze nowe świeżo utworzone -> " + latch.getCount());

        IntStream.range(0,3).forEach(t->{
            executorService.submit(new LatchesProcessor(latch));
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //wait czeka z głównym wątkiem tj poniższym sysoutem zanim nie skońcżą się wczesniejsze 4
        System.out.println("Latched threads completed ");
        System.out.println("I po laczach -> " + latch.getCount());
    }

}
