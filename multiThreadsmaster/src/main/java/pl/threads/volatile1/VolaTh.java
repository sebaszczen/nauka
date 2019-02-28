package pl.threads.volatile1;

public class VolaTh implements Runnable {

    private volatile boolean end = false;

    public  void stopMe(){
        end = true;
        System.out.println("end for sure" + end);
    }

    @Override
    public void run() {
        while (!end) {
            System.out.println("Can't stop me:() " + end);

        }
        System.out.println("STOPPED!");

    }


}
