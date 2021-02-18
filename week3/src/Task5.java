import java.util.Scanner;

/**
 * @ClassName : Task5
 * @Author : wang-yonggan
 * @Date: 2021-02-12 00:49
 */

/**
 * throw new Exception(str)语句是抛出异常的意思,就像执行3/0
 * 可以与if语句结合---条件异常
 */


class TempException1 extends Exception {
    //必须处理的异常
    public TempException1() {
    }

    public TempException1(String message) {
        super(message);
    }
}

class TempException2 extends RuntimeException {
    //不必须处理的异常
    public TempException2() {
    }

    public TempException2(String message) {
        super(message);
    }
}


public class Task5 {
    public static int getNum1(int[] nums, int index) throws TempException1 {
        //throws
        if (index >= nums.length || index < 0)
            throw new TempException1("下标错误1--->退出throws函数");
        System.out.println("getNul1结束");
        return nums[index];
    }

    public static int getNum11(int[] nums, int index) {
        if (index >= nums.length || index < 0)
            try {
                throw new TempException1("下标错误11--->退出try");
            } catch (TempException1 tempException1) {
                tempException1.printStackTrace();
                System.out.println("函数失败,返回-1");
                return -1;
            }
        System.out.println("getNul11结束");
        return nums[index];
    }


    public static int getNum2(int[] nums, int index) {
        if (index >= nums.length || index < 0)
            throw new TempException2("下标错误2--->直接抛出,结束所有进程");
        System.out.println("getNul2结束");
        return nums[index];
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 4};
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println(getNum1(nums, sc.nextInt()));
        } catch (TempException1 e) {
            e.printStackTrace();
        } finally {
            System.out.println("这是finally");
        }
        System.out.println(getNum11(nums, sc.nextInt()));
        System.out.println(getNum2(nums, sc.nextInt()));

        System.out.println("main结束");
    }

}
