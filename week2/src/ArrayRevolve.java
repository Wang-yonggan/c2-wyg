import java.util.ArrayList;
import java.util.Scanner;

class ArrayRevolve {
    private ArrayList<ArrayList<Integer>> mat;
    private int n; //n*n矩阵
    private boolean is_transpose = false;

    public ArrayRevolve(ArrayList<ArrayList<Integer>> mat) {
        this.mat = mat;
        this.n = mat.size();
    }

    public ArrayList<ArrayList<Integer>> getMat() {
        return mat;
    }

    public ArrayList<Integer> arrayReverse(ArrayList<Integer> a) {
        //将数组逆序
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = 0; i < n; i++)
            b.add(a.get(n - i - 1));
        return b;
    }

    public void matTranspose() {
        //矩阵转置
        Integer temp1, temp2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                ArrayList<Integer> arr_i = mat.get(i);//获取第i行
                ArrayList<Integer> arr_j = mat.get(j);
                temp1 = mat.get(i).get(j);
                temp2 = mat.get(j).get(i);//获取第j行的第i个
                arr_i.set(j, temp2);//第i行的第j个换成第j行的第i个
                arr_j.set(i, temp1);
                mat.set(i, arr_i);
                mat.set(j, arr_j);
            }
        }
        is_transpose = true;
    }

    public void matRrevolve() {
        if (!is_transpose)
            this.matTranspose();
        for (int i = 0; i < n; i++) {
            mat.set(i, this.arrayReverse(mat.get(i)));//第i行逆置
        }
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean is_input = false;//是否输入原矩阵，false则会用k++创建矩阵
        int k = 1;
        for (int i = 0; i < 4; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                if (is_input) {
                    temp.add(sc.nextInt());
                } else {
                    temp.add(k);
                    k++;
                }
            }
            mat.add(temp);
        }
        System.out.println(mat);
        ArrayRevolve s = new ArrayRevolve(mat);
        s.matRrevolve();
        System.out.println(s.getMat());
    }

}