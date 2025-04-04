package myAnnotation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class TaskProcessor {
    ThreadFactory namedThreadFactory = new ThreadFactory() {
        private int count = 1;

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName("Worker-Thread-" + count++);
            return t;
        }
    };
    private final ExecutorService executor = Executors.newFixedThreadPool(2, namedThreadFactory);

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
            Thread.sleep(3000);
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
