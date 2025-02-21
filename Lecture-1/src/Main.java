
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.print("Test");
        System.out.println(1+1);
        // One line comment

        /*
        * Multiple line comments
        * */

        // variables: type name = "test";
        // String, int, float, boolean, char, long, double....
        String name = "Abhi";
        name = "Abhi Patel";
        System.out.println("My name is: " + name);

        int score = 10;  //-2147483648 to 2147483647
        System.out.println("My score is: " + score);

        float percentage = 100.00f;  //3.40282346638528860e+38
        System.out.println("My percentage is: " + percentage);

        boolean isPassed = true;
        System.out.println("Did I passed the exam: " + isPassed);

        char initial = 'a';
        System.out.println("My initial is: " +initial);

        long phoneNumber = 1234567890;//9,223,372,036,854,775,807
        System.out.println("My phone number is: " + phoneNumber);

        double per = 10.12;//1.7976931348623157E+308
        System.out.println("My double value is: "+ per);

        //Widening Casting (automatically) - converting a smaller type to a larger type size
        // char -> int -> long -> float -> double
        int myInt= 100;
        double myDouble = myInt;
        //
        //Narrowing Casting (manually) - converting a larger type to a smaller size type
        //double -> float -> long -> int -> char
        myDouble = 10.10;
        myInt = (int) myDouble;
        System.out.println("My value is: " + myInt);


        System.out.println("######################################");


        double num1 = 25.5;
        double num2 = 5.0;

        // Perform basic operations: addition, subtraction, multiplication, division
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = num1 / num2;
        double reminder = num1 % num2;

        // Display results
        System.out.println("The first number is: " + num1);
        System.out.println("The second number is: " + num2);

        System.out.println("Addition: " + num1 + " + " + num2 + " = " + sum);
        System.out.println("Subtraction: " + num1 + " - " + num2 + " = " + difference);
        System.out.println("Multiplication: " + num1 + " * " + num2 + " = " + product);
        System.out.println("Division: " + num1 + " / " + num2 + " = " + quotient);
        System.out.println("Reminder: " + num1 + " % " + num2 + " = " + reminder);


        // IF ELSE
        // SWITCH
        int a = 10;
        int b = 20;

        if (a > b) {
            System.out.println("a > b");
        } else if (a < b) {
                System.out.println("a < b");
        } else {
            System.out.println("a == b");
        }

        switch (a) {
            case 0:
                System.out.println("The value of a is 0");
                break;
            case 5:
                System.out.println("The value of a is 5");
                break;
            case 10:
                System.out.println("The value of a is 10");
                break;
            default:
                System.out.println("The value of a is unknown");

        }



        System.out.println("##################");

        int number1 = 15;  // Number to check if even or odd
        int number3 = 10;  // Another number to perform sum and difference

        // Checking if the number is even or odd using if-else
        if (number1 % 2 == 0) {
            System.out.println(number1 + " is an even number.");
        } else {
            System.out.println(number1 + " is an odd number.");
        }

        // Performing basic arithmetic operations using switch
        System.out.println("Performing operations on " + number3);
        int choice = 1; // For example: 1 for addition, 2 for subtraction, etc.
        int result;

        switch (choice) {
            case 1:
                // Sum
                result = number3 + 5;
                System.out.println("Sum of " + number3 + " and 5 is: " + result);
                break;
            case 2:
                // Difference
                result = number3 - 5;
                System.out.println("Difference between " + number3 + " and 5 is: " + result);
                break;
            case 3:
                // Multiplication
                result = number3 * 5;
                System.out.println("Multiplication of " + number3 + " and 5 is: " + result);
                break;
            case 4:
                // Division
                if (5 != 0) {
                    result = number3 / 5;
                    System.out.println("Division of " + number3 + " by 5 is: " + result);
                } else {
                    System.out.println("Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid operation.");
        }

        // Mathematical operation for power (exponentiation)
        double powerResult = Math.pow(number3, 2); // number3 raised to the power of 2
        System.out.println("The square of " + number3 + " is: " + powerResult);

    }
}

