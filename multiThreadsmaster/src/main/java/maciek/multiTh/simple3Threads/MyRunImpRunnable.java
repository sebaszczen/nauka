package maciek.multiTh.simple3Threads;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

import static maciek.multiTh.Consoler.ANSI_RESET;

public class MyRunImpRunnable implements Runnable {

    private String asc;
    private int id;
    private LocalDateTime stamp;
    private boolean whiteFlag = true;

    public void setWhiteFlag(boolean whiteFlag) {
        this.whiteFlag = whiteFlag;
    }

    public MyRunImpRunnable(String asc, int id, LocalDateTime stamp) {
        this.asc = asc;
        this.id = id;
        this.stamp = stamp;
    }

    @Override
    public void run() {

        while (whiteFlag) {
            System.out.println(asc + "Thread id -> " + id + ANSI_RESET + ", " + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LocalDateTime now = LocalDateTime.now().withNano(0);
            if (now.isAfter(stamp.plusSeconds(5))) {
                setWhiteFlag(false);
                System.out.println(asc + "Thred is -> " + id + " stopped at: " + now);
            }

        }
    }
}

