package seba.locki;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocki {

    public static void main(String[] args) throws InterruptedException {
        ItemCounter itemCounter = new ItemCounter();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        itemCounter.insert(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable read = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    itemCounter.read();
                }
            }
        };
        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(read);
        Thread thread2 = new Thread(read);
        thread.start();
        thread1.start();
        thread2.start();
        thread.join();
        thread1.join();
        thread2.join();
    }

    static class ItemCounter {
        private Map<String, Integer> items = new HashMap<>();
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        private void insert(Integer number) throws InterruptedException {
            ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
            System.out.println("watek: "+ Thread.currentThread().getName()+ " try get write lock");
            writeLock.lock();
            try {
                System.out.println("watek: " + Thread.currentThread().getName() + " get write lock");
                items.put("pomidory", number);
                System.out.println("watek: " + Thread.currentThread().getName() + " put pomidory");

            } finally {
                System.out.println("watek: " + Thread.currentThread().getName() + " odblokowal write lock");
                writeLock.unlock();
            }
        }

        private Integer read() {
            ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
            System.out.println("watek: "+ Thread.currentThread().getName()+ " try get read lock");
            readLock.lock();
            try {
                System.out.println("watek: " + Thread.currentThread().getName() + " get read lock");
                return items.get("pomidory");
            }
            finally {
                System.out.println("watek: " + Thread.currentThread().getName() + " odblokowal read lock");
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                readLock.unlock();
            }
        }
    }

}
