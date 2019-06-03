package maciek.multiTh.conc.semaphore.permitAB;

import java.util.concurrent.Semaphore;

public class App {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        //true - zachowuje kolejnosc czekajacych watków w jakiej zgłaszały prośbę o dostęp
        //domyslnie bez zachowanej kolejosci, cyfa oznacza ilosc watkow dostajacych pozwolenie w jednym czasie
//        Semaphore semaphore1 = new Semaphore(1,true);

        PermitAB permitAB1 = new PermitAB("Albin",semaphore);
        PermitAB permitAB2 = new PermitAB("Zeus",semaphore);

        permitAB1.start();
        permitAB2.start();

        try {
            permitAB1.join();
            permitAB2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("COUNT => " + SharedResource.COUNTER);

    }
}
