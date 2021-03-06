package sebaszczen.completableFuture.completableFutureVsParallelStream;

import java.util.List;
import java.util.concurrent.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class CompletableFutureVsParallerStream {
    private static final Logger LOGGER = LogManager.getLogger(String.valueOf(CompletableFuture.class));

    private static List<MyTask> tasks = IntStream.range(0, 10)
            .mapToObj(i -> new MyTask(1))
            .collect(toList());

    public static void main(String[] args) {
        completableFuture();
        oneThread();
        parallelThread();
        List<Integer> collect = completableFuture().stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println("completable future "+collect);
        completableFutureWithExecutorService();
    }

    private static void oneThread() {
        LOGGER.info("oneThread");

        long start = System.nanoTime();
        List<Integer> result = tasks.stream()
                .map(MyTask::calculate)
                .collect(toList());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.printf("Processed %d tasks in %d millis\n", tasks.size(), duration);
        System.out.println(result);
    }

    private static void parallelThread() {
        LOGGER.info("parallelThread");

        long start = System.nanoTime();
        List<Integer> list = tasks.stream().parallel().map(MyTask::calculate).collect(Collectors.toList());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.printf("Processed %d tasks in %d millis\n", tasks.size(), duration);
        System.out.println(list);
    }

    private static void parallelThreadFixedThredPool() {
        LOGGER.info("parallelThread");

        ExecutorService executorService = Executors.newFixedThreadPool(8);
        ForkJoinPool forkJoinPool = new ForkJoinPool(8);

        long start = System.nanoTime();
        Future<List<Integer>> submit = executorService.submit(() -> tasks.parallelStream().map(t -> t.calculate()).collect(Collectors.toList()));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.printf("Processed %d tasks in %d millis\n", tasks.size(), duration);
//        System.out.println(list);
    }

    private static List<CompletableFuture<Integer>> completableFuture() {
        LOGGER.info("completableFuture");

        long start = System.nanoTime();
        List<CompletableFuture<Integer>> collect = tasks.stream().
                map(t -> CompletableFuture.supplyAsync(() -> t.calculate())).collect(Collectors.toList());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.printf("Processed %d tasks in %d millis\n", tasks.size(), duration);

        List<Integer> collect2 = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println("completable future "+collect2);
//        System.out.println(collect);
        return collect;
    }

    private static void completableFutureWithExecutorService() {
        LOGGER.info("completableFutureWithExecutorService");
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        long start = System.nanoTime();
        List<CompletableFuture<Void>> collect = tasks.stream().map(a -> CompletableFuture.runAsync(() -> a.calculate(), executorService)).collect(Collectors.toList());
        List<Void> list = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.printf("Processed %d tasks in %d millis\n", tasks.size(), duration);
    }
}
