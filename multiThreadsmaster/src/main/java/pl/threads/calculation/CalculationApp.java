package pl.threads.calculation;

public class CalculationApp {

    public static void main(String[] args) {
        Calculation c = new Calculation();
        c.start();
        synchronized (c) {
            System.out.println("waiting for result... ");
            try {
                //robi waita i główny wątek jest uśpiony.
                c.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("resut is ...." + c.total);
        }
    }
}
