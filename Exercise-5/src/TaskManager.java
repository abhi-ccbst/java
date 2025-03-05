import task.CpuIntensiveTask;
import task.IoIntensiveTask;
import task.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskManager {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        Task cpuTask = new CpuIntensiveTask("CPU Task 1");
        Task ioTask = new IoIntensiveTask("IO Task 1");

        //Submitting tasks to ExecutorService
        executorService.execute(cpuTask::executeTask);
        executorService.execute(ioTask::executeTask);

        //Scheduling a periodic task
        scheduledExecutorService.scheduleAtFixedRate(() ->
            System.out.println("Scheduled Task running on " + Thread.currentThread().getName()),
            1, 3, TimeUnit.SECONDS
        );

        Thread thread1 = new Thread(cpuTask::executeTask);
        Thread thread2 = new Thread(ioTask::executeTask);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        executorService.shutdown();
        scheduledExecutorService.schedule(
                scheduledExecutorService::shutdown,
                15, TimeUnit.SECONDS
                );

    }
}