package Tasks;

import java.util.Scanner;

public class Task1 {
    private static String toBinary(String d, int wei) {
        double base = Math.pow(2, wei);
        double value = Double.valueOf(d);
        if (wei < -33)
            return "F";
        if (value == 0)
            return "";
        if (value >= base)
            return "1" + toBinary(String.valueOf((value - base)), --wei);
        else
            return "0" + toBinary(d, --wei);
    }

    public static void toBinary(double d) {
        String result = "0." + toBinary(String.valueOf(d), -1);
        if (result.contains("F")) {
            System.out.println("ERROR");
        } else System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();
        toBinary(num);
    }
}
