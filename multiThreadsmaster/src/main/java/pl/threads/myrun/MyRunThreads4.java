package pl.threads.myrun;

public class MyRunThreads4 implements Runnable {
    public static void main(String[] args) {

        MyRunThreads4 th1 = new MyRunThreads4();

        Thread t1 = new Thread(th1);

        Thread t2 = new Thread(th1);
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("NEW JAVA");
        }
    }
}



