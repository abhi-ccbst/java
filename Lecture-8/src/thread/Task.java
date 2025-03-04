package thread;
//
//public class Task implements Runnable {
//
//    private final int taskId;
//
//    public Task(int taskId) {
//        this.taskId = taskId;
//    }
//
//    @Override
//    public void run() {
//        System.out.println("Task " + taskId + " is running on thread: " + Thread.currentThread().getName());
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}

public class Task implements Runnable {
    private final String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }
    @Override
    public void run() {
        System.out.println(taskName + " executed at: " + System.currentTimeMillis() + " by " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}