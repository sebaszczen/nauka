package maciek.multiTh.conc.semaphore;

import java.util.concurrent.Semaphore;

public class Connection {

    private int connections = 0;
    private Semaphore sem = new Semaphore(10, true);
    private static Connection instance = new Connection();

    private Connection() {
    }

    public static Connection getInstance() {
        return instance;
    }

    public void connection() {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            doConnect();
        } finally {
            sem.release();
        }
    }

    public void doConnect() {

        synchronized (this) {
            connections++;
            System.out.println("Current connetions " + connections);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            connections--;
        }
    }
}

