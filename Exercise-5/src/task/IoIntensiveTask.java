package task;

public class IoIntensiveTask extends AbstractTask {

    public IoIntensiveTask(String taskName) {
        super(taskName);
    }

    @Override
    protected void performTask() {
        try {
            Thread.sleep(2 * 1000);
            System.out.println(taskName + " completed I/O operation.");
        } catch (InterruptedException e){
            throw new RuntimeException(e.getMessage());
        }

    }
}
