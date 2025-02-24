package vehicle;

/**
 * This class hold different car objects
 * */

public class Car extends Vehicle {
    int numberOfDoors;

    // Constructor to initialize Car attributes
    public Car(String make, String model, int year, String color, int numberOfDoors) {
        super(make, model, year, color);  // Call to the parent class constructor
        this.numberOfDoors = numberOfDoors;
    }

    // Overriding the vehicleInfo method to include number of doors
    @Override
    public void vehicleInfo() {
        System.out.println("Vehicle Info: " + make + " " + model + " (" + year + ") - " + color + ", Doors: " + numberOfDoors);
    }
}
