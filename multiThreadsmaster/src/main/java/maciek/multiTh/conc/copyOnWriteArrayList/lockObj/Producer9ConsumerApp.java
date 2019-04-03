package maciek.multiTh.conc.copyOnWriteArrayList.lockObj;

public class Producer9ConsumerApp {
    public static void main(String[] args) throws InterruptedException {

        Processor9 pCp = new Processor9();

        Runnable runnable1 = () -> {
            try {
                pCp.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread producer1 = new Thread(runnable1);

        Thread producer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pCp.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Runnable run2 = () -> {
            try {
                pCp.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread consumer1 = new Thread(run2);

        producer1.start();
        consumer1.start();
        producer1.join();
        consumer1.join();
    }
}
