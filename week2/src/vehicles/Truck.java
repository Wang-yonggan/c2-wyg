package vehicles;

public class Truck extends Vehicle {
    private static final int loader = 3;
    private int loader_now;
    private static final int payload = 5000;
    private double payload_now;

    public Truck(int wheels, double weight, int loader_now, double payload_now) {
        super(wheels, weight);
        this.loader_now = loader_now;
        this.payload_now = payload_now;
    }

    public void add_loader(int n) {
        loader_now += n;
        if (loader_now > loader)
            System.out.println("你超员了！");
    }

    public void add_payload(double n) {
        payload_now += n;
        if (payload_now > payload)
            System.out.println("你超载了!");
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.printf("这是一辆卡车，能载%d人，实载%d人", loader, loader_now);
        if (loader_now > loader)
            System.out.print(",你超员了");
        System.out.println();
        System.out.printf("这是一辆卡车，核载%dkg,你已装载%.1fkg", payload, payload_now);
        if (payload_now > payload)
            System.out.print("，你超载了");
        System.out.println();
        print___();
    }
}
