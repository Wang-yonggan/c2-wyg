import java.util.Scanner;

/**
 * @ClassName : Task3
 * @Author : wang-yonggan
 * @Date: 2021-02-21 18:09
 */

public class Task3 {
    public static boolean isInt(double f) {
        if (f == (int) f) return true;
        String str = String.valueOf(f);
        str = str.replace("e", "E");
        if (str.contains("E")) {
            String[] split_e = str.split("E");
            if (Integer.valueOf(split_e[1]) >= split_e[0].length() - 2)
                return true;
        }
        return false;
    }

    public static long[] getFenShu(double f) {
        double fen_mu = f;
        double fen_zi = 1;
        int len = String.valueOf(fen_mu).split("\\.")[1].length();
        fen_zi *= Math.pow(10, len);
        fen_mu *= Math.pow(10, len);
        while (isInt(fen_mu / 5) && isInt(fen_zi / 5)) {
            fen_mu /= 5;
            fen_zi /= 5;
        }
        while (isInt(fen_mu / 2) && isInt(fen_zi / 2)) {
            fen_mu /= 2;
            fen_zi /= 2;
        }
        long[] result = {(long) fen_mu, (long) fen_zi};
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println(isInt(1.234567891234E15));
        double f = sc.nextDouble();
        long[] result = getFenShu(f);
        System.out.println(result[0] + "/" + result[1]);
    }
}
