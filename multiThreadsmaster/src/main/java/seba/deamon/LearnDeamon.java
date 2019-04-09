package seba.deamon;

public class LearnDeamon {

    public static void main(String[] args) throws InterruptedException {
        Deamon deamon = new Deamon();
        Thread thread = new Thread(deamon);
        thread.setDaemon(true);
        thread.start();
//        Thread.sleep(2000);
//        System.out.println("endddddd");
    }

    static class Deamon implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.println("start---");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("koniec");
            }
        }
    }

}
