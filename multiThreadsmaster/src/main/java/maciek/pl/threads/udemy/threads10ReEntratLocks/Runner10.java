package maciek.pl.threads.udemy.threads10ReEntratLocks;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Runner10 {

    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition con = lock.newCondition();

    private void increment() {
        IntStream.range(0, 10000).forEach(t -> count++);
    }

    public void fristT() throws InterruptedException {
        lock.lock();
        System.out.println("Thread 1 is waiting");
        con.await();
        System.out.println("Thread 1 woken up!");

        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void secondT() throws InterruptedException {
        Thread.sleep(1000);
        lock.lock();

        System.out.println("Press the enter key.");
        new Scanner(System.in).nextLine();
        System.out.println("got enter key");
        //dziiala tak jak notify czyli obudzi watek
        con.signal();

        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void finish() {
        System.out.println("conut is: " + count);
    }

}
