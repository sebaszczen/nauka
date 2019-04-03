package maciek.multiTh.conc.copyOnWriteArrayList;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

public class ConcurentArrayList implements Runnable {

    private CopyOnWriteArrayList<Integer> list1 = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Integer> list2 = new CopyOnWriteArrayList<>();

    private Random random = new Random();

    @Override
    public void run() {

    }

    public void stageOne() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            //do your work here
            e.printStackTrace();
        }
        list1.add(random.nextInt(100));
    }

    public void stageTwo() {

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            //do your work here
            e.printStackTrace();
        }
        list2.add(random.nextInt(100));
    }

    public void proc() {
        IntStream.range(0, 1000).forEach(s -> {
            stageOne();
            stageTwo();
        });
    }

    public void main() {

        long start = System.currentTimeMillis();

        Runnable runnable = () -> {
            proc();
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start));
        System.out.println("List1: " + list1.size() + "; List2: " + list2.size());
    }
}
