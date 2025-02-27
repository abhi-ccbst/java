import MyCustomException.MyException;

import java.io.IOError;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

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
        System.out.print("Enter your age: ");
        Scanner scanner = new Scanner(System.in);
//        try {
            throwException(Integer.parseInt( scanner.nextLine()));
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }

    private static void throwException(int i) {
        if (i < 18) {
            throw new MyException("Access denied: You must be 18 year or above!", 2);
        }
        System.out.println("Access granted");
    }

}