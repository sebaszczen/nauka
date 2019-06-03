package maciek.pl.threads.workersynch;

public class DoubleLockApp {
    public static void main(String[] args) {

        DoubleLockWorkers worker = new DoubleLockWorkers("Worker1");
        DoubleLockWorkers worker2 = new DoubleLockWorkers("Worker2");
        DoubleLockWorkers worker3 = new DoubleLockWorkers("Worker3");

        worker.start();
        worker2.start();
        worker3.start();

        try {
            worker.join();
            worker2.join();
            worker3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

