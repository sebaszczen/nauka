package multiTh.volatileExamples.speedVolatileTest;

import java.util.stream.IntStream;

public class VolatileTest {

    private volatile int volatileIntX;
    private volatile int volatileIntY;
    private int oldX;
    private int oldy;

    public void setVolatileIntX(int volatileIntX) {
        this.volatileIntX = volatileIntX;
    }

    public void setVolatileIntY(int volatileIntY) {
        this.volatileIntY = volatileIntY;
    }

    public void setOldX(int oldX) {
        this.oldX = oldX;
    }

    public void setOldy(int oldy) {
        this.oldy = oldy;
    }

    public void voatieSpeedTestFor(int t) {
        for (int i = 0; i < t; i++) {
            long xx = volatileIntX * t;
            long yy = volatileIntY * t;
        }
    }

    public void voatileSpeedTestStream(int t) {
        IntStream.range(0, t).forEach(s -> {
            long xx = volatileIntX * t;
            long yy = volatileIntY * t;
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
