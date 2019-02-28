package pl.threads.myrun;

public class MyRunThreads implements Runnable{

    private int id;

    public MyRunThreads(int id) {
        this.id = id;
    }

    @Override
    public void run() {

        while(true) {
            System.out.println("thread id: " + id);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
