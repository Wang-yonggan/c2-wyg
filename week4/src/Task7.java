import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName : Task7
 * @Author : wang-yonggan
 * @Date: 2021-02-21 21:54
 */

public class Task7 {
    public static ArrayList<ArrayList<String>> getStrings(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String str_sored = new String(chars);
            List list = hashMap.getOrDefault(str_sored, new ArrayList<>());
            list.add(str);
            hashMap.put(str_sored, list);
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (String str_sored : hashMap.keySet()) {
            result.add((ArrayList<String>) hashMap.get(str_sored));
        }
        return result;
    }


    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(getStrings(strs));
    }
}
