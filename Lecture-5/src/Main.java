import java.io.IOError;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        try {
            int[] myInt = {1,2,3};
            System.out.println(myInt[2]);
        } catch (IOError | ArrayIndexOutOfBoundsException e) {
            System.out.println("Something went wrong with IOError");
        } catch (Exception e) {
            System.out.println("Something went wrong");
        } finally {
            System.out.println("It will be executed");
        }

    }
}