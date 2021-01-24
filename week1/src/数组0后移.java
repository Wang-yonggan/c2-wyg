import java.util.Scanner;

//原地置换
public class 数组0后移 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = in.nextInt();
        }
        int last = 0, first = 0, temp, cnt = 0;
        while (last < nums.length) {
            if (nums[last] != 0) {       //如果last指向的不为0，与第一个0（即first）交换
                if (cnt == 0)
                    first++;//特殊情况，还未出现0
                else {
                    temp = nums[first];
                    nums[first] = nums[last];
                    nums[last] = 0;
                    first++;
                }
            } else
                cnt++;
            last++;
        }
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }
}