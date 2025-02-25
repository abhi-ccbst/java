import animals.Cat;
import animals.Dog;
import enums.Level;
import vehicle.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Car vehicle2 = getCar(scanner);
        Truck vehicle3 = new Truck("Ford", "F-150", 2022, "Black", 10000);
        ElectricCar vehicle4 = new ElectricCar("Tesla", "Model 3", 2023, "White", 4, 75);

//        vehicle2.vehicleInfo();
//        vehicle2.print();
        vehicle3.vehicleInfo();
        vehicle4.vehicleInfo();

        Cat cat = new Cat();
        cat.makeSound();
        cat.move();
        cat.print();

        Dog dog = new Dog();
        dog.makeSound();
        dog.move();
        dog.play();
        dog.sleep();

        Level myVar = Level.MEDIUM;

        switch(myVar) {
            case LOW:
                System.out.println("Low level");
                break;
            case MEDIUM:
                System.out.println("Medium level");
                break;
            case HIGH:
                System.out.println("High level");
                break;
        }
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