package pl.basic.dziedziczenie;

public class SubClass extends Programmer{

    SubClass(int x) {
        super(x);
        System.out.println("Subclass constructor " + x);
    }

    @Override
    public void jogging() {
        System.out.println("subclass is jogging");
    }

    @Override
    public void write() {
        System.out.println("sub class is writing");
    }
}
