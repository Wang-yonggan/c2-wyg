import java.util.ArrayList;
import java.util.Scanner;

public class FindNumber {
    public static ArrayList<Integer> findNum(String str) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c))
                array.add((int) c - '0');
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(findNum(str));
    }
}
