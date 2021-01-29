import java.awt.*;

public class Tiger extends Animal {
    private static String kind_of="Tiger";
    private static String food="meat";
    // 这些不变的就在子类里面定义。
    public Tiger(double height, double weight, String name) {
        super(height, weight, name);
    }
    public String get_food(){
        return food;
    }
    @Override
    public void get_info() {
        print___();
        super.get_info();
        System.out.printf("种类:%s\n",kind_of);
        print___();
    }
    @Override
    public void draw(Graphics g, int x, int y, int size) {
        g.setColor(new Color(216,59,1));//红色
        if(live_flag)
            g.fillRect(x,y,size,size);
    }

    @Override
    public String get_kind_of() {
        return kind_of;
    }
}
