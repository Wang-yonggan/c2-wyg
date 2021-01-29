import java.util.HashMap;

public class Update {
    private Field field;

    public Update(Field field) {
        this.field = field;
    }

    public void glass_begin(int x, int y, Glass glass) {
        //0.8概率下，草周围的草会重生
        HashMap<Integer[], Cell_mpl> cell_mplHashMap = field.get8Neig(x, y);
        for (Integer[] k : cell_mplHashMap.keySet()) {
            Cell_mpl cell = cell_mplHashMap.get(k);
            if (cell.get_big_kind() == "null" && Math.random() < 0.8)
                cell.reborn();
        }
        if (Math.random() < 0.03)
            glass.die();//0.03的概率死亡
    }

    public void animal_begin(int x, int y, Animal animal) {
        //吃掉周围的事物
        HashMap<Integer[], Cell_mpl> cell_mplHashMap = field.get8Neig(x, y);
        boolean is_baby = false;
        boolean is_move= false;
        for (Integer[] k : cell_mplHashMap.keySet()) {
            Cell_mpl cell = cell_mplHashMap.get(k);
            if (cell.is_live() && cell.get_big_kind().equals(animal.get_food())) {
                animal.eat((Cell_abstract) cell);//吃掉
            }
            else if ((Math.random() < 0.1) && (cell.get_big_kind().equals("null"))) {
                if (animal.kind_of == "Rabbit") {
                    Rabbit rabbit = new Rabbit(1, 1, "rab");
                    field.place(k[0], k[1], rabbit);
                } else if (animal.kind_of == "Tiger") {
                    Tiger tiger = new Tiger(2, 5, "tig");
                    field.place(k[0], k[1], tiger);
                }
            }
            //0.5*1/8的概率移动的这个位置
            else if((Math.random()<0.5*1/8)&&cell.get_big_kind()=="null"||!cell.is_live()){
                field.place(k[0],k[1],animal);
                Cell_null cell_null=new Cell_null();
                field.place(x,y,cell_null);
            }

        }
        if (Math.random() < 0.03)
            animal.die();//0.03的概率死亡
    }
    public void begin() {
        int w = field.getWidth(), h = field.getHeight();
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                Cell_mpl cell = field.get(x, y);
                if (!cell.is_live()) {
                    Cell_null cell_null = new Cell_null();
                    field.place(x, y, cell_null);
                }
                if (cell.get_big_kind().equals("Glass"))
                    glass_begin(x, y, (Glass) cell);
                else if (cell.get_big_kind().equals("animal")) {
                    animal_begin(x, y, (Animal) cell);
                } else if (cell.get_big_kind().equals("null")) {
                    Glass glass = new Glass();
                    field.place(x, y, glass);
                }
            }
        }
    }
}
