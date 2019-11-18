package seba.kursWielowatkowosci;

import java.util.Random;

public class FirstHomeWork {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        Data data = new Data();
        ThreadOne threadOne = new ThreadOne(data);
        ThreadTwo threadTwo = new ThreadTwo(data);
        ThreadThree threadThree = new ThreadThree(data);
        ThreadFour threadFour = new ThreadFour(data, threadOne, threadTwo, threadThree);
        Thread t1 = new Thread(threadOne);
        Thread t2 = new Thread(threadTwo);
        Thread t3 = new Thread(threadThree);
        Thread t4 = new Thread(threadFour);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        while (System.currentTimeMillis() - l < 30000) {

        }
        System.out.println("czas sie skonczyl");
        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
        t4.interrupt();
        System.out.println("program zakonczony");
    }

    static class Data{

        private String liczba = null;

        public synchronized void write(String liczba) throws InterruptedException {
            while (this.liczba!=null) {
                System.out.println(Thread.currentThread().getName()+"write waits");
                wait();
                System.out.println(Thread.currentThread().getName()+"writte wakes up");
            }
            System.out.println(Thread.currentThread().getName()+" zapisuje liczbe: "+liczba);
            this.liczba = liczba;
            notify();
        }

        public synchronized String read() throws InterruptedException {
            while (liczba == null) {
                System.out.println(Thread.currentThread().getName()+"read waits");
                wait();
                System.out.println(Thread.currentThread().getName()+"read wakes up");
            }
            System.out.println(Thread.currentThread().getName()+" czytam liczbe: "+liczba);
            String temp = this.liczba;
            liczba=null;
            notify();
            return temp;
        }
    }

    static class ThreadOne implements Runnable{

        private Data data;

        public ThreadOne(Data data) {
            this.data = data;
        }

        @Override
        public void run() {
            Random random = new Random();
            int i = random.nextInt(51);
            try {
                while (true) {
                    data.write(String.valueOf(i));
                    Thread.sleep(1_000);
                }
            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
            }
        }

        public void getState() {
            System.out.println(Thread.currentThread().getState());
        }
    }

    static class ThreadTwo implements Runnable{

        private Data data;

        public ThreadTwo(Data data) {
            this.data = data;
        }

        @Override
        public void run() {
            Random random = new Random();
            int i = random.nextInt(401)+100;
            try {
                while (true) {
                    data.write(String.valueOf(i));
                Thread.sleep(2_000);
                }
            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
            }
        }

        public void getState() {
            System.out.println(Thread.currentThread().getState());
        }
    }

    static class ThreadThree implements Runnable{

        private Data data;

        public ThreadThree(Data data) {
            this.data = data;
        }

        @Override
        public void run() {
            String read ="";
            try {
                while (true){
                    read = data.read();
                Thread.sleep(8_000);
            }
            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
            }
            System.out.println(read);
        }

        public void getState() {
            System.out.println(Thread.currentThread().getState());
        }
    }

    static class ThreadFour implements Runnable{

        private Data data;
        private ThreadOne threadOne;
        private ThreadTwo threadtwo;
        private ThreadThree threadThree;

        public ThreadFour(Data data, ThreadOne threadOne, ThreadTwo threadtwo, ThreadThree threadThree) {
            this.data = data;
            this.threadOne = threadOne;
            this.threadtwo = threadtwo;
            this.threadThree = threadThree;
        }

        public synchronized void method() {
            int x= 8*23;
            System.out.println(x);
        }

        public void method2(){
            synchronized (this) {
                int x= 8*23;
                System.out.println(x);
            }
        }

        @Override
        public void run() {
            String read = "";
            long end = System.currentTimeMillis();
            while (System.currentTimeMillis()-end>1000) {
                try {
                    while (true) {
                        read = data.read();
                        System.out.println(Thread.currentThread().getName() + " read " + read);
                    Thread.sleep(6_000);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(read);
                threadOne.getState();
                threadtwo.getState();
                threadThree.getState();
                end = System.currentTimeMillis();
            }
        }
    }
}
