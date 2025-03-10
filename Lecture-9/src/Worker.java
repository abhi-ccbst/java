public class Worker extends Thread {
    private SynchronizedMethods synchronizedMethods;

    public Worker(final SynchronizedMethods synchronizedMethods) {
        this.synchronizedMethods = synchronizedMethods;
    }

    @Override
    public void run() {
        for (int i = 0; i< 5; i++) {
            synchronizedMethods.calculate();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
