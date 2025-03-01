import thread.ThreadExample;

public class Main {
    public static void main(String[] args) {
        ThreadExample t1 = new ThreadExample(5);
        t1.start();
    }
}