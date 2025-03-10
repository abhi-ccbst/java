public class Main {
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
    }
}