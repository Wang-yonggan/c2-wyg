import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName : Target
 * @Author : wang-yonggan
 * @Date: 2021-02-11 17:52
 * 思想：①先将数组排序
 * ②从第一个开始，对于每一个nums[i],问题简化为寻找nums[i+1,i+2...lenth-1]中的两个相加和为target-nums[i]
 */

public class Target {
    public static List<List> threeSum(int[] nums, int target) {
        int[] nums_copy = nums.clone();
        int len = nums_copy.length;
        Arrays.sort(nums_copy);//排序
        HashSet<int[]> result_hash = new HashSet<int[]>();
        List<List> result_list = new ArrayList<>();
        System.out.println(Arrays.toString(nums_copy));
        //对于每一个i，调用towSum方法找它对应的两个数字
        for (int i = 0; (nums_copy[i] <= target / 3) && (i < len - 2); i++) {
            ArrayList<int[]> result_temp = towSum(Arrays.copyOfRange(nums_copy, i + 1, len), target - nums_copy[i]);
            if (result_temp == null)
                continue;
            for (int[] arr : result_temp)
                result_hash.add(new int[]{nums_copy[i], arr[0], arr[1]});
        }
        //hashset表转换成list
        for (int[] arr : result_hash) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i : arr) temp.add(i);
            result_list.add(temp);
        }
        return result_list;
    }

    public static ArrayList<int[]> towSum(int[] nums, int target) {
        int len = nums.length, next = len;
        ArrayList<int[]> result = new ArrayList<>();
        //对于每一个i，找它对应的另一个数字
        for (int i = 0; nums[i] <= target / 2 && i < len; i++) {
            for (int j = i + 1; j < next; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    next = j;//next的后面太小就不用看了
                    result.add(new int[]{nums[i], nums[j]});
                    break;
                }
            }
        }
        return result;
    }

    public static int[] towSum1(int[] nums, int target) {
        ArrayList list = new ArrayList();
        list.add(nums[0]);
        int result[] = new int[2];
        for (int i = 1; i < nums.length; i++) {
            if (list.contains(target - nums[i])) {
                result[0] = list.indexOf(target - nums[i]);
                result[1] = i;
            }
            list.add(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List> result = threeSum(new int[]{1, 2, 3, 4, 3, 5, 6, 7, 8, 8, 100}, 17);
        System.out.println(result);
    }
}

