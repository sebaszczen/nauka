package seba.countdownLatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private CountDownLatch countDownLatch;
    private List<String> helloList;

    public Car(CountDownLatch countDownLatch, List helloList) {
        this.countDownLatch = countDownLatch;
        this.helloList = helloList;
    }

    @Override
    public void run() {
        helloList.add("hello");
        countDownLatch.countDown();
    }
}
