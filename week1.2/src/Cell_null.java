import java.awt.*;

public class Cell_null extends Cell_abstract{
    private String big_kind="null";

    @Override
    public String get_big_kind() {
        return big_kind;
    }

    @Override
    public void draw(Graphics g, int x, int y, int size) {
        g.setColor(new Color(255,255,255));
        g.fillRect(x,y,size,size);
    }

    @Override
    public String get_kind_of() {
        return "null";
    }
}
