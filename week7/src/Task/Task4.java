/**
 * @ClassName : Task4
 * @Author : wang-yonggan
 * @Date: 2021-03-24 08:50
 */

public class Task4 {
    public static int[] solution(int[] nums, int k) {
        /**
         * @滑动窗口关键 确定i+k<=len
         */
        int len = nums.length;
        int result[] = new int[len - k + 1];
        for (int i = 0; i + k <= len; i++) {
            int max = nums[i];
            for (int j = 1; j < k; j++) {
                max = Math.max(max, nums[i + j]);
            }
            result[i] = max;
        }
        return result;

    }

    public static void main(String[] args) {
        int nums[] = {5, 1, -5, 0, 10, 1, 11, 20};
        for (int k : solution(nums, 3))
            System.out.print(k + "---");

    }
}
