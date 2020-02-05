package seba.complitableFutureLesson;

import com.sun.javafx.binding.StringFormatter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ComplitableFutureLesson{

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        zakonczenieCompletableFuture();
//        lancuchDzialan();
//        combining();
//        compose();
//        akceptujSzybszy();
//        akceptujOba();
//        wykonajWszystkie();
//        kiedyZakonczony();
        konsumpcjaWyjatku();
    }

    private static void konsumpcjaWyjatku() throws ExecutionException, InterruptedException {
        System.out.println("konsumpcja wyjatku");
        CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new IllegalArgumentException();
//            return 23L;
        });
        CompletableFuture<String> handle = completableFuture.handle(new BiFunction<Long, Throwable, String>() {
            @Override
            public String apply(Long aLong, Throwable throwable) {
                if (throwable == null) {
                    return "super wynik: " + aLong;
                } else {
                    return "ojjj wyjatek: "+throwable.getMessage();
                }
            }
        });
        System.out.println(handle.get());
    }

    private static void kiedyZakonczony() throws ExecutionException, InterruptedException {
        System.out.println("kiedy Zakonczony");
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hej haj";
        });
        completableFuture.whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) {
                System.out.println("response is: " + s);
                System.out.println("throwable is: " + throwable);
            }
        }).get();
    }

    private static void wykonajWszystkie() throws ExecutionException, InterruptedException {
        System.out.println("wykonaj wszystkie");
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 120;
        });
        CompletableFuture completableFuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        CompletableFuture completableFuture2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 300;
        });
        final CompletableFuture<Void> completableFuture3 = completableFuture.thenAcceptBoth(completableFuture1, new BiConsumer() {
            @Override
            public void accept(Object o, Object o2) {
                System.out.println("xasdfasdf");
            }
        });
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFuture, completableFuture1, completableFuture2);
        voidCompletableFuture.get();
    }

    private static void akceptujOba() throws ExecutionException, InterruptedException {
        System.out.println("akceptuj oba");
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 120;
        });
        CompletableFuture completableFuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        completableFuture.thenAcceptBoth(completableFuture1, (value1, value2) -> System.out.println(String.format("value1:%s value2:%s", value1, value2))).get();
    }

    private static void akceptujSzybszy() throws ExecutionException, InterruptedException {
        System.out.println("akceptuj szybszy");
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 120;
        });
        CompletableFuture completableFuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        CompletableFuture completableFuture2 = completableFuture.acceptEither(completableFuture1, x -> System.out.println(x));
        completableFuture2.get();
    }

    private static void compose() throws ExecutionException, InterruptedException {
        System.out.println("compose");
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " starting");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "finished");
            return "123";
        });
        CompletableFuture<String> stringCompletableFuture1 = stringCompletableFuture.thenCompose(new Function<String, CompletionStage<String>>() {
            @Override
            public CompletionStage<String> apply(String s) {
                return CompletableFuture.completedFuture("wynik to: " + s);
            }
        });
        System.out.println(stringCompletableFuture1.get());
    }

    private static void combining() throws ExecutionException, InterruptedException {
        System.out.println("combining");
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " starting");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "finished");
            return "123";
        });
        CompletableFuture<String> stringCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " computing");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "finished");
            return "xxx";
        });
        String s = stringCompletableFuture.thenCombine(stringCompletableFuture1, new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return s + s2;
            }
        }).get();
        System.out.println(s);

    }

    private static void lancuchDzialan() throws ExecutionException, InterruptedException {
        System.out.println("lancuch działan");
        System.out.println(Thread.currentThread().getName() + " starting hard work");
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " computing");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "123";
        });
        String s = stringCompletableFuture.get();
        System.out.println(" result: "+s);
        CompletableFuture<String> stringCompletableFuture1 = stringCompletableFuture.thenApply(value -> "result is: " + value);
        System.out.println("nowy wynik: "+stringCompletableFuture1.get());

    }

    private static void zakonczenieCompletableFuture() throws InterruptedException, ExecutionException {
        CompletableFuture completableFuture = new CompletableFuture();
        CompletableFuture<Integer> integerCompletableFuture = completableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()+ " start hard work");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finish work");
            return 123;
        });

        integerCompletableFuture.complete(11);
        System.out.println(integerCompletableFuture.get());
    }
}
