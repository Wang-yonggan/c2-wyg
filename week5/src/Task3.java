import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @ClassName : Task3
 * @Author : wang-yonggan
 * @Date: 2021-03-13 09:33
 */

public class Task3 {


    public static HashSet<ArrayList<Integer>> get(int nums[]) {
        Arrays.sort(nums);
        HashSet<ArrayList<Integer>> result = new HashSet<>();
        result.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= nums.length - i; j++) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int k = 0; k < i; k++)
                    temp.add(nums[k + j]);
                result.add(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {0};
        System.out.println(get(nums));
    }
}
