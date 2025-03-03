public class Main implements Runnable{

    public static Thread thread1;
    public static Main obj;
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        obj = new Main();
        thread1 = new Thread(obj);
        System.out.println("State of thread1 after creating it - "
                + thread1.getState());

        thread1.start();

        System.out.println("State of thread1 after calling .start()"
                + " method on it - " + thread1.getState());

        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        System.out.println("State of thread1 after calling .join()"
                + " method on it - " + thread1.getState());

    }

    @Override
    public void run() {
        Thread thread2 = new Thread(new thread());
        System.out.println("State of thread2 after creating it: " + thread2.getState());
        thread2.start();
        System.out.println("State of thread2 after calling start(): " + thread2.getState());
        try {
            Thread.sleep(200);  //0.2 Sec
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        System.out.println("State of thread2 after calling sleep(): " + thread2.getState());
        try {
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        System.out.println("State of thread2 when it has finished" + thread2.getState());

    }
}


class thread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(20000);  //2 Sec
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        System.out.println("State of thread1 :" + Main.thread1.getState());
        try {
            Thread.sleep(200);  //0.2 Sec
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
