package vehicles;

public class TestVehicle {
    public static void main(String[] args) {
        Car car = new Car(4, 2000, 3);
        Truck truck = new Truck(6, 5, 2, 1000);
        car.getInfo();
        truck.getInfo();
    }
}
