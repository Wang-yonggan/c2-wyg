import java.awt.*;

public abstract class Cell_abstract implements Cell_mpl {
    protected double height;
    protected double weight;
    protected String kind_of;
    protected String name;//自己名字，如小明
    public boolean live_flag = true;
    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean is_live() {
        return live_flag;
    }

    @Override
    public void get_x_y() {
        ;
    }

    @Override
    public void reborn() {
        live_flag=true;
    }

    @Override
    public void die() {
        live_flag=false;
    }


    @Override
    public void draw(Graphics g, int x, int y, int size) {
        ;
    }
    public abstract String get_kind_of();
    public static void main(String[] args) {
    }
}
