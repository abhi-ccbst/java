package vehicle;

/**
 * This class hold different car objects
 * */

public class Car extends Vehicle {
    private int numberOfDoors;

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    // Constructor to initialize Car attributes
    public Car(String make, String model, int year, String color, int numberOfDoors) {
        super(make, model, year, color);  // Call to the parent class constructor
        this.numberOfDoors = numberOfDoors;
    }

    public Car(Vehicle vehicle, int numberOfDoors) {
        super(vehicle);
        this.numberOfDoors = numberOfDoors;
    }
    // Overriding the vehicleInfo method to include number of doors
    @Override
    public void vehicleInfo() {
        System.out.println("Vehicle Info: " + getMake() + " " + getModel() + " (" + getYear() + ") - " + getColor() + ", Doors: " + getNumberOfDoors());
    }
}
