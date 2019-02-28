package pl.threads.udemy.threads15SwingWorker;

import javax.swing.*;

public class Threads15SwingWorkerApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame("SW DemoWo");
            }
        });
    }
}
