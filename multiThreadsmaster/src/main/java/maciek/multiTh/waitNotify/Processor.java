package maciek.multiTh.waitNotify;

import java.util.Scanner;

public class Processor {

    public void producer()  {
        synchronized (this) {
            System.out.println("Producer thread running ....");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\033[36mResumed by notify from consumer\033[0m\n");
        }
    }

    public void consumer() {
        Scanner scanner = new Scanner(System.in);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            System.out.println("Waiting for return key ");
            scanner.nextLine();
            System.out.println("return key pressed");
            notify();
        }
    }
}
