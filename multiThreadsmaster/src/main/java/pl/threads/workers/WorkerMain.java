package pl.threads.workers;

public class WorkerMain {
    public static void main(String[] args) {


        Thread t1 = new JavaWorker1("Worker1");
        Thread t2 = new Thread(new JavaWorker2(), "Worker2");
        Thread t3 = new Thread(new JavaWorker3().runnableJavaWorker3(), "Worker3");
        t1.start();
        t2.start();
        t3.start();
    }
}
