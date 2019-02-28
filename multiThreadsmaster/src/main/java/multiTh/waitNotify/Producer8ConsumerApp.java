package multiTh.waitNotify;

public class Producer8ConsumerApp {

    public static void main(String[] args) throws InterruptedException {

        Processor pCp = new Processor();

        Runnable run1 = () ->  pCp.producer();


        Thread producer1 = new Thread(()-> pCp.producer());

        Runnable run2 = () -> pCp.consumer();

        Thread consumer1 = new Thread(()-> pCp.consumer());

        Thread consumer2 = new Thread(() -> pCp.consumer());

        producer1.start();
        consumer1.start();


        producer1.join();
        consumer1.join();
        System.out.println("XXX FAJRANT");
    }
}
