package maciek.multiTh.singleton.classicOldSingleton;

public class SingletonSimpleOldApp {

    public static void main(String[] args) {


        SingletonWorker s1 = new SingletonWorker("Simple Worker1");
        SingletonWorker s2 = new SingletonWorker("Simple Worker2");
        SingletonWorker s3 = new SingletonWorker("Simple Worker3");

        s1.start();
        s2.start();
        s3.start();

        try {
            s1.join();
            s2.join();
            s3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
