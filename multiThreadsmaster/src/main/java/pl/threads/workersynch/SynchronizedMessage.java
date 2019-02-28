package pl.threads.workersynch;

public class SynchronizedMessage extends Message {

    @Override
    public synchronized void message(String message) {
        print("\033[32m" + message +   "\033[0m");
    }
}
