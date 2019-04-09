package seba.listeningExecutorService;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudyListeningExecutorService {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        listeningExecutorService();

    }

    private static void listeningExecutorService() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executorService);
        ListenableFuture<String> submit = listeningExecutorService.submit(() -> "hello world");
        ListenableFuture<String> submit1 = listeningExecutorService.submit(() -> "co u cb");
        String collect1 = Futures.allAsList(submit, submit1).get().stream().collect(Collectors.joining(" "));
        System.out.println(collect1);
    }
}
