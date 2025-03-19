package service;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DownloadSimulator {
    private JFrame frame;
    private JProgressBar progressBar;
    private JButton button;

    public DownloadSimulator() {
        frame = new JFrame();
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        button = new JButton("Start Download");
        button.addActionListener((e) -> {
            startDownloading();
        });

        frame.add(progressBar, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
    }

    private void startDownloading() {
        button.setEnabled(false);
        SwingWorker<Void, Integer> swingWorker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                for(int i = 0; i <= 100; i+= (int) (Math.random() * 10)) {
                    TimeUnit.MILLISECONDS.sleep(500);
                    publish(i);
                }

                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                for(int value: chunks) {
                    progressBar.setValue(value);
                }
            }

            @Override
            protected void done() {
                button.setEnabled(true);
                JOptionPane.showMessageDialog(frame, "Download Complete!");
                publish(0);
            }
        };
        swingWorker.execute();
    }
}
