package maciek.pl.threads.workers;

import java.util.stream.IntStream;

public class JavaWorker1 extends Thread{

    public JavaWorker1(String name) {
        super(name);
    }

    @Override
    public void run() {
        IntStream.range(0,1000).forEach(e-> {
            System.out.println("\033[31m JavaWorker 1 running .. " + getName() + "\033[0m");
            try {
                sleep(550);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });
    }
}
