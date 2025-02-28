//public class Main extends Thread {
//    public static void main(String[] args) {
//        Main main = new Main();
//        main.start();
//        System.out.println("Hello, World!");
//    }
//    public void run() {
//        System.out.println("This is from an thread.");
//    }
//}

//public class Main implements Runnable {
//    public static void main(String[] args) {
//        Main main = new Main();
//        Thread thread = new Thread(main);
//        thread.start();
//        System.out.println("Hello, World!");
//    }
//
//    @Override
//    public void run() {
//        System.out.println("This is from an thread.");
//    }
//    }
//}
import thread.*;

public class Main {
    public static void main(String[] args) {
        ThreadExample threadExample = new ThreadExample(5);
        threadExample.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("This is from Main: " + i);
        }
    }
}