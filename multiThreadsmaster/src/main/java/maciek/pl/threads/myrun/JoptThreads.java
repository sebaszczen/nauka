package maciek.pl.threads.myrun;

public class JoptThreads extends Thread {

    @Override
    public void run() {
        int time = 0;
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time++;
            int min = time/60;
            int sec = time%60;
            System.out.println("MIN: " + min + "SEC: " +sec);
        }

    }
}
