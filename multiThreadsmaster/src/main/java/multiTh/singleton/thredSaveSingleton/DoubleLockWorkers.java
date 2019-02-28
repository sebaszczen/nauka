package multiTh.singleton.thredSaveSingleton;

public class DoubleLockWorkers extends Thread {

    public DoubleLockWorkers(String name) {
        super(name);
    }

    @Override
    public void run() {
        final DoubleLock doubleLock = DoubleLock.getInstance();
        doubleLock.print();
    }
}
