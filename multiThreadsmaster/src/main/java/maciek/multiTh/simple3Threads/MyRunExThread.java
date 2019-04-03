package maciek.multiTh.simple3Threads;

import java.time.LocalDateTime;

import static maciek.multiTh.Consoler.ANSI_RESET;

public class MyRunExThread extends Thread {

    private String asc;
    private int id;
    private LocalDateTime stamp;
    private boolean whiteFlag = true;

    public void setWhiteFlag(boolean whiteFlag) {
        this.whiteFlag = whiteFlag;
    }

    public MyRunExThread(String asc, int id, LocalDateTime stamp) {
        this.id = id;
        this.asc = asc;
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
            LocalDateTime now = LocalDateTime.now();
            if (now.isAfter(stamp.plusSeconds(5))) {
                setWhiteFlag(false);
                System.out.println(asc+"Thred is -> " + id + " stopped at: "  + now);
            }

        }
    }
}
