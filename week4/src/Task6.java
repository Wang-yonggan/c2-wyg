import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName : Task6
 * @Author : wang-yonggan
 * @Date: 2021-02-21 21:17
 */

public class Task6 {
    public static boolean ifMatch(char c1, char c2) {
        //确保c1是起始符
        if (c1 > c2) {
            char temp = c1;
            c1 = c2;
            c2 = temp;
        }
        if ((c1 == '[' && c2 == ']') || (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}'))
            return true;
        return false;
    }

    public static boolean ifAvailable(String str) {
        Stack<Character> sk = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c1 = str.charAt(i);
            if (c1 == '}' || c1 == ']' || c1 == ')') {
                if (sk.isEmpty())
                    return false;
                char c2 = sk.pop();
                if (!ifMatch(c1, c2))
                    return false;
            } else sk.push(c1);
        }
        if (sk.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        //String str="[[[][][[]][[]]]";
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(ifAvailable(str));
    }
}
