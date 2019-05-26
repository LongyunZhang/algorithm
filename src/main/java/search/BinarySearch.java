package search;

/**
 * Created by longyun on 2018/10/28.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,3,4,5,5,6,6,9};
        int res = findFirstEqual(nums, 3);
        System.out.println(res);
    }

    private static int binarySearch(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 数组有重复元素，查找第一个与target相等的元素索引
     * [1,3,3,3,4,5]
     */
    private static int findFirstEqual(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) {
                if (nums[begin] == target) {
                    return begin;
                }
                //缺点，只用了一次二分
                while (mid >= 0 && nums[--mid] == target);
                return mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return -1;
    }
}
