package pl.threads.udemy.threads7;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class ProducerConsumerProcessor {

    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public void producer() throws InterruptedException {
        Random ranom = new Random();

        while (true) {
            Integer valueToAdd = ranom.nextInt(100);
            Thread.sleep(500);
            queue.put(valueToAdd);
            System.out.println("\033[34mAdded queue: " + valueToAdd +"  @remaing capacity of queue: " + queue.remainingCapacity());
        }
    }

    public void consumer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            Thread.sleep(200);
            if(random.nextInt(5) == 0) {
                Integer value = queue.take();
                Integer value1 = queue.take();

                System.out.println("\033[31mTaken values " + value + ", "+ value1 + " from queue. Queue size is: \033[0m" +queue.size() );
            }
        }
    }
}
