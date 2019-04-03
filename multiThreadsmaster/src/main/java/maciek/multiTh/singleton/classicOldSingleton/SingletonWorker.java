package maciek.multiTh.singleton.classicOldSingleton;

public class SingletonWorker extends Thread {

    public SingletonWorker(String name) {
        super(name);
    }

    @Override
    public void run() {
        final SingletonSimpleOld singletonSimpleOld = SingletonSimpleOld.getInstance();
        singletonSimpleOld.print();
    }
}
