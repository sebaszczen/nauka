package multiTh.conc.semaphore.simpleSema;

public class SimpleSemaphore {
    private boolean signal = false;

    public synchronized void take() {
        System.out.println("TAKE");
        this.signal = true;
        this.notify();
    }

    public synchronized  void release() {
        while (!this.signal) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("RELEASE");
        this.signal=false;
    }
}
