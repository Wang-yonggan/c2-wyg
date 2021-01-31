import java.util.ArrayList;
import java.util.Scanner;

public class FindPrefix {
    /*
    按0表示输入结束--->Line 29
     */
    public static String findPre(ArrayList<String> strings) {
        String prefix = "";
        String first = strings.get(0);
        for (int i = 0; i < first.length(); i++) {
            String prefix_now = prefix;
            prefix += first.charAt(i);
            for (int j = 1; j < strings.size(); j++) {
                if (!strings.get(j).startsWith(prefix)) {
                    prefix = prefix_now;
                    break;
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean is_input = true;
        String added = sc.nextLine();
        while (is_input && !added.equals("0")) {
            strings.add(added);
            added = sc.nextLine();
        }
        String s = findPre(strings);
        System.out.println(s);
    }

}
