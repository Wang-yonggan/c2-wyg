package Tasks;

import java.util.Arrays;

public class Task3 {
    public static int isIt(String word, String[] lits, int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (word.endsWith(lits[i]))
                return 1;
            else if (word.startsWith(lits[i])) {
                result += isIt(word.substring(lits[i].length()), lits, n);
            }
        }
        return result;
    }

    public static String getThem(String[] bigs, String[] lits) {
        Arrays.sort(bigs);
        for (int i = bigs.length - 1; i >= 0; i--) {
            if (isIt(bigs[i], lits, lits.length) > 0)
                return bigs[i];
        }
        return "";
    }

    public static void main(String[] args) {
        String[] words = {"sdas", "wang", "yong", "gan", "wangyongwang"};
        int max = words[0].length();
        for (int i = 1; i < words.length; i++) {
            max = Math.max(max, words[i].length());
        }
        int big_len = 0;
        int little_len = 0;
        String[] bigs = new String[words.length];
        String[] littles = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == max)
                bigs[big_len++] = words[i];
            else littles[little_len++] = words[i];
        }
        String result = getThem(Arrays.copyOfRange(bigs, 0, big_len), Arrays.copyOfRange(littles, 0, little_len));
        System.out.println(result);
    }
}
