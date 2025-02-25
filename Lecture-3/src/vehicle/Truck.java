package vehicle;

public class Truck extends Vehicle {
    int payloadCapacity;

    // Constructor to initialize Truck attributes
    public Truck(String make, String model, int year, String color, int payloadCapacity) {
        super(make, model, year, color);  // Call to the parent class constructor
        this.payloadCapacity = payloadCapacity;
    }

    // Overriding the vehicleInfo method to include payload capacity
    @Override
    public void vehicleInfo() {
        System.out.println("Vehicle Info: " + getMake() + " " + getModel() + " (" + getYear() + ") - " + getColor() + ", Payload Capacity: " + payloadCapacity + "kg");
    }
}
