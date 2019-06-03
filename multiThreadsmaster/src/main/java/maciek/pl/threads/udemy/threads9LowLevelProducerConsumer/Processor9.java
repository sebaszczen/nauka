package maciek.pl.threads.udemy.threads9LowLevelProducerConsumer;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Processor9 {

    private LinkedList<Integer> list = new LinkedList<>();
    private final int LIMIT = 10;
    private Object lock = new Object();

    public void producer() throws InterruptedException {

        int value = 0;

        while (true) {
            synchronized (lock) {
                while (list.size() == LIMIT) {
                    lock.wait();
                }
                list.add(value);
                value++;
                System.out.print("\033[36mAdd value: \033[0m " + value + "\033[36m to list\033[0m\n");
                //ten notify budzi locka w consumerze No bo jezeli lista się doda to jest więcej jak 0. .
                lock.notify();
            }
        }
    }

    public void consumer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            synchronized (lock) {
                while (list.size() == 0){
                    lock.wait();
                }
                System.out.print(" List size is: " + list.size());
                int value = list.removeFirst();
                System.out.println("; value is: " + value);
                lock.notify();
                Thread.sleep(random.nextInt(1000));
            }

        }
    }
}
