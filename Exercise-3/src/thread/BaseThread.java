package thread;

public class BaseThread extends Thread implements ThreadTask {
    protected int numOfLoops;
    protected ThreadType type;

    public BaseThread(int numOfLoops, ThreadType type) {
        this.numOfLoops = numOfLoops;
        this.type = type;
    }

    @Override
    public void executeTask() {
        for (int i = 0; i < numOfLoops; i++) {
            System.out.println(type + " Thread - Loop: " + i);
        }
    }

    @Override
    public void run() {
        executeTask();
    }
}
