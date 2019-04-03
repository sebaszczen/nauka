package maciek.pl.threads.myrun;

public class MyRunThreads2 implements Runnable {

    private volatile boolean end = false;

    @Override
    public void run() {
        while (!end) {
            System.out.println("NEW JAVA implements R");
        }
    }

    public void stopThread() {
        end = true;
    }
}
