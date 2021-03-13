import java.util.Scanner;

/**
 * @ClassName : Task2
 * @Author : wang-yonggan
 * @Date: 2021-03-13 09:27
 */

public class Task2 {

    public static int floors(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return floors(n - 1) + floors(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(floors(n));
    }
}
