import java.util.Scanner;

/**
 * @ClassName : Task1
 * @Author : wang-yonggan
 * @Date: 2021-02-21 17:45
 */

public class Task1 {
    public static int findPattern(String str, String pattern) {
        if (!str.contains(pattern)) return -1;
        int index = 0, len = str.length();
        for (int i = 0; i <= len - pattern.length(); i++) {
            if (str.substring(i, len).startsWith(pattern))
                return i;
        }
        return -2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String pattern = sc.nextLine();
        System.out.println(findPattern(str, pattern));
    }
}
