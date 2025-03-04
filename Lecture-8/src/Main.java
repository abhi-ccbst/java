import thread.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//public class Main {
//    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        for (int i = 1; i <= 20; i++) {
//            executorService.execute(new Task(i));
//        }
//        executorService.shutdown();
//        try{
//            if(executorService.awaitTermination(50, TimeUnit.SECONDS)) {
//                System.out.println("All tasks completed successfully.");
//            } else {
//                System.out.println("Timeout reached! Some tasks are still running.");
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e.getMessage());
//        }
//        System.out.println("Main thread exiting.");
//
//    }
//}

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        // Task 1: Runs after a 3-second delay
        executorService.schedule(new Task("Delayed Task"), 3, TimeUnit.SECONDS);
        // Task 2: Runs every 2 seconds, first execution after 1 second
        executorService.scheduleAtFixedRate(new Task("Fixed Rate Task"), 1, 2, TimeUnit.SECONDS);
        // Task 3: Runs every 3 seconds after the previous one finishes
        executorService.scheduleWithFixedDelay(new Task("Fixed Delay Task"), 2, 3, TimeUnit.SECONDS);
        executorService.schedule(() -> {
            System.out.println("Shutting down scheduler...");
            executorService.shutdown();
        }, 100, TimeUnit.SECONDS);
    }

}

