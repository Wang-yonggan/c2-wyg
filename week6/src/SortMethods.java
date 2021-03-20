import java.util.Arrays;

/**
 * @ClassName : SortMethods
 * @Author : wang-yonggan
 * @Date: 2021-03-17 12:05
 */

public class SortMethods {

    public static void heap_sort(int nums[]) {
        /**
         * @堆排序关键：
         */


    }

    public static void mao_pao(int nums[]) {
        /**
         *@冒泡排序关键：把最大值移到后面
         */
        int len = nums.length;
        while (len >= 1) {
            for (int i = 1; i < len; i++)
                if (nums[i] < nums[i - 1]) {
                    int t = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = t;
                }
            len--;
        }
    }

    public static void insert_sort(int nums[]) {
        /**
         *@插入排序关键：多判断for直接判断插入
         */
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
//                    if (nums[j] <= nums[i] || j == 0)   //选到-->插入
//                    {
//                        if (j == 0&&nums[j]>nums[i]) j--;//最小的情况，插入到第0位
//                        int temp = nums[i];
//                        for (int k = i; k >= j + 2; k--)
//                            nums[k] = nums[k - 1];
//                        nums[j + 1] = temp;
//                        break;
//                    }
            }
        }
    }

    public static void he_bing(int nums[]) {
        /**
         *@合并/归并插入关键：分治->合并(覆盖)
         */
        int len = nums.length;
        if (len == 1)
            return;
//        if (len == 2) {
//            if (nums[0] > nums[1]) {
//                int temp = nums[0];
//                nums[0] = nums[1];
//                nums[1] = temp;
//            }
//            return;
//        }
        int[] nums1 = Arrays.copyOfRange(nums, 0, len / 2);
        int[] nums2 = Arrays.copyOfRange(nums, len / 2, len);
        he_bing(nums1);
        he_bing(nums2);
        int t1 = 0, t2 = 0, t = 0;
        while (t < len && t1 < len / 2 && t2 < nums2.length) {
            if (nums1[t1] < nums2[t2])
                nums[t++] = nums1[t1++];
            else
                nums[t++] = nums2[t2++];
        }
        while (t1 < len / 2)
            nums[t++] = nums1[t1++];
        while (t2 < nums2.length)
            nums[t++] = nums2[t2++];
    }

    public static void fast_sort(int nums[]) {
        /**
         *@快速排序关键：治->分治(l>r而不是l>=r)->合并(覆盖)
         */
        int len = nums.length;
        if (len <= 1) return;
        int r = 0, l = len - 1, now = nums[0];
        while (l > r) {
            for (; l > r; l--)
                if (nums[l] < now) {
                    nums[r] = nums[l];
                    break;
                }
            for (; l > r; r++)
                if (nums[r] > now) {
                    nums[l] = nums[r];
                    break;
                }
        }
        nums[l] = now;
        int nums1[] = Arrays.copyOfRange(nums, 0, l);
        int nums2[] = Arrays.copyOfRange(nums, l + 1, len);
        fast_sort(nums1);
        fast_sort(nums2);
        System.arraycopy(nums1, 0, nums, 0, l);
        for (int i = l + 1; i < len; i++)
            nums[i] = nums2[i - l - 1];
    }

    public static void dui_sort(int nums[]) {


    }

    public static void main(String[] args) {

        int nums[] = {1, 4, 2, 6, 0};
        //int nums[] = {1, 2, 3};
        for (int num : nums) System.out.printf("%d--", num);
        System.out.println();
        //mao_pao(nums);
        //insert_sort(nums);
        //he_bing(nums);
        fast_sort(nums);
        for (int num : nums) System.out.printf("%d--", num);
        System.out.println("\n如有报错或排序错误，请告知!");
    }
}
