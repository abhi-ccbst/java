package myAnnotation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskProcessor {
    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    @LogExecutionTime
    public void cpuIntensiveTask() {
        System.out.println(Thread.currentThread().getName() + " - Performing CPU-intensive task...");
        long sum = 0;
        for (long i = 0; i < 1_000_000_000L; i++) { // Heavy computation
            sum += i;
        }
        System.out.println("CPU Task Completed.");
    }

    @LogExecutionTime
    public void ioIntensiveTask() {
        System.out.println(Thread.currentThread().getName() + " - Performing I/O-intensive task...");
        try {
            Thread.sleep(3000); // Simulating file/database operation
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("I/O Task Completed.");
    }

    public void submitTasks() {
        executor.execute(() -> {
            AnnotationProcessor.invokeWithLogging(this);
            });

    }

    public void shutdown() {
        executor.shutdown();
    }

}
