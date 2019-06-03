package maciek.pl.threads.workersynch;

public class BlockSynchronizedMessage extends Message{

    @Override
    public void message(String message) {
        synchronized (this) {
            print("\033[31m" + message  +  "\033[0m");
        }
    }
}
