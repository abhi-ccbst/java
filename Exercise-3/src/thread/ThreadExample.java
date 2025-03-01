package thread;

public class ThreadExample extends  BaseThread {
    private Thread insideThread;

    public ThreadExample(int numOfLoops) {
        super(numOfLoops, ThreadType.PRIMARY);
        insideThread = new Thread(new InsideThread(numOfLoops));
    }

    @Override
    public void run() {
        insideThread.start(); // Start the secondary thread
        super.run(); // Execute primary thread task
    }

    public static class InsideThread extends Thread implements ThreadTask {
        private int numOfLoops;
        public InsideThread(int numOfLoops) {
            this.numOfLoops = numOfLoops;
        }
        @Override
        public void executeTask() {
            for (int i = 0; i < numOfLoops; i++) {
                System.out.println(ThreadType.SECONDARY + " Thread - Loop: " + i);
            }
        }
        @Override
        public void run() {
            executeTask();
        }
    }
}
