public class Task implements Runnable {

    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println(Thread.currentThread().getName() + " is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + " stopped.");
    }

    public void stop() {
        running = false;
    }
}
