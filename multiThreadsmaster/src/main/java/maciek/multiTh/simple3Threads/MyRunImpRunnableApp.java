package maciek.multiTh.simple3Threads;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

import static maciek.multiTh.Consoler.*;

public class MyRunImpRunnableApp {

    public static void main(String[] args) {
        LocalDateTime stamp = LocalDateTime.now().withNano(0);
        System.out.println("Start time -> " + stamp);
        IntStream.range(0,10).forEach(t->{
            MyRunImpRunnable impRunnable = null;
            if(t%2 == 0) {
                impRunnable = new MyRunImpRunnable(ANSI_GREEN, t, stamp);
            } else {
                impRunnable = new MyRunImpRunnable(ANSI_CYAN, t, stamp);
            }
            Thread t1 = new Thread(impRunnable);
            t1.start();
        });
    }
}
