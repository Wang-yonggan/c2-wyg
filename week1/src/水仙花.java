
import java.util.Arrays;
import java.util.Scanner;

public class 水仙花 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, cnt = 0, sum = 0;
        num = in.nextInt();
        int nw_num = num;
        int[] nums = new int[4];//nums存储数字的各个位
        while (num > 0) {
            int temp = num % 10;
            nums[cnt] = temp * temp * temp;
            num = num / 10;
            cnt++;
        }
        if (Arrays.stream(nums).sum() == nw_num)
            System.out.println("是水仙花数");
        else
            System.out.println("不是水仙花数");
    }

}
