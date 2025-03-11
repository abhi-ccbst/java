package bank;

public class DaemonThreadExample extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
