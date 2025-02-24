public class Main {
    public static void main(String[] args) {

        Car fordCar = new Car(2013, "ford", "fusion-se");
        fordCar.setName("Ford");
        System.out.println(fordCar.getName());

        Car bmwCar = new Car(2024, "BMW", "m4");
        System.out.println(bmwCar.getName());
    }
}