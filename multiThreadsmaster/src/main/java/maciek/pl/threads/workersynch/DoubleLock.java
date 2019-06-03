package maciek.pl.threads.workersynch;
/**
 * Przykładowa klasa realizująca podwójną blokadę
 * przy pomocy patenu Double Checked Locking
 */
public class DoubleLock {
    //
    // Instancja klasy
    // Słowo kluczowe volatile oznacza ze zawsze będzie odczytywana najświęzsza wersja
    //

    private volatile static DoubleLock instance;

    private DoubleLock() {
    }

    public static DoubleLock getInstance() {

        if (instance == null) {
            synchronized (DoubleLock.class) {
                if (instance == null) {
                    instance = new DoubleLock();
                }
            }
        }

        return instance;
    }
    public synchronized void print(){
        System.out.println("Caused by: " + Thread.currentThread().getName()+"\033[31m hash: "+ Integer.toHexString(hashCode()) + "\033[0m");
        System.out.flush();
    }
}
