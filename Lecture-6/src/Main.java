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

public class Main implements Runnable {
    private static int account = 0;
    public static void main(String[] args) {
        Main main = new Main();
        Thread thread = new Thread(main);
        thread.start();
        while (thread.isAlive()) {
            System.out.println("Waiting++");
        }

        account++;
        System.out.println("Hello, World!");
    }

    @Override
    public void run() {
        account++;
        System.out.println("This is from an thread.");
    }

}
//import thread.*;
//
//public class Main {
//    public static void main(String[] args) {
//        ThreadExample threadExample = new ThreadExample(5);
//        threadExample.start();
//        for (int i = 0; i < 5; i++) {
//            System.out.println("This is from Main: " + i);
//        }
//    }
//}