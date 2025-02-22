public class Main {
    String firstName;
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int i = 5;
        while (i > 0) {
            System.out.println("Value of i: " + i);
            i--;
        }

        i = 5;
        do {
            System.out.println("Value of i: " + i);
            i--;
        } while (i < 0);

        for (int j = 0; j < 5; j++) {
            System.out.println("Value of j: " + j);
            for (int z = 0; z <3; z++) {
                System.out.println("\tValue of z: " + z);
            }
        }
        i = 0;

        while (true) {
            i++;
            if(i == 2) {
                System.out.println("(CONTINUE) Value of i: " + i);
                continue;
            }
            System.out.println("(BREAK) Value of i: " + i);

            if (i == 5) {
                break;
            }
        }

        String[] cars = {"Ford", "BMW", "Audi", "Honda"};
        System.out.println(cars[0]);
        for (String name: cars) {
            System.out.println(name);
        }
        System.out.println(cars.length);
        String[][] categories = {{"Food", "automobile", "clothes"}, {"Test", "test3", "test3"}};
        System.out.println(categories[1][1]);
        myVoidMethod(12);

        myVoidMethod(12 * 2);
        myVoidMethod(12 * 3);
        myVoidMethod(12 * 4);
        myVoidMethod("12");
        System.out.println(myName());

        Main main = new Main();
        main.myTest();
        main.firstName= "John";
        System.out.println(main.firstName);
        main.squarePattern();
        System.out.println("################################");
        main.diamondPattern();
        System.out.println("################################");
        main.butterflyPattern();
    }

    public static void myVoidMethod(int i) {
        System.out.println("The value of i: " + i);
    }

    private static String myName() {
        return "Abhi Patel";
    }

    private static void myVoidMethod(String t) {
        System.out.println("Test");
    }

    private void myTest() {
        System.out.println("Test");
    }

    private void squarePattern() {
        for (int i = 0; i  <  5; i++) {
            for (int j = 0; j  <  5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private void diamondPattern() {
        int n = 5;

        // Upper half of the diamond
        for (int i = 0; i  <  n; i++) {
            // Print spaces
            for (int j = n - 1; j  >  i; j--) {
                System.out.print(" ");
            }
            // Print asterisks
            for (int k = 0; k  <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Lower half of the diamond
        for (int i = 1; i  <  n; i++) {
            // Print spaces
            for (int j = 0; j  <  i; j++) {
                System.out.print(" ");
            }
            // Print asterisks
            for (int k = n - 1; k  >= i; k--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private void butterflyPattern() {
        int n = 5;

        // Upper half of the diamond
        for (int i = 1; i  <= n; i++) {
            // Print left half of the row
            for (int j = 1; j  <= i; j++) {
                System.out.print("*");
            }
            // Print spaces in the middle
            for (int j = 1; j  <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            // Print right half of the row
            for (int j = 1; j  <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower half of the diamond
        for (int i = n; i  >= 1; i--) {
            // Print left half of the row
            for (int j = 1; j  <= i; j++) {
                System.out.print("*");
            }
            // Print spaces in the middle
            for (int j = 1; j  <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            // Print right half of the row
            for (int j = 1; j  <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}

