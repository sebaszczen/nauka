package pl.threads.workersynch;

public abstract class Message {

    abstract void message(String message);

    void print(String message) {
        System.out.print('[');
        System.out.print(Thread.currentThread().getName());
        System.out.print(']');
        System.out.print(message);
        System.out.println();
        System.out.flush();
    }
}
