package multiTh.volatileExamples.sampleVolatile;

import java.util.logging.Level;

import static multiTh.Consoler.ANSI_BLUE;
import static multiTh.Consoler.ANSI_GREEN;
import static multiTh.Consoler.ANSI_RESET;

public class VolatileExampleApp {

//    private static int MY_VOLATILE_INT = 0;
    private static volatile int MY_VOLATILE_INT = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int local_value = MY_VOLATILE_INT;
            while ( local_value < 5){
                if( local_value!= MY_VOLATILE_INT){
                    System.out.println(ANSI_GREEN+"Got Change for MY_INT : {0} " + MY_VOLATILE_INT+ANSI_RESET);
                    local_value= MY_VOLATILE_INT;
                }
            }
        }
    }

    static class ChangeMaker extends Thread{
        @Override
        public void run() {

            int local_value = MY_VOLATILE_INT;
            while (MY_VOLATILE_INT <5){
                System.out.println(ANSI_BLUE+"Incrementing MY_INT to {0}" + (local_value+1)+ANSI_RESET);
                MY_VOLATILE_INT = ++local_value;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }
}
