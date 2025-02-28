package thread;

public class ThreadExample extends Thread {
    private int numOfLoops;
    public ThreadExample(int numOfLoops) {
        this.numOfLoops = numOfLoops;
    }

    @Override
    public void run() {
        for (int i = 0; i < numOfLoops; i++) {
            System.out.println("This is from thread: " + i);
        }
    }
}
