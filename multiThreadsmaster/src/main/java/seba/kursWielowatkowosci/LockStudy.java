package seba.kursWielowatkowosci;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockStudy {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter("counter1");
        Counter counter2 = new Counter("counter2");
        Counter counter3 = new Counter("counter3");
        Counter counter4 = new Counter("counter4");
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("incerement1");
                for (int i = 0; i < 10000; i++) {
                    counter.inrement();
                }
            }
        };

        createThreads(counter, runnable);
        createThreads(counter2, ()-> {
            System.out.println("incerement2");
            for (int i = 0; i < 10000; i++) {
                counter2.inrement2();
            }
        });
        Lock lock = new ReentrantLock();
        createThreads(counter3, ()-> {
            System.out.println("incerement3");
            for (int i = 0; i < 5; i++) {
                counter3.inrement3(lock);
            }
        });

        createThreads(counter4, ()-> {
            System.out.println("incerement3");
            for (int i = 0; i < 5; i++) {
                counter4.inrement4(lock);
            }
        });
    }

    private static void createThreads(Counter counter, Runnable runnable) throws InterruptedException {
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("counter: "+counter.name+" done "+counter.howMany+" times");
    }

    static class Counter{

        String name;

        public Counter(String name) {
            this.name = name;
        }

        public int howMany;

        public int getHowMany() {
            return howMany;
        }

        public synchronized void inrement() {
            howMany++;
        }

        public void inrement2() {
            synchronized (this) {
                howMany++;
            }

        }

        public void inrement3(Lock lock) {
            try {
                lock.lock();
                Thread.sleep(1_000);
                howMany++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

        public void inrement4(Lock lock) {
            boolean b = lock.tryLock();
            if (b) {
                try {
                    Thread.sleep(1_000);
                    howMany++;
                }
            catch(InterruptedException e){
                e.printStackTrace();
            } finally{
                lock.unlock();
            }
        }
            else {
                System.out.println("sekcja krytyczna zajeta");
            }
        }
    }
}
