package maciek.multiTh.conc.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class LatchesProcessor implements Runnable {
    private CountDownLatch latch;

    public  LatchesProcessor(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("LatchesProcessor threads started ");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }
}
