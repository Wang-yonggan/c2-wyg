import javax.swing.*;
import java.awt.*;

public class View extends JPanel {
    private static final int size=20;
    private Field thefiled;
    private int i,j;
    public View(Field thefiled){
        this.thefiled=thefiled;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(i=0;i<thefiled.getHeight();i++){
            for(j=0;j<thefiled.getWidth();j++){
                Cell_mpl cell=thefiled.get(i,j);
                if(cell!=null);
                    cell.draw(g,i*size,j*size,size);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return super.getPreferredSize();
    }
}
