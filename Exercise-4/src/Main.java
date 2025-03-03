import com.sun.jdi.event.ThreadDeathEvent;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread thread = new Thread(sharedResource::produce);
        Thread thread2 = new Thread(sharedResource::consume);
        thread2.start();
        thread.start();

    }
}

class SharedResource {
    private boolean isProduced = false;

    public synchronized void produce() {
        try {
            System.out.println("Producing data...");
            Thread.sleep(1000);
            isProduced = true;
            Thread.sleep(2000);
            notify();
            System.out.println("Data produced. Notifying consumer...");

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public synchronized void consume() {
        try {
            while (!isProduced) {
                System.out.println("Consumer waiting for data...");
                wait();
            }
            System.out.println("Consuming data...");
        }catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}