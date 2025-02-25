package vehicle;

public abstract class Vehicle {
    private String make;
    private String model;
    private int year;
    private String color;

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


    // Constructor to initialize Vehicle attributes
    public Vehicle(String make, String model, int year, String color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    // Method to display vehicle information
    public abstract void vehicleInfo();

}
