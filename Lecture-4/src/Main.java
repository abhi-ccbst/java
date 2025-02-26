import animals.Cat;
import animals.Dog;
import enums.Level;
import vehicle.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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
        arrayList();
        linkedList();
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


    private static void arrayList() {
        System.out.println("\n\nArrayList: ");

        ArrayList<Integer> cars = new ArrayList<>();
        cars.add(1);
        cars.add(5);
        cars.add(3);
        cars.add(7);
        cars.add(6);
        cars.add(11);
        System.out.println("cars.get(): " + cars.get(0));

        cars.set(0, 100);
        System.out.println("cars.set(): " + cars.get(0));

        cars.remove(0);
        System.out.println("cars.remove: " + cars.get(0));
        System.out.println("cars size: " + cars.size());
//        cars.clear();
        System.out.println("cars size: " + cars.size());
        for (Integer car: cars) {
            System.out.println(car);
        }
        /*
        * 0 -> BMW
        * 1 -> Audi
        * */
        System.out.println("cars sort: ");
        Collections.sort(cars, Collections.reverseOrder());
        for (Integer car: cars) {
            System.out.println(car);
        }
    }

    private static void linkedList() {
        System.out.println("\n\nLinkedList: ");

        LinkedList<String> cars = new LinkedList<>();
        cars.add("Ford");
        cars.add("BMW");
        cars.add("Audi");
        System.out.println("cars.get(): " + cars.get(0));

        cars.set(0, "Volvo");
        System.out.println("cars.set(): " + cars.get(0));

        cars.remove(0);
        System.out.println("cars.remove: " + cars.get(0));
        System.out.println("cars size: " + cars.size());
        cars.clear();
        System.out.println("cars size: " + cars.size());
        /*
        * Ford -> BMW -> Audi
        * */
    }


}