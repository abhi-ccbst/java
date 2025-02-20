
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

    }
}

