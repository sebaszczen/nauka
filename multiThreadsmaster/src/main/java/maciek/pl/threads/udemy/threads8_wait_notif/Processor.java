package maciek.pl.threads.udemy.threads8_wait_notif;

import java.util.Scanner;

public class Processor {

    public void producer() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread running ....");
            wait();
            System.out.println("\033[36mResumed by notify from consumer\033[0m\n");
        }
    }

    public void consumer() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this) {
            System.out.println("Waiting for return key ");
            scanner.nextLine();
            System.out.println("return key pressed");
            notify();

        }
    }
}
