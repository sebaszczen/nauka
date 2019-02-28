package multiTh.singleton.classicOldSingleton;

public class SingletonSimpleOld {

    private static SingletonSimpleOld instance;

    private SingletonSimpleOld() {
    }

    public static SingletonSimpleOld getInstance() {
        if(instance==null) {
            instance = new SingletonSimpleOld();
        }
        return instance;
    }

    public void print() {
        System.out.println("Caused by: " + Thread.currentThread().getName()+"\033[31m SingletonOld hash: "+ Integer.toHexString(hashCode()) + "\033[0m");
    }
}
