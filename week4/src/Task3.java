import java.util.Scanner;

/**
 * @ClassName : Task3
 * @Author : wang-yonggan
 * @Date: 2021-02-21 18:09
 */

public class Task3 {
    public static boolean isInt(double f) {
        if (f == (float) (int) f) return true;
        return false;
    }

    public static int[] getFenShu(double f) {
        double fen_mu = f;
        float fen_zi = 1;
        while (!isInt(fen_mu)) {
            fen_mu *= 10;
            fen_zi *= 10;
        }
        while (isInt(fen_mu / 5) && isInt(fen_zi / 5)) {
            fen_mu /= 5;
            fen_zi /= 5;
        }
        while (isInt(fen_mu / 2) && isInt(fen_zi / 2)) {
            fen_mu /= 2;
            fen_zi /= 2;
        }
        int[] result = {(int) fen_mu, (int) fen_zi};
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double f = sc.nextDouble();
        int[] result = getFenShu(f);
        System.out.println(result[0] + "/" + result[1]);
    }
}
