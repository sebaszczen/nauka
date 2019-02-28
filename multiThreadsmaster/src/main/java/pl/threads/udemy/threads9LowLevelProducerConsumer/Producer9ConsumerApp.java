package pl.threads.udemy.threads9LowLevelProducerConsumer;

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

        Thread t1 = new Thread(new Runnable() {
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


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pCp.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pCp.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        run2.run();
//        t2.start();

//        t3.start();

//        t2.join();
        t1.join();
//        t3.join();
    }
}
