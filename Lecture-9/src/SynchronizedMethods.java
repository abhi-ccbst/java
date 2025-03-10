public class SynchronizedMethods {
    private int sum = 0;

    public void calculate() {
        synchronized (this) {
            System.out.println("This is non synchronized block");
            synchronized (this){
                sum++;
                System.out.println(Thread.currentThread().getName() + " incremented count to: " + sum);
            }
        }
        System.out.println("This is non synchronized block");
    }

    public int getSum() {
        return sum;
    }
}
