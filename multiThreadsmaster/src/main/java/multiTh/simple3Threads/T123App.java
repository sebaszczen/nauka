package multiTh.simple3Threads;

public class T123App  {
    public static void main(String[] args) {
        Runnable runnamle123 = new T123();
        Thread t1 = new Thread(runnamle123);
        Thread t2 = new Thread(runnamle123);
        Thread t3 = new Thread(runnamle123);
        t1.start();
        t2.start();
        t3.start();
    }
}
