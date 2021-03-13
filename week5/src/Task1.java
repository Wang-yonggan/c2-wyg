import java.util.Scanner;

/**
 * @ClassName : Task1
 * @Author : wang-yonggan
 * @Date: 2021-03-13 09:17
 */

public class Task1 {
    public static int get_rev(int n) {
        if (n > Math.pow(2, 31) - 1 || n < -Math.pow(2, 31))
            return 0;
        int m = Math.abs(n);
        Integer result = (int) m / n;
        StringBuffer sbr = new StringBuffer(String.valueOf(m));
        sbr = sbr.reverse();
        return result * Integer.valueOf(String.valueOf(sbr));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(get_rev(x));
    }
}
