package pl.threads.myrun;

import java.util.stream.IntStream;

public class VolatileTest {

    private volatile int x;
    private volatile int y;
    private int oldX;
    private int oldy;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setOldX(int oldX) {
        this.oldX = oldX;
    }

    public void setOldy(int oldy) {
        this.oldy = oldy;
    }

    public void voatieSpeedTestFor(int t) {
        for (int i = 0; i < t; i++) {
            long xx = x * t;
            long yy = y * t;
        }
    }

    public void voatileSpeedTestStream(int t) {
        IntStream.range(0, t).forEach(s -> {
            long xx = x * t;
            long yy = y * t;
        });
    }

    public void intSpeedTestFor(int t) {
        for (int i = 0; i < t; i++) {
            long xx = oldX * t;
            long yy = oldy * t;
        }
    }

    public void intSpeedTestStream(int t) {
        IntStream.range(0, t).forEach(s -> {
            long result1 = oldX * t;
            long result2 = oldy * t;
        });
    }


}
