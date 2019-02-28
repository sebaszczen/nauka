package multiTh.synchro.synchro;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class SynchroSpeedT implements Callable {

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();
    private Vector<Integer> v1 = new Vector<>();
    private Vector<Integer> v2 = new Vector<>();

    private Random random = new Random();

    @Override
    public Object call() throws Exception {
        return null;
    }
//
//    public void process() {
//        for (int i = 0; i < 1000; i++) {
//        stageOne();
//        stageTwo();
//    }
//}

    public synchronized void stageOne() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            //do your work here
            e.printStackTrace();
        }
        list1.add(random.nextInt(100));
    }

    public synchronized void stageTwo() {

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

    public void vStageOne() {
        //        synchronized (lock2) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            //do your work here
            e.printStackTrace();
        }
        v1.add(random.nextInt(100));
//        }
    }

    public void vStageTwo() {
        //        synchronized (lock2) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            //do your work here
            e.printStackTrace();
        }
        v2.add(random.nextInt(100));
//        }
    }

    public void vProc() {
        IntStream.range(0, 1000).forEach(s -> {
            vStageOne();
            vStageTwo();
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
//        proc();

        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start));
        System.out.println("List1: " + list1.size() + "; List2: " + list2.size());

        long startV = System.currentTimeMillis();

        Runnable runnablev = () -> {
            vProc();
        };
        Runnable runnablev1 = () -> {
            vProc();
        };
        Thread tv1 = new Thread(runnablev);
        Thread tv2 = new Thread(runnablev1);
        tv1.start();
        tv2.start();

        try {
            tv1.join();
            tv2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endV = System.currentTimeMillis();
        System.out.println();
        System.out.println("Time taken: " + (endV - startV));
        System.out.println("Vector1: " + v1.size() + "; Vector2: " + v2.size());
    }


}
