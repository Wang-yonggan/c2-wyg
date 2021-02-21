import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName : Task5
 * @Author : wang-yonggan
 * @Date: 2021-02-21 20:57
 */

public class Task5 {
    public static int findMain(int nums[]) {
        int len = nums.length;
        if (len == 0)
            return nums[0];
        Arrays.sort(nums);
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.toArray();
        System.out.println(list);
        for (int i = 0; i < len / 2; i++) {
            //[i,i+len/2]的元素个数为：偶：len/2+1,奇：int(len/2)+1
            if (nums[i] == nums[i + len / 2])
                return nums[i];
            //如果后面的数字等于它前一个，那就不会有数字占一半
            if (nums[i + len / 2] != nums[i + len / 2 - 1])
                break;
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {10, 9, 2, 2, 2, 2, 22, 2, 80};
        System.out.println(findMain(nums));
    }
}
