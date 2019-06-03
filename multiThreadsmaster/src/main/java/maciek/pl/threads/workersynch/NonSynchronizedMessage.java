package maciek.pl.threads.workersynch;

public class NonSynchronizedMessage extends Message {

    @Override
    public void message(String message) {
        print("\033[34m" + message +   "\033[0m");
    }
}
