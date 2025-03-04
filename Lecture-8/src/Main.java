import thread.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 20; i++) {
            executorService.execute(new Task(i));
        }
        executorService.shutdown();
        try{
            if(executorService.awaitTermination(50, TimeUnit.SECONDS)) {
                System.out.println("All tasks completed successfully.");
            } else {
                System.out.println("Timeout reached! Some tasks are still running.");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("Main thread exiting.");

    }
}


