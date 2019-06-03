package maciek.pl.threads;

import maciek.pl.threads.myrun.VolatileTest;

public class VolatileTestApp {

    public static void main(String[] args) {

        VolatileTest v1 = new VolatileTest();
        v1.setX(99);
        v1.setY(-99);
        long vTestTimeForB = System.currentTimeMillis();
        v1.voatieSpeedTestFor(9000000);
        long vTestTimeForA = System.currentTimeMillis();
        long vTestTimeForE = vTestTimeForA-vTestTimeForB;
        System.out.println("voatieSpeedTestFor time ms: " + vTestTimeForE);
        long vTestTimeStremB = System.currentTimeMillis();
        v1.voatileSpeedTestStream(90000000);
        long vTestTimeStreamA = System.currentTimeMillis();
        long vTestTimeStreamE = vTestTimeForA-vTestTimeForB;
        System.out.println("voatileSpeedTestStream time ms: "  + vTestTimeStreamE);

        VolatileTest v2 = new VolatileTest();
        v2.setOldX(99);
        v2.setOldy(-99);
        long iTestTimeForB = System.currentTimeMillis();
        v2.intSpeedTestFor(90000000);
        long iTestTimeForA = System.currentTimeMillis();
        long iTestTimeForE = iTestTimeForA-iTestTimeForB;
        System.out.println("intSpeedTestFor ms: " + iTestTimeForE);
        long result = vTestTimeForE - iTestTimeForE;
        System.out.println("\033[31m int faster than volatile int ms: " + result +"\033[0m");

        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().availableProcessors())        ;
    }
}
