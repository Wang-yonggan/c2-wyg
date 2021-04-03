import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @ClassName : SortMethods
 * @Author : wang-yonggan
 * @Date: 2021-03-17 12:05
 */

public class SortMethods {
    public static void 计数排序(int nums[]) {
        //nums=[1,4,2,2]
        //适应问题  负数，小数，多码
        //效率问题  空间
        int max = nums[0];
        for (int i = 1; i < nums.length; i++)
            max = Math.max(max, nums[i]);
        int dic[] = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            dic[nums[i]]++;
        }
        int count = 0;
        for (int i = 0; i < dic.length && dic[i] > 0; i++)
            for (int j = 0; j < dic[i]; j++)
                nums[count++] = i;
        for (int n : nums) System.out.print(n + "\t");

    }

    public static void bucketSort(int[] nums) {

        // 计算最大值与最小值
        int max = nums[0];
        int min = max;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        // 计算桶的数量
        int bucketNum = (max - min) / nums.length + 1;
        //一种方法最大值最小值方法
        //(a-b)/c+1--->(x-b)/c+1
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        // 将每个元素放入桶
        for (int i = 0; i < nums.length; i++) {
            int num = (nums[i] - min) / (nums.length);
            bucketArr.get(num).add(nums[i]);
        }

        // 对每个桶进行排序
        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }

        // 将桶中的元素赋值到原序列
        int index = 0;
        for (int i = 0; i < bucketArr.size(); i++) {
            for (int j = 0; j < bucketArr.get(i).size(); j++) {
                nums[index++] = bucketArr.get(i).get(j);
            }
        }
    }


    public static void heap_down(int nums[], int i, int len) {
        int min_index = i;
        while (i * 2 + 1 < len) {
            int t1 = 2 * i + 1;
            int t2 = t1 + 1;
            if (t1 < len && nums[t1] < nums[i])
                min_index = t1;
            if (t2 < len && nums[t2] < nums[t1] && nums[t2] < nums[i])
                min_index = t2;
            if (min_index != i) {
                int temp = nums[min_index];
                nums[min_index] = nums[i];
                nums[i] = temp;
                i = min_index;
            } else break;
        }
    }

    public static void heap_sort(int nums[]) {
        /**
         * @堆排序关键：all_down-->one_out-->one_down

         */
        int n = nums.length;
        for (int i = (n - 1) / 2; i >= 0; i--)
            heap_down(nums, i, n);
        int new_nums[] = new int[n];
        int len = n;
        int i = 0;
        while (len > 0) {
            new_nums[i++] = nums[0];
            nums[0] = nums[len - 1];
            len--;
            heap_down(nums, 0, len);
        }
        for (i = 0; i < n; i++) {
            nums[i] = new_nums[i];
        }
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
         *@插入排序关键：多判断for直接判断插入 插入排序的平均时间复杂度也是 O(n^2)，空间复杂度为常数阶 O(1)，具体时间复杂度和数组的有序性也是有关联的。
        插入排序中，当待排序数组是有序时，是最优的情况，只需当前数跟前一个数比较一下就可以了，这时一共需要比较 N-1 次，时间复杂度为 O(N)。
        最坏的情况是待排序数组是逆序的，此时需要比较次数最多，最坏的情况是 O(n^2)。
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
         *@合并/归并插入关键：分治->合并(覆盖) 当有 n 个记录时，需进行 logn 轮归并排序(二分)，每一轮归并，其比较次数不超过 n，元素移动次数都是 n，
        因此，归并排序的时间复杂度为 O(nlogn)。归并排序时需要和待排序记录个数相等的存储空间，所以空间复杂度为 O(n)。
        归并排序适用于数据量大，并且对稳定性有要求的场景。
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
         *@快速排序关键：治->分治(l>r而不是l>=r)->合并(覆盖) 快速排序是一种比较快速的排序算法，它的平均运行时间是 O(nlogn)，
        之所以特别快是由于非常精练和高度优化的内部循环，最坏的情形性能为 O(n^2)。
        像归并一样，快速排序也是一种分治的递归算法。
        从空间性能上看，快速排序只需要一个元素的辅助空间，但快速排序需要一个栈空间来实现递归，空间复杂度也为O(logn)。
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


    public static void main(String[] args) {
        int nums[] = {1, 4, 2, 6, 0};
        for (int num : nums) System.out.printf("%d--", num);
        System.out.println();
        //mao_pao(nums);    //冒泡
        //insert_sort(nums);    //插入
        //he_bing(nums);    //合并
        //fast_sort(nums);  //快排
        //heap_sort(nums);     //堆排序
        计数排序(nums);
        for (int num : nums) System.out.printf("%d--", num);
        System.out.println("\n如有报错或排序错误，请告知!");
    }
}
