import java.awt.*;

public class Glass extends Cell_abstract{
    private boolean is_live=true;

    private static String big_kind="Glass";//大类
    private static String kind_of="Glass";
    @Override
    public boolean is_live() {
        return is_live;
    }

    @Override
    public void get_x_y() {
        ;
    }

    @Override
    public void reborn() {
        is_live=true;
    }

    @Override
    public void die() {
        is_live=false;
    }

    @Override
    public String get_big_kind() {
        return big_kind;
    }

    @Override
    public void draw(Graphics g, int x, int y, int size) {
        g.setColor(new Color(92,218,81));//绿色
        if(is_live)
            g.fillRect(x,y,size,size);
    }

    @Override
    public String get_kind_of() {
        return kind_of;
    }
}
