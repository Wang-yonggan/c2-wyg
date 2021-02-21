import java.util.Scanner;

/**
 * @ClassName : Task2
 * @Author : wang-yonggan
 * @Date: 2021-02-21 17:56
 */

public class Task2 {
    public static int findUnique(String str) {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            String c_str = String.valueOf(str.charAt(i));
            String pre = str.substring(0, i);
            String end = str.substring(i + 1, len);
            if (!pre.contains(c_str) && !end.contains(c_str))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(findUnique(str));
    }
}
