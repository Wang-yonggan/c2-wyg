import java.awt.*;

public class Rabbit extends Animal {
    private static String food="Glass";
    private static String kind_of="Rabbit";
    public Rabbit(double height, double weight, String name) {
        super(height, weight, name);
    }
    public String getFood(){
        return food;
    }
    public String getKind_of(){
        return kind_of;
    }
    public String get_food(){
        return food;
    }
    @Override
    public void draw(Graphics g, int x, int y, int size) {
        g.setColor(new Color(254,217,0));//黄色
        if(live_flag)
            g.fillRect(x,y,size,size);
    }

    @Override
    public String get_kind_of() {
        return kind_of;
    }

}
