package maciek.pl.threads.udemy.threads15SwingWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

public class MainFrame extends JFrame {

    private JLabel count1 = new JLabel("0");
    private JLabel statusLabel = new JLabel("Task not completed");
    private JButton startButton = new JButton("start");

    public MainFrame(String title) {
        super(title);

        setLayout(new GridBagLayout());
        GridBagConstraints gcb = new GridBagConstraints();

        gcb.fill = GridBagConstraints.NONE;
        gcb.gridx = 0;
        gcb.gridy = 0;
        gcb.weightx = 1;
        gcb.weighty = 1;
        add(count1, gcb);

        gcb.gridx = 0;
        gcb.gridy = 1;
        gcb.weightx = 1;
        gcb.weighty = 1;
        add(statusLabel, gcb);

        gcb.gridx = 0;
        gcb.gridy = 2;
        gcb.weightx = 1;
        gcb.weighty = 1;
        add(startButton, gcb);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                start();
            }
        });

        setSize(200,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void start() {

        SwingWorker<Boolean, Integer> worker = new SwingWorker<Boolean, Integer>() {
            @Override
            protected Boolean doInBackground() throws Exception {


                IntStream.range(0, 30).forEach(t-> {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("HI - > " + t);
                    publish(t);
//                    count1.setText(String.valueOf(t));

                });
                return true;
            }

            @Override
            protected void process(List<Integer> list) {
                Integer value = list.get(list.size() - 1);
                count1.setText("Current value " + value);
            }

            protected void done() {
                try {
                    Boolean status = get().booleanValue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                statusLabel.setHorizontalTextPosition(0);
                statusLabel.setText("Work done!");
            }
        };
        worker.execute();
    }
}
