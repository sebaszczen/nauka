package maciek.multiTh.conc.semaphore.permitAB;

import org.w3c.dom.css.Counter;

import java.util.concurrent.Semaphore;

import static maciek.multiTh.Consoler.*;

public class PermitAB extends Thread {

    private String name;
    private Semaphore semaphore;

    public PermitAB(String name, Semaphore semaphore) {
        super(name);
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        //rusza watek A
        if (name.equals("Albin")) {
            System.out.println("Starting thread -> " + name);
            try {
                //napierw oczekuje na pozwolenie
                System.out.println(name + ANSI_RED + " is waiting for permit" + ANSI_RESET);
                //zakładanie blokady
                semaphore.acquire();
                System.out.println(name + ANSI_BLUE + " gets permit" + ANSI_RESET);
                //teraz jest dostęp do dzielonego zasobu, inne czekajace watki czekaja az ten zwolni lock (monitor)
                for (int i = 0; i < 5; i++) {
                    SharedResource.COUNTER++;
                    System.out.println(name + "-> " + SharedResource.COUNTER);
                    sleep(50);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //zwolnienie pozwolenia
            System.out.println(ANSI_YELLOW+name + " releases thre permit"+ANSI_RESET);
            semaphore.release();
        } else {
            System.out.println("Starting thread -> " + name);
            try {
                //napierw oczekuje na pozwolenie
                System.out.println(name + ANSI_RED + " is waiting for permit" + ANSI_RESET);
                //zakładanie blokady
                semaphore.acquire();
                System.out.println(name + ANSI_BLUE + " gets permit" + ANSI_RESET);
                //teraz jest dostęp do dzielonego zasobu, inne czekajace watki czekaja az ten zwolni lock (monitor)
                for (int i = 0; i < 5; i++) {
                    SharedResource.COUNTER++;
                    System.out.println(name + "-> " + SharedResource.COUNTER);
                    sleep(50);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //zwolnienie pozwolenia
            System.out.println(ANSI_CYAN+name + " releases thre permit"+ANSI_RESET);
            semaphore.release();
        }
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
