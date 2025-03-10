import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread taskThread = new Thread(task, "Volatile Flag");
        taskThread.start();
        try {
            Thread.sleep(4 * 1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        task.stop();

        InterruptTask interruptTask = new InterruptTask();
        Thread interruptThread = new Thread(interruptTask, "interrupt");
        interruptThread.start();
        try {
            Thread.sleep(4 * 1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        interruptThread.interrupt();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(new InterruptTask());
        Thread.sleep(4 * 1000);

        System.out.println("Shutting down executor...");
        executor.shutdownNow();
    }
}