import java.util.HashMap;

/**
 * @ClassName : Task4
 * @Author : wang-yonggan
 * @Date: 2021-02-12 00:44
 */

public class Task4 {
    public static HashMap wordCount(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : str.toCharArray())
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        return hashMap;
    }

    public static void main(String[] args) {
        System.out.println(wordCount("abc wanggyonggan and you"));
    }
}
