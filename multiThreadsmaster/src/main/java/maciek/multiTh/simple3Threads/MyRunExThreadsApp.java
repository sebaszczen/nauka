package maciek.multiTh.simple3Threads;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

import static maciek.multiTh.Consoler.ANSI_BLUE;
import static maciek.multiTh.Consoler.ANSI_RED;

public class MyRunExThreadsApp {

    public static void main(String[] args) {
        LocalDateTime stamp = LocalDateTime.now().withNano(0);
        System.out.println("Start time -> " + stamp);
        IntStream.range(0,10).forEach(t->{
            MyRunExThread my1 = null;
            if(t%2 == 0) {
                my1 = new MyRunExThread(ANSI_RED, t, stamp);
            } else {
                my1 = new MyRunExThread(ANSI_BLUE, t, stamp);
            }
            my1.start();
        });
        }
    }