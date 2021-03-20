import java.util.ArrayList;

/**
 * @ClassName : Task1
 * @Author : wang-yonggan
 * @Date: 2021-03-17 11:25
 */


public class PrintMat {
    public static void print_mat(int mat[][], ArrayList result, int hang_b, int lie_b, int hang_yu, int lie_yu) {
        /**
         * @params:
         * hang_b  从hang_b行开始
         * lie_b   从lie_b列开始
         * hang_yu  余下多少行
         * lie_yu 余下多少列
         *
         */
        int hang = mat.length;
        int lie = mat[0].length;
        if (hang_yu == 0 || lie_yu == 0)
            return;
        if (hang_yu == 1) {
            for (int i = lie_b; i < lie - lie_b; i++) result.add(mat[hang_b][i]);
            return;
        }
        if (lie_yu == 1) {
            for (int i = hang_b; i < hang - hang_b; i++) result.add(mat[i][lie_b]);
            return;
        }
        for (int i = lie_b; i < lie - lie_b; i++)
            result.add(mat[hang_b][i]);
        for (int i = hang_b + 1; i < hang - hang_b; i++)
            result.add(mat[i][lie - lie_b - 1]);
        for (int i = lie - lie_b - 2; i >= lie_b; i--)
            result.add(mat[hang - hang_b - 1][i]);
        for (int i = hang - hang_b - 2; i >= hang_b + 1; i--)
            result.add(mat[i][lie_b]);
        print_mat(mat, result, hang_b + 1, lie_b + 1, hang_yu - 2, lie_yu - 2);

    }

    public static void main(String[] args) {
        //测试数据1
        int mat[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ArrayList<Integer> result = new ArrayList<>();
        print_mat(mat, result, 0, 0, mat.length, mat[0].length);
        System.out.println(result);


        //测试数据2
        int mat1[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        ArrayList<Integer> result1 = new ArrayList<>();
        print_mat(mat1, result1, 0, 0, mat1.length, mat1[0].length);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                System.out.printf("%d\t", mat1[i][j]);
            System.out.println();
        }
        System.out.println(result1);
    }

}
