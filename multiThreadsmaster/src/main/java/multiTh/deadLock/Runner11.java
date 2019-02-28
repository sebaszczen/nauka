package multiTh.deadLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Runner11 {
    private Account accc1 = new Account();
    private Account accc2 = new Account();
    Random random;
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    //zamiana kolejności locków powoduje deadlocka :)
    //ponizej rozwiazanie temtu
    private void acquireLocks(Lock firstL, Lock secondL) throws InterruptedException {
        boolean gotFristLock = false;
        boolean gotSecondLock = false;
        while (true){
            //acquire locks
            try{
                gotFristLock = firstL.tryLock();
                gotSecondLock = secondL.tryLock();
            } finally {
                if(gotFristLock && gotSecondLock){
                    return;
                }

                if(gotFristLock) {
                    firstL.unlock();
                }

                if(gotSecondLock) {
                    secondL.unlock();
                }
            }
            //locks aquierd
            Thread.sleep(500);
        }
    }
//// stara wersja z blokującym sie lockiem
    public void fristT() throws InterruptedException {
        random = new Random();
        IntStream.range(0, 10000).forEach(t-> {
            lock1.lock();
            lock2.lock();
            try {
                Account.transfer(accc1,accc2,random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        });
    }
//public void fristT() throws InterruptedException {
//    random = new Random();
//    IntStream.range(0, 10000).forEach(t-> {
//        try {
//            acquireLocks(lock1,lock2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            Account.transfer(accc1,accc2,random.nextInt(100));
//        } finally {
//            lock1.unlock();
//            lock2.unlock();
//        }
//    });
//}

////stara wersja
    public void secondT() throws InterruptedException {
        random = new Random();
        IntStream.range(0, 10000).forEach(t->{
            lock2.lock();
            lock1.lock();
            try {
                Account.transfer(accc2,accc1,random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        });
    }

//    public void secondT() throws InterruptedException {
//        random = new Random();
//        IntStream.range(0, 10000).forEach(t->{
//            try {
//                acquireLocks(lock1,lock2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            try {
//                Account.transfer(accc2,accc1,random.nextInt(100));
//            } finally {
//                lock1.unlock();
//                lock2.unlock();
//            }
//        });
//    }


    public void finish() {
        System.out.println("Account 1 balance: " + accc1.getBalace());
        System.out.println("Account 2 balance: " + accc2.getBalace());
        System.out.println("Total balance: " + (accc2.getBalace()+accc1.getBalace()));
    }
}
