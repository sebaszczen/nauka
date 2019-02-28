package pl.threads.testy;


import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

public class CallableCall {

    static class MyResource1 implements AutoCloseable {
        public void close() throws IOException {
            System.out.print("1 ");
        }
    }

    static class MyResource2 implements Closeable {
        public void close() throws IOException {

        }
    }

    public static void main(String[] args) {
        try (Stream<Path> st1 = Files.find(Paths.get("/report"), 2, (p, a) ->
                p.toString().endsWith("txt"));
             Stream<Path> st2 = Files.walk(Paths.get("/report"), 2);) {
            st1.forEach(s -> System.out.println("Found: " + s));
            st2.filter(s -> s.toString()
                    .endsWith("txt"))
                    .forEach(s -> System.out.println("Walked: " + s));
        } catch (IOException ioe) {
            System.out.println("Exception");
        }

    }


    public String[] methodB(Callable callable) throws Exception {
        return (String[]) callable.call();
    }

    public String[] methodA(String s, Integer i) throws Exception {
        return methodB(new Callable() {
            public String[] call() throws Exception {
                return new String[]{s + i.toString()};
            }
        });
    }
}

