package maciek.multiTh.simple3Threads;

import gherkin.lexer.Ru;

import java.util.concurrent.atomic.AtomicInteger;

public class T123 implements Runnable {

    int value1 = 0;


    @Override
    public void run() {

        value1 = value1+1;
        System.out.println("int-> " + value1);
    }
}
