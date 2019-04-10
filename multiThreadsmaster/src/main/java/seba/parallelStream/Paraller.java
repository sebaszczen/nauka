package seba.parallelStream;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Paraller {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        plainParallel();
        parallerWithForkJoinPool();
    }

    private static void parallerWithForkJoinPool() throws ExecutionException, InterruptedException {
        List<Integer> collect = IntStream.range(0, 22).boxed().collect(Collectors.toList());
        ForkJoinPool forkJoinPool = new ForkJoinPool(3);
        ForkJoinTask<?> submit = forkJoinPool.submit(() ->
            collect.parallelStream().forEach(x -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(x + " watek: " + Thread.currentThread().getId());
                    }
            ));
        submit.get();
    }

    private static void plainParallel() {
        Stream<Integer> boxed = IntStream.range(0, 22).boxed();
        boxed.parallel().forEach(x-> System.out.println(x+" watek: "+Thread.currentThread().getId()));
    }
}
