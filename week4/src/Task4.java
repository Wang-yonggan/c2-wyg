import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName : Task4
 * @Author : wang-yonggan
 * @Date: 2021-02-21 19:03
 */

public class Task4 {
    public static int findMin(int nums[], int k) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Set<Integer> set = new HashSet<Integer>(list);
        return (int) set.stream().toArray()[k];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 10, 5, 0};
        System.out.println(findMin(nums, 3));
    }
}
