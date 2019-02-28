package multiTh.volatileExamples.speedVolatileTest;

import pl.threads.myrun.VolatileTest;

public class VolatileTestApp {

    public static void main(String[] args) {

        int loop = 9000000;
        int x = 1999;
        int y = 29999;
        VolatileTest volatileTest = new VolatileTest();
        volatileTest.setX(x);
        volatileTest.setY(y);
        long vTestTimeForB = System.currentTimeMillis();
        volatileTest.voatieSpeedTestFor(loop);
        long vTestTimeForA = System.currentTimeMillis();
        long vTestTimeForE = vTestTimeForA-vTestTimeForB;
        System.out.println("voatieSpeedTestFor time ms: " + vTestTimeForE);

        long vTestTimeStremStart = System.currentTimeMillis();
        volatileTest.voatileSpeedTestStream(loop);
        long vTestTimeStreamEnd = System.currentTimeMillis();
        long vTestTimeStreamResult = vTestTimeStreamEnd-vTestTimeStremStart;
        System.out.println("voatileSpeedTestStream time ms: "  + vTestTimeStreamResult);

        System.out.println("##########################################");

        VolatileTest intTest = new VolatileTest();
        intTest.setOldX(x);
        intTest.setOldy(y);
        long iTestTimeForStat = System.currentTimeMillis();
        intTest.intSpeedTestFor(loop);
        long iTestTimeForEnd = System.currentTimeMillis();
        long iTestTimeForResult = iTestTimeForEnd-iTestTimeForStat;
        System.out.println("intSpeedTestFor ms: " + iTestTimeForResult);

        long iTestTimeStreamStart = System.currentTimeMillis();
        intTest.intSpeedTestStream(loop);
        long iTestTimeStreamEnd = System.currentTimeMillis();
        long iTestTimeStreamResult = iTestTimeStreamEnd-iTestTimeStreamStart;
        System.out.println("intSpeedTestStream ms: " + iTestTimeStreamResult);

        long result = vTestTimeForE - iTestTimeForResult;
        System.out.println("\033[31m int faster than volatile int ms: " + result +"\033[0m");

    }
}
