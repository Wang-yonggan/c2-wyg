import java.awt.*;

public interface Cell_mpl {
    boolean is_live();
    void get_x_y();
    void reborn();
    void die();
    String get_big_kind();
    void draw(Graphics g, int x, int y, int size);
}
