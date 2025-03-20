import javax.swing.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelDownloadSimulator {
    private JFrame frame;
    private JProgressBar[] progressBars = new JProgressBar[3];
    private JButton button;
    private ExecutorService executor = Executors.newFixedThreadPool(1);
    private int completedDownloads = 0;

    public ParallelDownloadSimulator() {
        frame = new JFrame("Parallel Download Simulator");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        for (int i = 0; i < 3; i++) {
            progressBars[i] = new JProgressBar(0, 100);
//            progressBars[i].setString("File: " + (i + 1));
            progressBars[i].setStringPainted(true);
            frame.add(progressBars[i]);
        }

        button = new JButton("Start Downloads");
        button.addActionListener((e) -> startDownloads());
        frame.add(button);

        frame.setVisible(true);
    }

    private void startDownloads() {
        button.setEnabled(false);
        completedDownloads = 0;

        for (int i = 0; i < 3; i++) {
            final int index = i;
            executor.execute(() -> startDownloading(index));
        }
    }

    private void startDownloading(final int index) {
        SwingWorker<Void, Integer> swingWorker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i += (int) (Math.random() * 10)) {
                    TimeUnit.MILLISECONDS.sleep(500);
                    publish(i);
                }
                publish(100);
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                for (int value : chunks) {
                    progressBars[index].setValue(value);
                }
            }

            @Override
            protected void done() {
                synchronized (ParallelDownloadSimulator.this) {
                    completedDownloads++;
                    if (completedDownloads == 3) {
                        JOptionPane.showMessageDialog(frame, "All Downloads Complete!");
                        button.setEnabled(true);
                    }
                }
            }
        };
        swingWorker.execute();
    }
}
