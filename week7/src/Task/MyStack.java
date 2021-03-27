/**
 * @ClassName : MyStack
 * @Author : wang-yonggan
 * @Date: 2021-03-24 09:17
 */

public class MyStack {

    public static boolean solution(int nums1[], int nums2[]) {
        int r1 = 0;
        int r2 = 0;
        int stack[] = new int[nums1.length];
        int top = 0;
        for (; r1 < nums1.length; r1++) {
            if (nums1[r1] == nums2[r2]) {
                r2++;//进栈+出栈
                System.out.println("push:" + nums1[r1]);
                System.out.println("pop:" + nums1[r1]);
            } else {
                stack[top++] = nums1[r1];//进栈
                System.out.println("push:" + nums1[r1]);
            }
        }
        while (top > 0) {
            if (stack[--top] != nums2[r2++])
                return false;
            System.out.println("pop:" + stack[top]);
        }
        return true;
    }

    public static void main(String[] args) {
        int nums1[] = {1, 2, 3, 4, 5};
        int nums2[] = {4, 5, 3, 2, 1};
        System.out.println(solution(nums1, nums2));


    }
}
