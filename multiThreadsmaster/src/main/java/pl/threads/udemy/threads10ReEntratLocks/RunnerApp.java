package pl.threads.udemy.threads10ReEntratLocks;

public class RunnerApp {

    public static void main(String[] args) throws InterruptedException {
        Runner10 r10 = new Runner10();

//        Runnable run = ()-> r10.fristT();

        Thread t1 = new Thread(()-> {
            try {
                r10.fristT();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    r10.secondT();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        r10.finish();

    }

}
