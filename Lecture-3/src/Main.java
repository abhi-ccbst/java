import car.Car;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Car fordCar = new Car(2013, "ford", "fusion-se");
        fordCar.setName("Ford");
        System.out.println(fordCar.getName());

        Car bmwCar = new Car(2024, "BMW", "m4");
        System.out.println(bmwCar.getName());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Car detail in below: ");
        System.out.print("\t Year: ");
        String year = scanner.nextLine();
        System.out.print("\t Name: ");
        String name = scanner.nextLine();
        System.out.print("\t Model: ");
        String model = scanner.nextLine();

        Car userCar = new Car(Integer.parseInt(year), name, model);
        System.out.println("User input car name is: " + userCar.getName());
    }
}