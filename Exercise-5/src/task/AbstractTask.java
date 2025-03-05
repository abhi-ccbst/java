package task;

public abstract class AbstractTask implements Task {

    protected String taskName;

    public AbstractTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void executeTask() {
        System.out.println(taskName + " is executing on " + Thread.currentThread().getName());
        performTask();
    }

    protected abstract void performTask();
}
