import javax.swing.*;
import java.awt.*;

public class Play_machine {
    public void test_x_y(int x,int y,Field field){
        boolean is_meet=field.getNeig(1,10,2,true);
        System.out.println(is_meet);
    }

    public static void main(String[] args) {
        Field field = new Field(30, 30);
        int i, j;
        for (i = 0; i < field.getHeight(); i++) {
            for (j = 0; j < field.getWidth(); j++) {
                set_cell(i,j,field);
            }
        }
        View view = new View(field);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Cells");
        frame.add(view, BorderLayout.CENTER);
        JButton button = new JButton("按钮");
        frame.add(button, BorderLayout.NORTH);
        frame.setSize(800, 800);
        frame.setVisible(true);
        int time = 0;
        Update up_date=new Update(field);
        while (time++<1000){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            up_date.begin();
            frame.repaint();
        }

    }
    public static void set_cell(int i,int j,Field field){
        double flag=Math.random();
        if (flag< 0.5) {
            Glass cell = new Glass();
            field.place(i, j, cell);
        } else if (flag < 0.8) {
            Rabbit cell=new Rabbit(1,1,"rab");
            field.place(i, j, cell);
        }else if(flag<0.88){
            Tiger cell=new Tiger(2,5,"tig");
            field.place(i, j, cell);
        }
        else {
            Cell_null cell_null=new Cell_null();
            field.place(i,j,cell_null);
        }

    }
}