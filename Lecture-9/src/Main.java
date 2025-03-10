public class Main {

    private final static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
    public static void main(String[] args) {
        SynchronizedMethods synchronizedMethods = new SynchronizedMethods();
        Thread t1 = new Worker(synchronizedMethods);
        Thread t2 = new Worker(synchronizedMethods);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Final count: " + synchronizedMethods.getSum());

        Runnable task = () -> {
            for (int i = 0; i < 3; i++) {
                int value = threadLocal.get();
                threadLocal.set(value+1);
                System.out.println(Thread.currentThread().getName() + " -> " + threadLocal.get());
            }
        };
        Thread task1 = new Thread(task, "Task-1");
        Thread task2 = new Thread(task, "Task-2");
        task1.start();
        task2.start();
        try {
            task1.join();
            task2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}