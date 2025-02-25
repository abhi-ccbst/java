import vehicle.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle vehicle1 = getVehicle(scanner);
        Car vehicle2 = getCar(scanner);
        Truck vehicle3 = new Truck("Ford", "F-150", 2022, "Black", 10000);
        ElectricCar vehicle4 = new ElectricCar("Tesla", "Model 3", 2023, "White", 4, 75);

        vehicle1.vehicleInfo();
        vehicle2.vehicleInfo();
        vehicle3.vehicleInfo();
        vehicle4.vehicleInfo();

        System.out.println("\n#####\n");
        OuterClass outerClass = new OuterClass();
        System.out.println(outerClass.x);
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        System.out.println(innerClass.y);
    }

    private static Vehicle getVehicle(Scanner scanner) {
        Vehicle vehicle = new Vehicle();
        System.out.println("Vehicle");
        System.out.print("\t Make: ");
        vehicle.setMake(scanner.nextLine());
        System.out.print("\t Model: ");
        vehicle.setModel(scanner.nextLine());
        System.out.print("\t Color: ");
        vehicle.setColor(scanner.nextLine());
        System.out.print("\t Year: ");
        vehicle.setYear(Integer.parseInt(scanner.nextLine()));
        return vehicle;
    }

    private static Car getCar(Scanner scanner) {
        System.out.println("Car: ");
        System.out.print("\t Number of doors: ");
        int numOfDoor = Integer.parseInt(scanner.nextLine());
        return new Car(getVehicle(scanner), numOfDoor);
    }

}