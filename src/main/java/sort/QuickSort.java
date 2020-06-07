package sort;

import java.util.Arrays;

/**
 * Created by longyun on 2018/10/26.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 2, 4, 1, 2, 1, 6, 5};
        int low = 0;
        int high = nums.length - 1;
        quickSort(nums, low, high);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 快速排序：从小往大排序
     */
    public static void quickSort(int[] nums, int low, int high) {
        //if循环条件
        if (low < high) {
            int pos = partition(nums, low, high);
            quickSort(nums, low, pos - 1);
            quickSort(nums, pos + 1, high);
        }
    }

    public static int partition(int[] nums, int low, int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            //从左往右，找到第一个比基准元素大的元素  （注意，是++i）
            while (nums[++i] < nums[low] && i < high) ;

            //从右往左，找到第一个比基准元素小的元素  （注意，是--j）
            while (nums[--j] > nums[low] && j > low) ;

            if (i < j) {
                swap(nums, i, j);
            } else {
                //循环终止的条件 i>=j
                break;
            }
        }
        //交换low，j位置的元素
        swap(nums, low, j);
        //返回j的位置
        return j;
    }

    //将第i和第j个元素交换位置
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
