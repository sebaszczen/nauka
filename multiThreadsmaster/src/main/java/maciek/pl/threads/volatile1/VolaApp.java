package maciek.pl.threads.volatile1;

public class VolaApp  {
    public static void main(String[] args) {
        VolaTh th = new VolaTh();
        Thread tRun = new Thread(th);

        tRun.start();

        try {
            tRun.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        th.stopMe();
    }
}
