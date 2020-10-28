package seba.executorService;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExecutorService {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        AtomicInteger x= new AtomicInteger();
//        java.util.concurrent.ExecutorService executorService =  Executors.newFixedThreadPool(10);
//        Callable<String> callable=()-> {
//            Thread.sleep(10000);
//            System.out.println("callable1");
//            x.getAndIncrement();
//        return "any return "+x;
//
//        };
//        Callable<String> callable2=()-> {
//            System.out.println("callable2");
//            x.getAndIncrement();
//        return "any return 2 "+x;
//
//        };
//        Runnable runnable = () -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("hello");
//        };
//        execute(executorService,runnable);
//        submit(executorService,runnable);
//        invokeAny(executorService,callable);
//        invokeAll(executorService, callable,callable2);

        xx();
    }

    private static void xx() {
        System.out.println("metoda xxx");
        java.util.concurrent.ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<? extends Future<?>> collect = IntStream.range(0, 3).mapToObj(x -> {
            Future<?> submit = executorService.submit(() -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " tutej " + x);
            });
            return submit;
        }).collect(Collectors.toList());
        collect.stream().forEach(x -> {
            try {
                x.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        System.out.println("koniec");
    }


    private static void invokeAll(java.util.concurrent.ExecutorService executorService, Callable<String> callable, Callable<String> callable2) throws InterruptedException, ExecutionException {
        List<Callable<String>> collect = Stream.generate(() -> callable).limit(5).collect(Collectors.toList());
        List<Callable<String>> collect2 = Stream.generate(() -> callable2).limit(5).collect(Collectors.toList());
        collect.addAll(collect2);

        List<Future<String>> futures = executorService.invokeAll(collect);
        for (Future<String> future : futures) {
            String s = future.get();
            System.out.println(s);
        }

        //completion service dla porównania

        CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
        collect.forEach(completionService::submit);
        Future<String> take = completionService.take();
        System.out.println("tutaj: "+take.get());
    }

    private static void invokeAny(java.util.concurrent.ExecutorService executorService, Callable<String> callable) throws ExecutionException, InterruptedException {
        List<Callable<String>> collect = Stream.generate(() -> callable).limit(5).collect(Collectors.toList());
        System.out.println(collect.size());
        String s = executorService.invokeAny(collect);
        System.out.println(s);
    }

    private static void submit(java.util.concurrent.ExecutorService executorService, Runnable runnable) {
        Future<?> submit = executorService.submit(runnable);
        IntStream.range(1,5).forEach(x -> {
            Future<?> submit1 = executorService.submit(runnable);
            System.out.println("hejj");
            try {
                submit1.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    private static void execute(java.util.concurrent.ExecutorService executorService, Runnable runnable) {
        IntStream.range(0,5).forEach(x->executorService.execute(runnable));
    }
}
