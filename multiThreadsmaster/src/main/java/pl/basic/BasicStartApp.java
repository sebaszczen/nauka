package pl.basic;

import java.math.BigDecimal;

public class BasicStartApp {

    public static void main(String[] args) {
        String hello = "Witaj ";
        String world = "Świecie!";
        String powitanie = hello+world; //łączenie Stringów
        System.out.println(powitanie);

        String czesc = powitanie.substring(0,13) + " uczniu";
        System.out.println(czesc);
        BigDecimal bg = new BigDecimal("2341");

        System.out.println("ppierwiastek wielostopnkiowy " + cacl2(-146));

    }
    public static double cacl(int a, int b) {
        return Math.pow(a, b);
    }

    public static int cacl2(int a) {
        return Math.abs(a);
    }

    public static double pierwiastek(double elementNumber, double elementLevel) {
        return Math.pow(elementNumber, (1/elementLevel));
    }



}
