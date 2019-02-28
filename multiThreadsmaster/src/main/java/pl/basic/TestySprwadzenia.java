package pl.basic;

import java.util.concurrent.Callable;

public class TestySprwadzenia {

    public String[] methodB(Callable callable) throws Exception {
        return (String[]) callable.call();
    }

    public String[] methodA(String s, Integer i) throws Exception {
        return methodB(new Callable() {

            public String[] call() throws Exception {
                return new String[]{s + i.toString()};
            }
        });

    }

    public static void main(String[] args) throws Exception {
        TestySprwadzenia t = new TestySprwadzenia();
        t.methodA("5",7);
    }
}
