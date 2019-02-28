package pl.threads.workersynch;

public class WorkersApp {
    public static void main(String[] args) {
        System.out.println("Start not no nsynchronized methods");
        Workers worker1 = new Workers("NonSync1", "Hello", new NonSynchronizedMessage());
        Workers worker2 = new Workers("NonSync2", "World", new NonSynchronizedMessage());
        Workers worker3 = new Workers("NonSync3", "!!!!!", new NonSynchronizedMessage());

        worker1.start();
        worker2.start();
        worker3.start();

        try {
            worker1.join();
            worker2.join();
            worker3.join();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Start synchronized methods");

        Workers syncWorker = new Workers("Sync1", "Hello", new SynchronizedMessage());
        Workers syncWorker2 = new Workers("Sync2", "World", new SynchronizedMessage());
        Workers syncWorker3 = new Workers("Sync3", "!!!!!", new SynchronizedMessage());

        syncWorker.start();
        syncWorker2.start();
        syncWorker3.start();

        try {
            syncWorker.join();
            syncWorker2.join();
            syncWorker3.join();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Start block synchronized block");

        Workers blockSyncWorker = new Workers("BlockSync1", "Hello", new BlockSynchronizedMessage());
        Workers blockSyncWorker2 = new Workers("BlockSync2", "World", new BlockSynchronizedMessage());
        Workers blockSyncWorker3 = new Workers("BlockSync3", "!!!!!", new BlockSynchronizedMessage());

        blockSyncWorker.start();
        blockSyncWorker2.start();
        blockSyncWorker3.start();

        try {
            blockSyncWorker.join();
            blockSyncWorker2.join();
            blockSyncWorker3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
