import vehicle.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car vehicle2 = getCar(scanner);
        Truck vehicle3 = new Truck("Ford", "F-150", 2022, "Black", 10000);
        ElectricCar vehicle4 = new ElectricCar("Tesla", "Model 3", 2023, "White", 4, 75);

        vehicle2.vehicleInfo();
        vehicle3.vehicleInfo();
        vehicle4.vehicleInfo();

    }

    private static Car getCar(Scanner scanner) {
        System.out.println("Car: ");
        System.out.print("\t Number of doors: ");
        int numOfDoor = Integer.parseInt(scanner.nextLine());
        System.out.print("\t Make: ");
        String make = scanner.nextLine();
        System.out.print("\t Model: ");
        String model = scanner.nextLine();
        System.out.print("\t Color: ");
        String color = scanner.nextLine();
        System.out.print("\t Year: ");
        int year = Integer.parseInt(scanner.nextLine());

        return new Car(make, model, year, color, numOfDoor);
    }

}