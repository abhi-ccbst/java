package thread;

public class ThreadExample extends Thread {
    private int numOfLoops;
    private Thread inSideThread;
    public ThreadExample(int numOfLoops) {
        this.numOfLoops = numOfLoops;
        inSideThread = new Thread(new InSideThread(numOfLoops));

    }

    @Override
    public void run() {
        inSideThread.start();
        for (int i = 0; i < numOfLoops; i++) {
            System.out.println("This is from thread: " + i);
        }
    }

    public static class InSideThread implements Runnable {
        private int numOfLoops;
        public InSideThread(int numOfLoops) {
            this.numOfLoops = numOfLoops;
        }

        @Override
        public void run() {
            for (int i = 0; i < numOfLoops; i++) {
                System.out.println("This is from inside thread: " + i);
            }
        }
    }
}
