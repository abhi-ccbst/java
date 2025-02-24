package vehicle;

public class Vehicle {
    String make;
    String model;
    int year;
    String color;

    // Constructor to initialize Vehicle attributes
    public Vehicle(String make, String model, int year, String color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    // Method to display vehicle information
    public void vehicleInfo() {
        System.out.println("Vehicle Info: " + make + " " + model + " (" + year + ") - " + color);
    }
}
