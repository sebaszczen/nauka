package multiTh.conc.executor;

import static multiTh.Consoler.ANSI_GREEN;
import static multiTh.Consoler.ANSI_RED;
import static multiTh.Consoler.ANSI_RESET;

public class ExecSlaveWorker implements Runnable {

    private int id;

    public ExecSlaveWorker(int id) {
        this.id = id;
    }


    @Override
    public void run() {
        System.out.println(ANSI_RED+"Starting runnable "  + id  +", "+ Thread.currentThread().getId() + ANSI_RESET);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ANSI_GREEN+"Completed runnable "  + id  +", "+ Thread.currentThread().getId()+  ANSI_RESET);

    }
}
