import java.util.HashMap;

class Nei_map {
    private HashMap<Integer[], Cell_mpl> cell_mplHashMaps = new HashMap<>();
    public HashMap<Integer[], Cell_mpl> get_nei_map(int x, int y) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                Integer temp[]={x+i,y+j};
                if ((i == 0 && j == 0) || i + x >= 30 || j + y >= 30 || i + x < 0 || j + y < 0) {
//                    Cell_out cell_temp = new Cell_out();
//                    cell_mplHashMaps.put(temp, cell_temp);
                    ;
                } else {
                    Cell_null cell_temp = new Cell_null();
                    cell_mplHashMaps.put(temp, cell_temp);
                }
            }
        }
        return cell_mplHashMaps;
    }
}

public class Field {
    private int width;
    private int height;
    private Cell_mpl[][] field_square;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        this.field_square = new Cell_mpl[width][height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell_mpl place(int h, int w, Cell_mpl o) {
        Cell_mpl ret = field_square[h][w];
        field_square[h][w] = o;
        return ret;
    }

    public Cell_mpl get(int x, int y) {
        return field_square[x][y];
    }

//    public boolean getNeig(int x, int y, int std) {
//        return getNeig(x, y, std, false);
//    }

    public HashMap<Integer[], Cell_mpl> get8Neig(int x, int y) {
        Nei_map mp = new Nei_map();
        HashMap<Integer[], Cell_mpl> cell_mplHashMaps = mp.get_nei_map(x, y);
        for(Integer[]k:cell_mplHashMaps.keySet()){
            Cell_mpl cell=field_square[k[0]][k[1]];
            cell_mplHashMaps.put(k,cell);
        }
        return cell_mplHashMaps;
    }

    public boolean getNeig(int x, int y, int std, boolean singal) {
        int nei = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if ((i == 0 && j == 0) || i + x >= 30 || j + y >= 30 || i + x < 0 || j + y < 0)
                    continue;
                if (field_square[i + x][j + y].is_live()) {
                    nei++;
                    if (singal)
                        System.out.printf("它的第%d个邻居%d,%d\t", nei, i, j);
                }
            }
        }
        if (nei == 2 || nei == 3)
            return true;
        else
            return false;
    }

    public int get_bore() {
        int bore = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (field_square[i][j].is_live())
                    bore++;
            }
        }
        return bore;
    }
}
