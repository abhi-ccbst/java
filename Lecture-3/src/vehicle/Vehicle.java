package vehicle;

public class Vehicle {
    private String make;
    private String model;
    private int year;
    private String color;

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Vehicle() {}

    public Vehicle(Vehicle vehicle) {
        this.make = vehicle.getMake();
        this.model = vehicle.getModel();
        this.year = vehicle.getYear();
        this.color = vehicle.getColor();
    }

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
