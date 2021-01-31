package vehicles;

public class Vehicle {
    private int wheels;
    private double weight;

    public void print___() {
        System.out.println("-------------------");
    }

    public Vehicle(int wheels, double weight) {
        this.wheels = wheels;
        this.weight = weight;
    }

    public void getInfo() {
        System.out.printf("车轮的个数：%d 车重：%.1f\n", wheels, weight);
    }
}
