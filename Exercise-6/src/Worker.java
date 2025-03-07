import java.util.concurrent.CountDownLatch;

public class Worker extends Thread{
    private final CountDownLatch countDownLatch;
    private final int workerId;
    public Worker(final CountDownLatch countDownLatch, final int workerId) {
        this.countDownLatch = countDownLatch;
        this.workerId = workerId;
    }

    @Override
    public void run() {
        System.out.println("Worker " + workerId + " is starting...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Worker " + workerId + " has finished.");
        countDownLatch.countDown();
    }
}
