package task;

public class CpuIntensiveTask extends AbstractTask {

    public CpuIntensiveTask(String taskName) {
        super(taskName);
    }

    @Override
    protected void performTask() {
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }
        System.out.println(taskName + " completed CPU work: " + sum);
    }

}
