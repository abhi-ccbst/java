public class Main {
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
}

