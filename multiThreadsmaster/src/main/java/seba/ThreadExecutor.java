package seba;

import org.apache.catalina.Executor;

import java.io.FileNotFoundException;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ThreadExecutor {
    static transient int x=0;
    static Integer integer=0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        IntStream.range(0, 10000).forEach(x->executorService.submit(()->{
//            System.out.println(Thread.currentThread().getName());
//            increase();
//        }));

        ExecutorService executorService1 = Executors.newFixedThreadPool(8);
//        IntStream.range(0, 10000).forEach(x->executorService1.submit(()->{
//            System.out.println(Thread.currentThread().getName());
//            increase2();
//        }));

        executorService.submit(() -> print());

//        CompletionService completionService = new ExecutorCompletionService(executorService);
//        long start = System.currentTimeMillis();
//        for (int i = 0; i <100000 ; i++) {
//         completionService.submit(()->{
//             System.out.println(Thread.currentThread().getName());
//            increase();
//             return x;
//         });
//        }
//        for (int i = 0; i <100000 ; i++) {
//            completionService.take().get();
//        }
//        System.out.println("czas: "+(System.currentTimeMillis()-start));

//        long start1 = System.currentTimeMillis();
//        for (int i = 0; i <1000 ; i++) {
//                System.out.println(Thread.currentThread().getName());
//                increase();
//        }
//        System.out.println("czas: "+(System.currentTimeMillis()-start1));
    }

    public static void print() {
        System.out.println(Thread.currentThread().getName());
        IntStream.range(0, 10).forEach(x->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("xxxxxxxxx");
        });
    }

    public static void increase() {
        x++;
        System.out.println("x wynosi: "+x);
    }

    public static void increase2() {
        x++;
        System.out.println("x wynosi: "+x);
    }
}
