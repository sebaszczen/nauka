package seba.countdownLatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountDownLatchExperiment {

    public static void main(String[] args) throws InterruptedException {
        countDounLatch();

        CountDownLatch lock = new CountDownLatch(5);

//        scheduledThredPoolWithCountDownLAtch(lock);
    }

    private static void scheduledThredPoolWithCountDownLAtch(CountDownLatch lock) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        ScheduledFuture<?> future = executor.scheduleAtFixedRate(() -> {
            System.out.println("Hello World");
            lock.countDown();
        }, 500, 100, TimeUnit.MILLISECONDS);
        lock.await(1000, TimeUnit.MILLISECONDS);
        future.cancel(true);
    }

    private static void countDounLatch() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5000);
        List<String> list = Collections.synchronizedList(new ArrayList<>());
//        List<String> list = new ArrayList<>();
        List<Thread> collect = Stream.generate(() -> new Thread(new Car(countDownLatch, list)))
                .limit(5000).collect(Collectors.toList());
        collect.forEach(Thread::start);
        countDownLatch.await();
        System.out.println(list.size());
    }
}
