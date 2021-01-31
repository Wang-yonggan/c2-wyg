package vehicles;

public class Car extends Vehicle {
    private static final int loader = 5;
    private int loader_now;

    public Car(int wheels, double weight, int loader_now) {
        super(wheels, weight);
        this.loader_now = loader_now;
    }

    public void add_loader(int n) {
        loader_now += n;
        if (loader_now > loader)
            System.out.println("你超员了!");
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.printf("这是一辆小车，能载%d人，实载%d人", loader, loader_now);
        if (loader_now > loader)
            System.out.print(",你超员了!");
        System.out.println();
        print___();
    }
}
