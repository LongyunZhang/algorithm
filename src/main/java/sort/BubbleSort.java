package sort;

import java.util.Arrays;

/**
 * 冒泡排序：
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 *
 * 平均时间复杂度：O(n*n)，最好O(n)，最坏O(n*n)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 1, 2, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 从小到大排序
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {//总共len-1轮比较（最后只剩1个数字的时候，无需比较）
            for (int j = 0; j < arr.length - 1 - i; j++) {//在第i轮比较完成之后，最后边的i个数字已经排好序了，所以只需比较前边的数字
                if (arr[j] > arr[j + 1]) {//将较大的值移到后边
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    /**
     * 自小到大排序
     */
    public static int[] sort2(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }
}
