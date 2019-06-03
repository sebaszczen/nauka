package maciek.pl.threads;

import java.util.ListResourceBundle;
import java.util.Random;

public class StorageApp extends Thread{
    public static void main(String[] args) {


        String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ?/.,";
        Random rnd = new Random();
        char chars = alphabet.charAt(rnd.nextInt(alphabet.length()));


            try {
                new StorageApp().go();
            } catch (Exception e) {
                System.out.println("thrown to main");
            }
        }


        synchronized void go() throws InterruptedException {
            Thread t1 = new Thread();
            t1.start();
            System.out.print("1 ");
            t1.sleep(1000);
            System.out.print("2 ");
            t1.checkAccess();
        }

    }

