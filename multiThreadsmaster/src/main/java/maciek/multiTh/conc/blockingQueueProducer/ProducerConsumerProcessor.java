package maciek.multiTh.conc.blockingQueueProducer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class ProducerConsumerProcessor {

    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public void producer(String name) {
        Random ranom = new Random();

        while (true) {
            Integer valueToAdd = ranom.nextInt(100);
            try {
                Thread.sleep(500);
                queue.put(valueToAdd);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\033[34mProducer: " + name + " added queue: " + valueToAdd +"  @remaing capacity of queue: " + queue.remainingCapacity());
        }
    }

    public void consumer(String name)  {
        Random random = new Random();
        while (true) {
            if(random.nextInt(10) == 0) {
                Integer value = 0;
                try {
                    Thread.sleep(300);
                    value = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("\033[31mConsumer: " + name + " taken values " + value +  " from queue. Queue size is: \033[0m" +queue.size() );
            }
        }
    }
}
