package pl.threads;

import pl.threads.myrun.MyRunThreads;

/**
 * Hello world!
 */
public class MyRunThreadsApp {

    public static void main(String[] args) throws Exception {
        new MyRunThreadsApp();

        Runnable[] runnables = new Runnable[20];
        Thread[] threads = new Thread[20];

        for (int i = 0; i < 20; i++) {
            runnables[i] = new MyRunThreads(i);

        }

        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(runnables[i]);
        }

        for (int i = 0; i <20; i++) {
            threads[i].start();
            threads[i].join(5000);
        }

    }

}


