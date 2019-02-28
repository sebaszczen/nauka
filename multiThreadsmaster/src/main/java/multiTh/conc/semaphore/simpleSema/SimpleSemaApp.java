package multiTh.conc.semaphore.simpleSema;

public class SimpleSemaApp {

    public static void main(String[] args) {
        SimpleSemaphore sm = new SimpleSemaphore();
        Thread relase = new Thread((sm::release));
        Thread take = new Thread((sm::take));

        relase.start();
        take.start();
        try {
            relase.join();
            take.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
