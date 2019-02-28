package pl.Bundle;

public class ResoourceBundleTestApp {
    public static void main(String[] args) {
        ResoourceBundleTest r = new ResoourceBundleTest();
        System.out.println(r.getString("good") + r.getContents().length);
    }
}
