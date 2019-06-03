package maciek.pl.threads;

import maciek.pl.threads.myrun.MyRunThreads2;

public class MyRunThreads2App {
    public static void main(String[] args) {
        MyRunThreads2 th1 = new MyRunThreads2();

        Thread t1 = new Thread(th1);
        Thread t2 = new Thread(th1);
//        Thread.currentThread().sleep(100);
        t1.start();
        t2.start();
    }
}
