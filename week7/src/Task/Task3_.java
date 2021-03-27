import java.util.HashMap;

/**
 * @ClassName : Task3_
 * @Author : wang-yonggan
 * @Date: 2021-03-24 09:10
 */

public class Task3_ {
    public static int solution(int nums[]) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums)
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        final int[] sum = {0};
        System.out.print("唯一元素");
        hashMap.forEach((k, v) -> {
                    if (v == 1) {
                        System.out.print(k + "---");
                        sum[0] += k;
                    }
                }
        );
        System.out.println();
        return sum[0];
    }

    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 2, 3, 4, 4};
        System.out.println(solution(nums));
    }
}
