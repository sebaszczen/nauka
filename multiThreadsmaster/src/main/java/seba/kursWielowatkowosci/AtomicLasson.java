package seba.kursWielowatkowosci;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLasson {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    counter.incrementSafe();
                    counter.incrementUnsafe();
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("done");
        System.out.println("safe counter value: " + counter.atomicLong);
        System.out.println("unsafe counter value: " + counter.primitiveValue);
    }

    static class Counter {
        private long primitiveValue = 0;
        private AtomicLong atomicLong = new AtomicLong(0);

        private void incrementSafe() {
            atomicLong.incrementAndGet();
        }

        public void incrementUnsafe() {
            primitiveValue++;
        }

    }
}
