package vehicle;

public class ElectricCar extends Car {
    int batteryCapacity;

    // Constructor to initialize ElectricCar attributes
    public ElectricCar(String make, String model, int year, String color, int numberOfDoors, int batteryCapacity) {
        super(make, model, year, color, numberOfDoors);  // Call to the parent class constructor
        this.batteryCapacity = batteryCapacity;
    }

    // Overriding the vehicleInfo method to include battery capacity
    @Override
    public void vehicleInfo() {
        System.out.println("Vehicle Info: " + make + " " + model + " (" + year + ") - " + color + ", Doors: " + numberOfDoors + ", Battery Capacity: " + batteryCapacity + "kWh");
    }
}