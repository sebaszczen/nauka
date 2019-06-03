package maciek.pl.threads;

import maciek.pl.threads.myrun.JoptThreads;

import javax.swing.*;

public class JoptThreadsApp {


    private final String[] kapitals = {"Praga", "Kijow", "Berlin", "Warszawa"};
    private boolean[] odgadniety = new boolean[kapitals.length];

    public JoptThreadsApp() {
        System.out.println("\033[31;1mHello\033[0m, \033[32;1;2mworld!\033[0m");
        System.out.println("\033[31mRed\033[32m, Green\033[33m, Yellow\033[34m, Blue\033[0m");
        JOptionPane.showMessageDialog(null, "Podaj stolice");
        JoptThreads m = new JoptThreads();
        m.start();
        int count = 0;
        while (count < kapitals.length) {
            String answer = JOptionPane.showInputDialog("Ilosc poprawnych odpowiedzi: " + count);
            if (isCorrect(answer)) {
                count++;
            }

        }
    }

    public static void main(String[] args) {
   ;
        new JoptThreadsApp();
    }

    private boolean isCorrect(String s) {


        for (int i = 0; i < kapitals.length; i++) {
            if (s.equals(kapitals[i])) {
                odgadniety[i] = true;
                return true;
            }
        }
        return false;
    }
}
