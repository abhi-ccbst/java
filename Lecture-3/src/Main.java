import vehicle.*;

public class Main {

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Toyota", "Corolla", 2020, "Blue");
        Car vehicle2 = new Car("Honda", "Civic", 2021, "Red", 4);
        Truck vehicle3 = new Truck("Ford", "F-150", 2022, "Black", 10000);
        ElectricCar vehicle4 = new ElectricCar("Tesla", "Model 3", 2023, "White", 4, 75);

        vehicle1.vehicleInfo();
        vehicle2.vehicleInfo();
        vehicle3.vehicleInfo();
        vehicle4.vehicleInfo();
    }
}