package maciek.pl.basic.dziedziczenie;

public class dApp {
    public static void main(String[] args) {
        Writer p = new Programmer(11);
//        Writer sub = new SubClass(112);

        Writer a = new Author();
//        p.write();
//        a.write();
        System.out.println();

        Writer s = new SubClass(2);
        s.jogging();
        s.write();

    }
}
