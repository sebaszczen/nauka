package pl.threads.myrun;

public class MyRunThreads3 extends Thread {

    private volatile int id;

    public MyRunThreads3(int id){
        this.id = id;
    }

    public MyRunThreads3(){
    }

    @Override
    public void run() {

        while (true) {
            System.out.println("NEW JAVA exdents t ->" + id);
        }
    }

    public static void main(String[] args) throws InterruptedException {

            Thread t1 = new MyRunThreads3(1);
            Thread t2 = new MyRunThreads3(2);

            t1.start();
            t2.start();


    }
}
